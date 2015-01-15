package exceptions;

/**
 * RUN:
 *         javac exceptions/WhoCalled.java && java exceptions.WhoCalled
 * OUTPUT:
 *         f
 *         main
 *         -----------------------------------
 *         f
 *         g
 *         main
 *         -----------------------------------
 *         f
 *         g
 *         h
 *         main
 */

// import java.util.logging.*;
// import java.io.*;


public class WhoCalled {

    static void f() {
        try {
            throw new Exception();
        }
        catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g() { f(); }

    static void h() { g(); }

    public static void main(String[] args) {
        f();
        System.out.println("-----------------------------------");
        g();    
        System.out.println("-----------------------------------");    
        h();
    }
}