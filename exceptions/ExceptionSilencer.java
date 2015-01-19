package exceptions;

/**
 * RUN:
 *         javac exceptions/ExceptionSilencer.java && java exceptions.ExceptionSilencer
 * OUTPUT:
 *         
 */

// import java.util.logging.*;
// import java.io.*;


public class ExceptionSilencer {

    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        }
        finally {
            // break and return
            return;
        }
    }
}