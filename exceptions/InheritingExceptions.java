package exceptions;

/**
 * RUN:
 *         javac exceptions/InheritingExceptions.java && java exceptions.InheritingExceptions
 * OUTPUT:
 *         Initiationg exception SimpleException() from f()
 *         Catched!
 */

import java.util.*;

public class InheritingExceptions {

    public void f() throws SimpleException {
        System.out.println("Initiationg exception SimpleException() from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        }
        catch (SimpleException e) {
            System.out.println("Catched!");
        }
    }
}


class SimpleException extends Exception {}