package exceptions;

/**
 * RUN:
 *         javac exceptions/MultipleReturns.java && java exceptions.MultipleReturns
 * OUTPUT:
 *         Initializing required comletion
 *         First
 *         Comletion
 *         
 *         Initializing required comletion
 *         First
 *         Second
 *         Comletion
 *         
 *         Initializing required comletion
 *         First
 *         Second
 *         Third
 *         Comletion
 *         
 *         Initializing required comletion
 *         First
 *         Second
 *         Third
 *         End
 *         Comletion
 */

// import java.util.logging.*;
// import java.io.*;


public class MultipleReturns {

    public static void f(int i) {
        System.out.println("Initializing required comletion");
        try {
            System.out.println("First");
            if (i == 1) return; 
            System.out.println("Second");
            if (i == 2) return; 
            System.out.println("Third");
            if (i == 3) return; 

            System.out.println("End");
            return;
        }
        finally {
            System.out.println("Comletion");
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            f(i);
        }
    }
}