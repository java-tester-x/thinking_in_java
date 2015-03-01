package arrays;

import java.util.*;
import net.mindview.util.*;

/**
 * RUN:
 *         javac arrays/CompType.java && java arrays.CompType
 * OUTPUT:
 *         before sort:
 *         [[i = 58, j = 55], [i = 93, j = 61], [i = 61, j = 29]
 *         , [i = 68, j = 0], [i = 22, j = 7], [i = 88, j = 28]
 *         , [i = 51, j = 89], [i = 9, j = 78], [i = 98, j = 61]
 *         , [i = 20, j = 58], [i = 16, j = 40], [i = 11, j = 22]
 *         ]
 *         after sort:
 *         [[i = 9, j = 78], [i = 11, j = 22], [i = 16, j = 40]
 *         , [i = 20, j = 58], [i = 22, j = 7], [i = 51, j = 89]
 *         , [i = 58, j = 55], [i = 61, j = 29], [i = 68, j = 0]
 *         , [i = 88, j = 28], [i = 93, j = 61], [i = 98, j = 61]
 *         ]
 */


// Using Comparable interface

public class CompType implements Comparable<CompType> {

    int i;
    int j;

    private static int count = 1;

    public CompType(int n1, int n2) {
        i = n1;
        j = n2;
    }

    public String toString() {
        String result = "[i = "+ i + ", j = "+ j + "]";
        if (count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }

    public int compareTo(CompType rv) {
        return (i < rv.i ? -1 : (i == rv.i ? 0 : 1)) ;
    }

    private static Random r = new Random(47);

    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            public CompType next() {
                return new CompType(r.nextInt(100), r.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], generator());
        System.out.println("before sort:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("after sort:");
        System.out.println(Arrays.toString(a));
    }
}