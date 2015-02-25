package arrays;

import java.util.*;

/**
 * RUN:
 *         javac arrays/ThreeDWithNew.java && java arrays.ThreeDWithNew
 * OUTPUT:
 *         [[[0, 0, 0, 0], [0, 0, 0, 0]], [[0, 0, 0, 0], [0, 0, 0, 0]]]
 */

public class ThreeDWithNew {

    public static void main(String[] args) {
        int[][][] a = new int[2][2][4];
        System.out.println(Arrays.deepToString(a));
    }
}