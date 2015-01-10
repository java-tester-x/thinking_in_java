package holding;

/**
 * RUN:
 *         javac holding/ForEachCollections.java && java holding.ForEachCollections
 * OUTPUT:
 *         'Take' 'the' 'long' 'way' 'home'
 */

import java.util.*;

public class ForEachCollections {
    
    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<String>();
        Collections.addAll(cs, "Take the long way home".split(" "));    
        for (String s : cs) {
            System.out.print("'" + s +"' ");
        }
        System.out.println();
    }
}