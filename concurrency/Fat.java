package concurrency;

import java.util.concurrent.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/Fat.java && java concurrency.Fat
 *         
 * OUTPUT:
 *         
 */

public class Fat {

    private volatile double d;

    private static int counter = 0;

    private final int id = counter++;

    public Fat() {
        for (int i = 1; i < 10000; i++) {
            d += (Math.PI + Math.E) / (double) i;
        }
    }

    public void operation() { System.out.println(this); }

    public String toString() { return String.format("Fat id: %1$d", id); }
}