package generics;

import java.util.*;
import net.mindview.util.*;

/**
 * RUN:
 *         javac generics/TupleList.java && java generics.TupleList
 * OUTPUT:
 *         (generics.Vehicle@a83b8a, generics.Amphibian@dd20f6, hi, 47)
 *         (generics.Vehicle@19efb05, generics.Amphibian@723d7c, hi, 47)
 */

public class TupleList<A,B,C,D> extends ArrayList<FourTuple<A,B,C,D>> {

    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = 
            new TupleList<Vehicle, Amphibian, String, Integer>();

        tl.add(TupleTest.h());
        tl.add(TupleTest.h());

        for (FourTuple<Vehicle, Amphibian, String, Integer> i : tl) {
            System.out.println(i);
        }
    }
}