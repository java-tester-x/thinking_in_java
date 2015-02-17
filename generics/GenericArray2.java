package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/GenericArray2.java && java generics.GenericArray2
 * OUTPUT:
 *        0 1 2 3 4 5 6 7 8 9
 *        java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
 */

public class GenericArray2<T> {

    private Object[] array;

    
    public GenericArray2(int size) {
        array = new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() { return (T[])array; }


    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<Integer>(10);

        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(gai.get(i) + " ");
        }
        System.out.println();


        try {
            Integer[] a = gai.rep();
        }
        catch (Exception e) {
            System.out.println(e);
        }      
    }
}