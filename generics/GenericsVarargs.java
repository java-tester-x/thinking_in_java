package generics;

import java.util.*;

/**
 * RUN:
 *         javac generics/GenericsVarargs.java && java generics.GenericsVarargs
 * OUTPUT:
 *         Note: generics\GenericsVarargs.java uses unchecked or unsafe operations.
 *         Note: Recompile with -Xlint:unchecked for details.
 *         [A]
 *         [A, B, C]
 *         [, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]
 */

public class GenericsVarargs {

    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<T>();
        for (T item : args) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);

        ls = makeList("A", "B", "C");
        System.out.println(ls);

        ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
}