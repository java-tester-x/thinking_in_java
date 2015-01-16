package exceptions;

/**
 * RUN:
 *         javac exceptions/RethrowNew.java && java exceptions.RethrowNew
 * OUTPUT:
 *         creating exception from f()
 *         In inner "try" section: e.printStackTrace()
 *         exceptions.OneException: thrown from f()
 *                 at exceptions.RethrowNew.f(RethrowNew.java:25)
 *                 at exceptions.RethrowNew.main(RethrowNew.java:31)
 *         In outer "try" section: e.printStackTrace()
 *         exceptions.TwoException: thrown from inner "try" section
 *                 at exceptions.RethrowNew.main(RethrowNew.java:36)
 */

// import java.util.logging.*;
// import java.io.*;


public class RethrowNew {

    public static void f() throws OneException {
        System.out.println("creating exception from f()");
        throw new OneException("thrown from f()");        
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            }
            catch(OneException e) {
                System.out.println("In inner \"try\" section: e.printStackTrace() ");
                e.printStackTrace(System.out);
                throw new TwoException("thrown from inner \"try\" section");
            }
        }
        catch(TwoException e) {
            System.out.println("In outer \"try\" section: e.printStackTrace() ");
            e.printStackTrace(System.out);
        }
    }
}

class OneException extends Exception {
    public OneException(String s) { super(s); }
}

class TwoException extends Exception {
    public TwoException(String s) { super(s); }
}