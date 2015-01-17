package exceptions;

/**
 * RUN:
 *         javac exceptions/NeverCaught.java && java exceptions.NeverCaught
 * OUTPUT:
 *         
 */

// import java.util.logging.*;
// import java.io.*;


public class NeverCaught {

    static void f() {
        throw new RuntimeException("from f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}

/*
Exception in thread "main" java.lang.RuntimeException: from f()
        at exceptions.NeverCaught.f(NeverCaught.java:17)
        at exceptions.NeverCaught.g(NeverCaught.java:21)
        at exceptions.NeverCaught.main(NeverCaught.java:25)
*/