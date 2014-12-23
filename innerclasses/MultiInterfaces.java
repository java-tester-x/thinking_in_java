package innerclasses;

/**
 * RUN:
 *         javac innerclasses/MultiInterfaces.java && java innerclasses.MultiInterfaces
 * OUTPUT:
 *         takesA(X())
 *         takesA(Y())
 *         takesB(X())
 *         takesB(innerclasses.Y$1@1d5550d)
 */

public class MultiInterfaces {

    static void takesA(A a) { System.out.println("takesA("+a+")"); }
    
    static void takesB(B b) { System.out.println("takesB("+b+")"); }

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();

        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }
}

interface A {}

interface B {}

class X implements A, B {
    public String toString() { return "X()";} 
}

class Y implements A {

    B makeB() {
        return new B() {};
    }

    public String toString() { return "Y()";} 
}