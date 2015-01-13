package exceptions;

/**
 * RUN:
 *         javac exceptions/FullConstructors.java && java exceptions.FullConstructors
 * OUTPUT:
 *         Initiating MyException from f()
 *         exceptions.MyException
 *                 at exceptions.FullConstructors.f(FullConstructors.java:16)
 *                 at exceptions.FullConstructors.main(FullConstructors.java:27)
 *                 
 *         Initiating MyException from g()
 *         exceptions.MyException: Created in g()
 *                 at exceptions.FullConstructors.g(FullConstructors.java:21)
 *                 at exceptions.FullConstructors.main(FullConstructors.java:34)
 */

import java.util.*;

public class FullConstructors {

    public static void f() throws MyException {
        System.out.println("Initiating MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Initiating MyException from g()");
        throw new MyException("Created in g()");
    }

    public static void main(String[] args)
    {
        try {
            f();
        }
        catch (MyException e) {
            e.printStackTrace(System.err);
        }

        try {
            g();
        }
        catch (MyException e) {
            e.printStackTrace(System.err);
        }
    }
}


class MyException extends Exception {
    
    public MyException() {}
    
    public MyException(String msg) {
        super(msg);
    }
}