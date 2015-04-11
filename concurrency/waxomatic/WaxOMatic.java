package concurrency.waxomatic;

import java.util.concurrent.*;
import java.util.*;

/**
 * RUN:
 *         javac concurrency/waxomatic/WaxOMatic.java && java concurrency.waxomatic.WaxOMatic
 *         
 * OUTPUT:
 *         Wax On!
 *         Wax Off!
 *         Wax On!
 *         Wax Off!
 *         Wax On!
 *         Wax Off!
 *         Wax On!
 *         Wax Off!
 *         Wax On!
 *         Wax Off!
 *         Wax On!
 *         Wax Off!
 *         Wax On!
 *         Wax Off!
 *         Wax On!
 *         Wax Off!
 *         Wax On!
 *         Wax Off!
 *         Wax On!
 *         Wax Off!
 *         Wax On!
 *         Wax Off!
 *         Wax On!
 *         Wax Off!
 *         Wax On!
 *         Exiting via interrupt
 *         Ending Wax On task
 *         Exiting via interrupt
 *         Ending Wax Off task
 */

public class WaxOMatic {

    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));
        

        TimeUnit.SECONDS.sleep(5);  // a litle delay
        exec.shutdownNow(); // interrupt all threads
    }
}



class Car {

    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn == true) {
            wait();
        }
    }
}

class WaxOn implements Runnable {

    private Car car;

    public WaxOn(Car c) { car = c; }

    public void run() {
        try {
            while (! Thread.interrupted()) {
                System.out.println("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }
        catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff implements Runnable {

    private Car car;

    public WaxOff(Car c) { car = c; }

    public void run() {
        try {
            while (! Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }
        catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}
