package typeinfo;

import typeinfo.interfacea.*;

/**
 * RUN:
 *         javac typeinfo/InterfaceViolation.java && java typeinfo.InterfaceViolation
 * OUTPUT:
 *         
 */

public class InterfaceViolation {

    public static void main(String[] args) {
        A a = new B();
        a.f();

        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B)a;
            b.g();
        }
    }
}

class B implements A {
    public void f() { System.out.println("f()"); }
    public void g() { System.out.println("g()"); }
}