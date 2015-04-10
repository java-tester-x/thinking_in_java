package concurrency.waxomatic;

import java.util.concurrent.*;
import java.util.*;

/**
 * RUN:
 *         javac concurrency/waxomatic/WaxOMatic.java && java concurrency.waxomatic.WaxOMatic
 *         
 * OUTPUT:
 *         
 */

public class WaxOMatic {

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

class EaxOn implements Runnable {

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
        catch () {

        }
    }
}