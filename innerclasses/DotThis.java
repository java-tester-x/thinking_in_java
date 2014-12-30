package innerclasses;

/**
 * RUN:
 *         javac innerclasses/DotThis.java && java innerclasses.DotThis
 * OUTPUT:
 *         DoThis.f()
 */

public class DotThis {

    void f() { System.out.println(getClass().getSimpleName() + ".f()"); }

    public class Inner {

        public DotThis outer() {
            return DotThis.this; // be carefully and use exactly "DotThis.this" 
        }
    }

    public Inner inner() { return new Inner(); }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}