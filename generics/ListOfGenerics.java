package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/ListOfGenerics.java
 * OUTPUT:
 *         
 */

public class ListOfGenerics<T> {


    private List<T> array = new ArrayList<T>();

    public void add(T item) { array.add(item); }

    public T get(int index) { return array.get(index); }
}