package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;


/**
 * RUN:
 *         javac concurrency/MutexEvenGenerator.java && java concurrency.MutexEvenGenerator
 *         
 * OUTPUT:
 *         
 */

public class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    private Lock lock = new ReentrantLock();

    public int next() {
        
        lock.lock();

        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}