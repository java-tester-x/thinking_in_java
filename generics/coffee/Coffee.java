package generics.coffee;

import java.util.*;

/**
 * RUN:
 *         javac generics/coffee/Coffee.java
 * OUTPUT:
 *         
 */

public class Coffee {

    private static long counter = 0;

    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}