package interfaces;

import java.util.*;

/**
 * COMPILE:
 *         javac interfaces/InterfaceCollision.java
 * OUTPUT:
 *         interfaces\InterfaceCollision.java:55: error: C5 is not abstract and does not override abstract method f() in I1
 *         class C5 extends C implements I1 {
 *         ^
 *         interfaces\InterfaceCollision.java:59: error: types I3 and I1 are incompatible; both define f(), but with unrelated return types
 *         interface I4 extends I1, I3 {
 *         ^
 *         2 errors
 *         
 * TO FIX ERRORS: comment code for class C5 and interface  I4
 */

interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}

interface I3 {
    int f();
}

class C {

    public int f() {
        return 1;
    }
}

class C2 implements I1, I2 {

    public void f() {
    }

    public int f(int i) {
        return i;
    }
}

class C3 extends C implements I2 {

    public int f(int i) {
        return i;
    }
}

class C4 extends C implements I3 {

    public int f() {
        return 1;
    }
}

// class C5 extends C implements I1 {

// }

// interface I4 extends I1, I3 {

// }