package exceptions;

/**
 * RUN:
 *         javac exceptions/Rethrowing.java && java exceptions.Rethrowing
 * OUTPUT:
 *         Creating exception in f()
 *         In method g(): e.printStackTrace()
 *         java.lang.Exception: thrown from f()
 *                 at exceptions.Rethrowing.f(Rethrowing.java:38)
 *                 at exceptions.Rethrowing.g(Rethrowing.java:43)
 *                 at exceptions.Rethrowing.main(Rethrowing.java:66)
 *         main: printStackTrace()
 *         java.lang.Exception: thrown from f()
 *                 at exceptions.Rethrowing.f(Rethrowing.java:38)
 *                 at exceptions.Rethrowing.g(Rethrowing.java:43)
 *                 at exceptions.Rethrowing.main(Rethrowing.java:66)
 *         Creating exception in f()
 *         In method h(): e.printStackTrace()
 *         java.lang.Exception: thrown from f()
 *                 at exceptions.Rethrowing.f(Rethrowing.java:38)
 *                 at exceptions.Rethrowing.h(Rethrowing.java:54)
 *                 at exceptions.Rethrowing.main(Rethrowing.java:74)
 *         main: printStackTrace()
 *         java.lang.Exception: thrown from f()
 *                 at exceptions.Rethrowing.h(Rethrowing.java:59)
 *                 at exceptions.Rethrowing.main(Rethrowing.java:74)
 */

// import java.util.logging.*;
// import java.io.*;


public class Rethrowing {

    public static void f() throws Exception {
        System.out.println("Creating exception in f()");
        throw new Exception("thrown from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        }
        catch(Exception e) {
            System.out.println("In method g(): e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        }
        catch(Exception e) {
            System.out.println("In method h(): e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception)e.fillInStackTrace();
        }
    }

    public static void main(String[] args)
    {
        try {
            g();
        }
        catch(Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

        try {
            h();
        }
        catch(Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}