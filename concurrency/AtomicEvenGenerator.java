package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/AtomicEvenGenerator.java && java concurrency.AtomicEvenGenerator
 *         
 * OUTPUT:
 *         
 */

public class AtomicEvenGenerator extends IntGenerator {

    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}