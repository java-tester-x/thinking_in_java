package generics;

import net.mindview.util.*;
/**
 * RUN:
 *         javac generics/TupleTest.java && java generics.TupleTest
 * OUTPUT:
 *         (hi, 47)
 *         (generics.Amphibian@422ede, hi, 47)
 *         (generics.Vehicle@110b053, generics.Amphibian@a83b8a, hi, 47)
 *         (generics.Vehicle@a981ca, generics.Amphibian@8814e9, hi, 47, 11.1)
 */

public class TupleTest {

    static TwoTuple<String, Integer> f() {
        return new TwoTuple<String, Integer>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<Vehicle, Amphibian, String, Integer>(
            new Vehicle(), new Amphibian(), "hi", 47
        );
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTuple<Vehicle, Amphibian, String, Integer, Double>(
            new Vehicle(), new Amphibian(), "hi", 47, 11.1
        );
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);

        //  error: cannot assign a value to final variable first
        // ttsi.first = "there";

        System.out.println(g());        
        System.out.println(h());        
        System.out.println(k());        
    }
}


class Amphibian {}

class Vehicle {}