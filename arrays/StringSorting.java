package arrays;

import java.util.*;
import net.mindview.util.*;

/**
 * RUN:
 *         javac arrays/StringSorting.java && java arrays.StringSorting
 * OUTPUT:
 *         before sort: [YNzbr, nyGcF, OWZnT, cQrGs, eGZMm, JMRoE, suEcU, OneOE, dLsmw, HLGEa, hKcxr,
 *                       EqUCB, bkIna, Mesbt, WHkjU, rUkZP, gwsqP, zDyCy, RFJQA, HxxHv]
 *         after sort:  [EqUCB, HLGEa, HxxHv, JMRoE, Mesbt, OWZnT, OneOE, RFJQA, WHkjU, YNzbr, bkIna,
 *                       cQrGs, dLsmw, eGZMm, gwsqP, hKcxr, nyGcF, rUkZP, suEcU, zDyCy]
 *         reverse sort: [zDyCy, suEcU, rUkZP, nyGcF, hKcxr, gwsqP, eGZMm, dLsmw, cQrGs, bkIna, YNzbr,
 *                        WHkjU, RFJQA, OneOE, OWZnT, Mesbt, JMRoE, HxxHv, HLGEa, EqUCB]
 *         case-insensitive sort: [bkIna, cQrGs, dLsmw, eGZMm, EqUCB, gwsqP, hKcxr, HLGEa, HxxHv, JMRoE,
 *                                 Mesbt, nyGcF, OneOE, OWZnT, RFJQA, rUkZP, suEcU, WHkjU, YNzbr, zDyCy]
 */


// Using Comparable interface

public class StringSorting {

    public static void main(String[] args) {
        String[] sa = Generated.array(new String[20], new RandomGenerator.String(5));
        System.out.println("before sort: " + Arrays.toString(sa));
        
        Arrays.sort(sa);
        System.out.println("after sort: " + Arrays.toString(sa));

        Arrays.sort(sa, Collections.reverseOrder());
        System.out.println("reverse sort: " + Arrays.toString(sa));
        
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitive sort: " + Arrays.toString(sa));
    }
}