package holding;

/**
 * RUN:
 *         javac holding/ModifyingArraysAsList.java && java holding.ModifyingArraysAsList
 * OUTPUT:
 *         Before shuffle: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 *         After shuffle: [4, 6, 3, 1, 8, 7, 2, 5, 10, 9]
 *         Array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 *         Before shuffle: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 *         After shuffle: [9, 1, 6, 3, 7, 2, 5, 10, 4, 8]
 *         Array: [9, 1, 6, 3, 7, 2, 5, 10, 4, 8]
 */

import java.util.*;

public class ModifyingArraysAsList {

    public static void main(String[] args) {
        Random rand = new Random(47);

        Integer[] ia = {1,2,3,4,5,6,7,8,9,10};
        
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(ia));
        System.out.println("Before shuffle: " + list1);
        Collections.shuffle(list1, rand);
        System.out.println("After shuffle: " + list1);
        System.out.println("Array: " + Arrays.toString(ia));
        
        List<Integer> list2 = Arrays.asList(ia);
        System.out.println("Before shuffle: " + list2);
        Collections.shuffle(list2, rand);
        System.out.println("After shuffle: " + list2);
        System.out.println("Array: " + Arrays.toString(ia));        
    }
}