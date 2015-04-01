package concurrency;

import java.io.*;
import java.util.concurrent.*;
import net.mindview.util.*;


/**
 * RUN:
 *         javac concurrency/DaemonFromFactory.java && java concurrency.DaemonFromFactory
 *         
 * OUTPUT:
 *         
 */

public class DaemonFromFactory implements Runnable {

    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(
            new DaemonThreadFactory()
        );

        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }

        System.out.println("All daemons are running");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}