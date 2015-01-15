package exceptions;

/**
 * RUN:
 *         javac exceptions/ExtraFeatures.java && java exceptions.ExtraFeatures
 * OUTPUT:
 *         MyException2 in f()
 *         exceptions.MyException2: Detailed message: 0 null
 *                 at exceptions.ExtraFeatures.f(ExtraFeatures.java:18)
 *                 at exceptions.ExtraFeatures.main(ExtraFeatures.java:33)
 *         MyException2 in g()
 *         exceptions.MyException2: Detailed message: 0 Initiated in g()
 *                 at exceptions.ExtraFeatures.g(ExtraFeatures.java:23)
 *                 at exceptions.ExtraFeatures.main(ExtraFeatures.java:40)
 *         MyException2 in h()
 *         exceptions.MyException2: Detailed message: 47 Initiated in h()
 *                 at exceptions.ExtraFeatures.h(ExtraFeatures.java:28)
 *                 at exceptions.ExtraFeatures.main(ExtraFeatures.java:47)
 *         e.val() = 47
 */

// import java.util.logging.*;
// import java.io.*;


public class ExtraFeatures {

    public static void f() throws MyException2 {
        System.out.println("MyException2 in f()");
        throw new MyException2();
    }

    public static void g() throws MyException2 {
        System.out.println("MyException2 in g()");
        throw new MyException2("Initiated in g()");
    }

    public static void h() throws MyException2 {
        System.out.println("MyException2 in h()");
        throw new MyException2("Initiated in h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        }
        catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        
        try {
            g();
        }
        catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        
        try {
            h();
        }
        catch (MyException2 e) {
            e.printStackTrace(System.out);
            System.out.println("e.val() = "+e.val());
        }
    }
}

class MyException2 extends Exception {

    private int x;

    public MyException2() {}

    public MyException2(String msg) {
        super(msg);
    }

    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }

    public int val() { return x; }

    public String getMessage() {
        return "Detailed message: " + x + " " + super.getMessage();
    }
}