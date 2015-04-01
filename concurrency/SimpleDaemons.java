package concurrency;

import java.io.*;
import java.util.concurrent.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/SimpleDaemons.java && java concurrency.SimpleDaemons
 *         
 * OUTPUT:
 *         
 */

public class SimpleDaemons implements Runnable {

    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch(InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }

        System.out.println("All daemons are running");
        TimeUnit.MILLISECONDS.sleep(200);
    }
}