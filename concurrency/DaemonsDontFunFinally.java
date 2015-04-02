package concurrency;

import java.io.*;
import java.util.concurrent.*;
import net.mindview.util.*;


/**
 * RUN:
 *         javac concurrency/DaemonsDontFunFinally.java && java concurrency.DaemonsDontFunFinally
 *         
 * OUTPUT:
 *
 */

public class DaemonsDontFunFinally {
    
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();

        // TimeUnit.SECONDS.sleep(1);
    }
}


class ADaemon implements Runnable {

    public void run() {
        try {
            System.out.println("run ADaemon");
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e) {
            System.out.println("Exit through InterruptedException");
        }
        finally {
            System.out.println("Must always executed?");
        }
    }
}