package typeinfo;

import typeinfo.packageaccess.*;
import typeinfo.interfacea.*;

import java.lang.reflect.*;

/**
 * RUN:
 *         javac typeinfo/HiddenImplementation.java && java typeinfo.HiddenImplementation
 * OUTPUT:
 *         public C.f()
 *         typeinfo.packageaccess.C
 *         package C.u()
 *         protected C.v()
 *         private C.w()
 */

public class HiddenImplementation {

    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());

        // Compilation erroe here!
        /*
            if (a instanceof C) {
                C c = (C)a;
                c.g();
            }
        */
        
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}