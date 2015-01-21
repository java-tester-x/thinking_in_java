package exceptions;

/**
 * RUN:
 *         javac exceptions/CleanupIdiom.java && java exceptions.CleanupIdiom
 * OUTPUT:
 *         NeedsCleanup 1 completed
 *         NeedsCleanup 3 completed
 *         NeedsCleanup 2 completed
 *         NeedsCleanup 5 completed
 *         NeedsCleanup 4 completed
 */

// import java.util.logging.*;
// import java.io.*;


public class CleanupIdiom {

    public static void main(String[] args)
    {
        // section 1.
        NeedsCleanup nc1 = new NeedsCleanup();
        try {
            // . . .
        }
        finally {
            nc1.dispose();
        }

        // section 2.
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {
            // . . .
        }
        finally {
            nc3.dispose();
            nc2.dispose();
        }

        // section 3.
        try {
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try {
                    // . . .
                }
                finally {
                    nc5.dispose();
                }
            }
            catch(ConstructionException e) {
                System.out.println(e);
            }
            finally {
                nc4.dispose();
            }    
        }
        catch(ConstructionException e) {
            System.out.println(e);
        }
    }
}

class NeedsCleanup {
    private static long counter = 1;
    private final long id = counter++;

    public void dispose() {
        System.out.println("NeedsCleanup "+ id + " completed");
    }
}

class ConstructionException extends Exception {}

class NeedsCleanup2 extends NeedsCleanup {
    public NeedsCleanup2() throws ConstructionException {}
}