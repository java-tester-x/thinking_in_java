package innerclasses;

/**
 * RUN:
 *         javac innerclasses/MultiImplementation.java && java innerclasses.MultiImplementation
 * OUTPUT:
 *         takesA(X())
 *         takesA(Y())
 *         takesB(X())
 *         takesB(innerclasses.Y$1@1d5550d)
 */

public class MultiImplementation {

    static void takesD(D d) {}
    
    static void takesE(E e) {}

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}

class D {
    public String toString() { return "class D"; }
}

abstract class E {}

class Z extends D {
    
    E makeE() {
        return E() {};
    }
}