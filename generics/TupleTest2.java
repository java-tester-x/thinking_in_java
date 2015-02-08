package generics;

import net.mindview.util.*;
import static net.mindview.util.Tuple.*;
/**
 * RUN:
 *         javac generics/TupleTest2.java && java generics.TupleTest2
 * OUTPUT:
 *         (hi, 47)
 *         (hi, 47)
 *         (generics.Amphibian@723d7c, hi, 47)
 *         (generics.Vehicle@1a1c887, generics.Amphibian@743399, hi, 47)
 *         (generics.Vehicle@fd13b5, generics.Amphibian@118f375, hi, 47, 11.1)
 */

public class TupleTest2 {

    static TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }

    static TwoTuple f2() {
        return tuple("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());        
        System.out.println(h());        
        System.out.println(k());        
    }
}


class Amphibian {}

class Vehicle {}