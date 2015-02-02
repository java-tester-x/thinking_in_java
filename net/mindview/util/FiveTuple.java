package net.mindview.util;

public class FiveTuple<A, B, C, D, F> extends FourTuple<A, B, C, D> {

    public final F fifth;

    public FiveTuple(A a, B b, C c, D d, F f) {
        super(a, b, c, d);
        fifth = f;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ")";
    }
} 