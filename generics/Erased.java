package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/Erased.java
 * OUTPUT:
 *         
 */

// COMPILETIME ERROR !!!

public class Erased<T> {
    
    private final int SIZE = 100;

    public void f(Object arg) {
        if (arg instanceof T) {
            //
        }
        T var = new T();
        T[] array = new T[SIZE];
        T[] array = (T)newObject[SIZE];
    }
}