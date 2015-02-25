package arrays;

import java.util.*;

/**
 * RUN:
 *         javac arrays/MultidimesionalPrimitiveArray.java && java arrays.MultidimesionalPrimitiveArray
 * OUTPUT:
 *         [[I@e53108
 *         [[1, 2, 3], [4, 5, 6]]
 */

public class MultidimesionalPrimitiveArray {

    public static void main(String[] args) {
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6},
        };
        System.out.println(a);
        System.out.println(Arrays.deepToString(a));
    }
}