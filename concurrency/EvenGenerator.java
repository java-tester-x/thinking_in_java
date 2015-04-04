package concurrency;

import java.util.concurrent.*;


/**
 * RUN:
 *         javac concurrency/EvenGenerator.java && java concurrency.EvenGenerator
 *         
 * OUTPUT:
 *         
 */

public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    public int next() {
        ++currentEvenValue;  // Dangerous point !!!
        // Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}