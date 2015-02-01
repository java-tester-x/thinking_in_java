package typeinfo;

import typeinfo.interfacea.*;

import java.lang.reflect.*;

/**
 * RUN:
 *         javac typeinfo/InnerImplementation.java && java typeinfo.InnerImplementation
 * OUTPUT:
 *         public C.f()
 *         typeinfo.InnerA$C
 *         package C.u()
 *         public C.g()
 *         protected C.v()
 *         private C.w()
 */

public class InnerImplementation {

    public static void main(String[] args) throws Exception {
        A a = InnerA.makeA();
        a.f();
        System.out.println(a.getClass().getName());

        // Reflection allow to do this !!!
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}

class InnerA {
    
    private static class C implements A {
        public void f() { System.out.println("public C.f()"); }
        public void g() { System.out.println("public C.g()"); }
        void u() { System.out.println("package C.u()"); }
        protected void v() { System.out.println("protected C.v()"); }
        private void w() { System.out.println("private C.w()"); }
    }

    public static A makeA() { return new C(); }
}