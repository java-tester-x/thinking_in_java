package holding;

/**
 * RUN:
 *         javac holding/PrintingContainers.java && java holding.PrintingContainers
 * OUTPUT:
 *         [rat, cat, dog, dog]
 *         [rat, cat, dog, dog]
 *         [cat, dog, rat]
 *         [cat, dog, rat]
 *         [rat, cat, dog]
 *         {cat=Rags, dog=Spot, rat=Fuzzy}
 *         {cat=Rags, dog=Spot, rat=Fuzzy}
 *         {rat=Fuzzy, cat=Rags, dog=Spot}
 */

import java.util.*;

public class PrintingContainers {

    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<String>()));
        System.out.println(fill(new LinkedList<String>()));
        System.out.println(fill(new HashSet<String>()));
        System.out.println(fill(new TreeSet<String>()));
        System.out.println(fill(new LinkedHashSet<String>()));
        System.out.println(fill(new HashMap<String,String>()));
        System.out.println(fill(new TreeMap<String,String>()));
        System.out.println(fill(new LinkedHashMap<String,String>()));
    }
}