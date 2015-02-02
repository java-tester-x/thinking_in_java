package generics;

/**
 * RUN:
 *         javac generics/Holder1.java && java generics.Holder1
 * OUTPUT:
 *         
 */

public class Holder1 {

    private Automobile a;

    public Holder1(Automobile a) { this.a = a; }

    Automobile get() { return a; }
}

class Automobile {}

