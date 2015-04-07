package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;


/**
 * RUN:
 *         javac concurrency/SerialNumberChecker.java && java concurrency.SerialNumberChecker
 *         
 * OUTPUT:
 *         
 */

public class SerialNumberChecker {

    private static final int SIZE = 10;
    
    private static CircularSet serials = new CircularSet(1000);

    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {
        
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (serials.contains(serial)) {
                    System.out.println("Duplicate: "+serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new SerialChecker());
        }

        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }
    }

}


class CircularSet {

    private int[] array;

    private int len;

    private int index = 0;

    public CircularSet(int size) {
        array = new int[size];
        len = size;
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++) {
            if (array[i] == val) {
                return true;
            }
        }
        return false;
    }
}