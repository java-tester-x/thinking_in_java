package innerclasses;

/**
 * RUN:
 *         javac innerclasses/AnonymousConstructor.java && java innerclasses.AnonymousConstructor
 * OUTPUT:
 *         Constructor Base. i = 47
 *         Initialization instance of inner class
 *         Anonymous f()
 */

public class AnonymousConstructor {

    public static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Initialization instance of inner class");
            }

            public void f() {
                System.out.println("Anonymous f()");    
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}

abstract class Base {

    public Base(int i) {
        System.out.println("Constructor Base. i = " + i);
    }

    public abstract void f();
}