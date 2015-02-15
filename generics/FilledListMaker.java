package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/FilledListMaker.java && java generics.FilledListMaker
 * OUTPUT:
 *         [Hello, Hello, Hello, Hello]
 */

public class FilledListMaker<T> {

    List<T> create(T t, int n) {
        List<T> result = new ArrayList<T>();
        for (int i =0; i < n; i++) {
            result.add(t);
            //System.out.println(t.toUpperCase());
        }
        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> stringMaker = new FilledListMaker<String>();
        List<String> stringList = stringMaker.create("Hello", 4);
        System.out.println(stringList);
    }
}