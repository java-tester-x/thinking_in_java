package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/GenericArray.java && java generics.GenericArray
 * OUTPUT:
 *         
 */

public class GenericArray<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int size) {
        array = (T[])new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() { return array; }


    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<Integer>(10);

        // Exception java.lang.ClassCastException:
        // 
        // [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
        // 
        // Integer[] a = gai.rep();

        Object[] oa = gai.rep();        
    }
}