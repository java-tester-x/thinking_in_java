package exceptions;

/**
 * RUN:
 *         javac exceptions/AlwaysFinally.java && java exceptions.AlwaysFinally
 * OUTPUT:
 *         First "try" begin
 *         Second "try" begin
 *         finally of second "try"
 *         catched FourException in first "try"
 *         finally of first "try"
 */

// import java.util.logging.*;
// import java.io.*;


public class AlwaysFinally {

    public static void main(String[] args) {
        System.out.println("First \"try\" begin");
        try {
            System.out.println("Second \"try\" begin");
            try {
                throw new FourException();
            }
            finally {
                System.out.println("finally of second \"try\"");
            }
        }
        catch(FourException e) {
            System.out.println("catched FourException in first \"try\"");
        }
        finally {
            System.out.println("finally of first \"try\"");
        }
    }
}

class FourException extends Exception {}