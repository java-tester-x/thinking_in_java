package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/ListMaker.java && java generics.ListMaker
 * OUTPUT:
 *         
 */

// @SuppressWarnings("unchecked")
public class ListMaker<T> {

    List<T> create() { return new ArrayList(); }

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<String>();
        List<String> stringList = stringMaker.create();
    }
}