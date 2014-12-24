package polymorphism;

/**
 * RUN:
 *         javac polymorphism/PrivateOverride.java && java polymorphism.PrivateOverride
 * OUTPUT:
 *         private f()
 *         public f()
 */


public class PrivateOverride {

    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        
        // 1. Output: private f()
        po.f();

        // 2. Output: public f()
        ((Derived) po).f();        
    }
}


class Derived extends PrivateOverride {

    public void f() {
        System.out.println("public f()");
    }
}