package holding;

/**
 * RUN:
 *         javac holding/SetOperations.java && java holding.SetOperations
 * OUTPUT:
 *         contains H: true
 *         contains N: false
 *         set2 in set1: true
 *         set1: [D, E, F, G, A, B, C, L, M, I, J, K]
 *         set2 in set1: false
 *         set2 removed from set1: [D, E, F, G, A, B, C, M]
 *         'X Y Z' added to set1: [D, E, F, G, A, B, C, M, Y, X, Z]
 */

import java.util.*;

public class SetOperations {

    private static void print(Object obj) {
        System.out.print(obj);
    }

    private static void println(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<String>();
        Collections.addAll(set1, "A B C D E F G H I J K L".split(" "));
        set1.add("M");
        println("contains H: " + set1.contains("H"));
        println("contains N: " + set1.contains("N"));

        Set<String> set2 = new HashSet<String>();
        Collections.addAll(set2, "H I J K L".split(" "));
        println("set2 in set1: "+set1.containsAll(set2));

        set1.remove("H");
        println("set1: " + set1);
        println("set2 in set1: " + set1.containsAll(set2));

        set1.removeAll(set2);
        println("set2 removed from set1: " + set1);

        Collections.addAll(set1, "X Y Z".split(" "));
        println("'X Y Z' added to set1: " + set1);
    }
}