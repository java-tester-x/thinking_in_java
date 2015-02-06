package generics;

import java.util.*;

import net.mindview.util.*;

/**
 * RUN:
 *         javac generics/GenericMethod.java && java generics.GenericMethod
 * OUTPUT:
 *         java.lang.String
 *         java.lang.Integer
 *         java.lang.Double
 *         java.lang.Float
 *         java.lang.Character
 *         generics.GenericMethod
 */

public class GenericMethod {

    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }
}