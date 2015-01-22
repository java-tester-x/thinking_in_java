package exceptions;

/**
 * RUN:
 *         javac exceptions/Human.java && java exceptions.Human
 * OUTPUT:
 *         exceptions\Human.java:25: warning: unreachable catch clause
 *                 catch(Annoyance a) {
 *                 ^
 *           thrown type Sneeze has already been caught
 *         1 warning
 *         
 *         Catched Sneeze
 *         Catched Annoyance
 */

// import java.util.logging.*;
// import java.io.*;


public class Human {

    public static void main(String[] args)
    {
        // catch original exception
        try {
            throw new Sneeze();
        }
        catch(Sneeze s) {
            System.out.println("Catched Sneeze");
        }
        catch(Annoyance a) {
            System.out.println("Catched Annoyance");
        }

        // catch base exception
        try {
            throw new Sneeze();
        }
        catch(Annoyance a) {
            System.out.println("Catched Annoyance");
        }
    }
}

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}