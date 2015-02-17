package generics;

import java.util.*;
import java.lang.reflect.*;

/**
 * RUN:
 *         javac generics/GenericArrayWithTypeToken.java && java generics.GenericArrayWithTypeToken
 * OUTPUT:
 *        
 */

public class GenericArrayWithTypeToken<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int size) {
        array = (T[])Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<Integer>(Integer.class, 10);

        // This now works:
        Integer[] ia = gai.rep();
    }
}