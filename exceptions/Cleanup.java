package exceptions;

/**
 * RUN:
 *         javac exceptions/Cleanup.java && java exceptions.Cleanup
 * OUTPUT:
 *         dispose() success
 */

// import java.util.logging.*;
// import java.io.*;


public class Cleanup {

    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("exceptions/Cleanup.java");
            try {
                String s;
                int i = 1;
                while( (s = in.getLine()) != null) {
                    //
                }
            }
            catch(Exception e) {
                System.out.println("Catched Exception from main()");
                e.printStackTrace(System.out);
            }
            finally {
                in.dispose();
            }
        }
        catch(Exception e) {
            System.out.println("InputFile constructing error!");
        }
    }
}