package concurrency;

import java.io.*;
import java.util.concurrent.*;
import net.mindview.util.*;


/**
 * RUN:
 *         javac concurrency/Joining.java && java concurrency.Joining
 *         
 * OUTPUT:
 *         Grumpy was interrupted  isInterrupted(): false
 *         Doc join completed
 *         Sleepy working
 *         Dopey join completed
 */

public class Joining {

    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 2500);
        Sleeper grumpy = new Sleeper("Grumpy", 2500);

        Joiner dopey = new Joiner("Dopey", sleepy);
        Joiner doc   = new Joiner("Doc", grumpy);

        grumpy.interrupt();
    }
}


class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try {
            sleep(duration);
        }
        catch (InterruptedException e) {
            System.out.println(
                getName() + " was interrupted "
                + " isInterrupted(): "+isInterrupted()
            );
            return;
        }

        System.out.println(getName() + " working");
    }
}


class Joiner extends Thread {

    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run() {
        try {
            sleeper.join();
        }
        catch (InterruptedException e) {
            System.out.println(getName() +" interrupted");
        }
        System.out.println(getName() +" join completed");
    }
}