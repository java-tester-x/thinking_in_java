package exceptions;

/**
 * RUN:
 *         javac exceptions/FinallyWorks.java && java exceptions.FinallyWorks
 * OUTPUT:
 *         ThreeException
 *         finally scope
 *         No exception
 *         finally scope
 */

// import java.util.logging.*;
// import java.io.*;


public class FinallyWorks {

    static int count = 0;

    public static void main(String[] args)
    {
        while(true)
        {
            try {
                if (count++ == 0) {
                    throw new ThreeException();
                }
                System.out.println("No exception");
            }
            catch(ThreeException e) {
                System.out.println("ThreeException");
            }
            finally {
                System.out.println("finally scope");
                if (count == 2) {
                    break;
                }
            }
        }
    }
}

class ThreeException extends Exception {}