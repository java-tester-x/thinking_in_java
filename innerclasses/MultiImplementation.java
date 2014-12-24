package innerclasses;

/**
 * RUN:
 *         javac innerclasses/MultiImplementation.java && java innerclasses.MultiImplementation
 * OUTPUT:
 *         g()
 */

public class MultiImplementation {

    static void takesD(D d) {}
    
    static void takesE(E e) { e.g(); }

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());        
    }
}

class D {
    public String toString() { return "class D"; }
}

abstract class E {
    public void g() { System.out.println("g()"); }
}

class Z extends D {
    
    E makeE() {
        return new E() {};
    }
}