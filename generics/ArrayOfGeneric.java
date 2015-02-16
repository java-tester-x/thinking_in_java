package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/ArrayOfGeneric.java && java generics.ArrayOfGeneric
 * OUTPUT:
 *         Generic[]
 */

public class ArrayOfGeneric {

    static final int SIZE = 100;

    static Generic<Integer>[] gia;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Exception java.lang.ClassCastException:
        // 
        // [Ljava.lang.Object; cannot be cast to [Lgenerics.Generic;
        // 
        // gia = (Generic<Integer>[]) new Object[SIZE];
        
  
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();


        // incompatible types:
        // 
        // required: Generic<Integer>
        // found:    Object
        // 
        // gia[1] = new Object();


        // incompatible types^
        // 
        // required: Generic<Integer>
        // found:    Generic<Double>
        // 
        // gia[2] = new Generic<Double>();
    }
}