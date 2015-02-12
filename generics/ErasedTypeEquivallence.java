package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/ErasedTypeEquivallence.java && java generics.ErasedTypeEquivallence
 * OUTPUT:
 *         
 */

public class ErasedTypeEquivallence {

    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1==c2);
    }
}