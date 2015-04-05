package concurrency;

import java.util.concurrent.*;


/**
 * RUN:
 *         javac concurrency/SynchronizedEvenGenerator.java && java concurrency.SynchronizedEvenGenerator
 *         
 * OUTPUT:
 *         
 */

public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();  // fire failure
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}