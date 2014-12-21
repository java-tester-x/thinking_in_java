package innerclasses;

/**
 * RUN:
 *         javac innerclasses/MultiNestingAccess.java && java innerclasses.MultiNestingAccess
 * OUTPUT:
 *         g()
 *         f()
 */

public class MultiNestingAccess {

    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();

        mnaab.h();
    }
}


class MNA {

    private void f() { System.out.println("f()"); }

    class A {

        private void g() { System.out.println("g()"); }

        public class B {

            void h() {
                g();
                f();
            }
        }
    }
}