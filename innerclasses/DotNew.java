package innerclasses;

/**
 * RUN:
 *         javac innerclasses/DotNew.java && java innerclasses.DotNew
 * OUTPUT:
 *         Inner.f()
 */

public class DotNew {

    public class Inner {
        public void f() { System.out.println(getClass().getSimpleName() + ".f()"); }
    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
        dni.f();
    }
}