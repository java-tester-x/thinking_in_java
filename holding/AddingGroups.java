package holding;

/**
 * RUN:
 *         javac holding/AddingGroups.java && java holding.AddingGroups
 * OUTPUT:
 *         1. collection:
 *         [1, 2, 3, 4, 5]
 *         2. collection:
 *         [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 *         3. collection:
 *         [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
 *         4. collection:
 *         [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 6, 7, 8, 9, 10]
 *         1. list:
 *         [16, 17, 18, 19, 20]
 *         2. list:
 *         [16, 99, 18, 19, 20]
 *         Exception in thread "main" java.lang.UnsupportedOperationException
 *                 at java.util.AbstractList.add(Unknown Source)
 *                 at java.util.AbstractList.add(Unknown Source)
 *                 at holding.AddingGroups.main(AddingGroups.java:42)
 */

import java.util.*;

public class AddingGroups {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};

        System.out.println("1. collection:");
        System.out.println(collection);

        collection.addAll(Arrays.asList(moreInts));

        System.out.println("2. collection:");
        System.out.println(collection);

        Collections.addAll(collection, 11, 12, 13, 14, 15);
        System.out.println("3. collection:");
        System.out.println(collection);

        Collections.addAll(collection, moreInts);
        System.out.println("4. collection:");
        System.out.println(collection);

        List<Integer> list = Arrays.asList(16, 17,18, 19, 20);
        System.out.println("1. list:");
        System.out.println(list);

        list.set(1, 99);
        System.out.println("2. list:");
        System.out.println(list);

        list.add(21);  // run-time error here !
    }
}