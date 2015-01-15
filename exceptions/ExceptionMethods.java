package exceptions;

/**
 * RUN:
 *         javac exceptions/ExceptionMethods.java && java exceptions.ExceptionMethods
 * OUTPUT:
 *         Catched!
 *         getMessage(): My Exception
 *         getLocalizedMessage(): My Exception
 *         toString(): java.lang.Exception: My Exception
 *         printStackTrace():
 *         java.lang.Exception: My Exception
 *                 at exceptions.ExceptionMethods.main(ExceptionMethods.java:18)
 */

// import java.util.logging.*;
// import java.io.*;


public class ExceptionMethods {

    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        }
        catch (Exception e) {
            System.out.println("Catched!");
            System.out.println("getMessage(): " + e.getMessage());
            System.out.println("getLocalizedMessage(): " + e.getLocalizedMessage());
            System.out.println("toString(): " + e);
            System.out.println("printStackTrace(): ");
            e.printStackTrace(System.out);
        }
    }
}