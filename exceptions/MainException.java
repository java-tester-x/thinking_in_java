package exceptions;

/**
 * RUN:
 *         javac exceptions/MainException.java && java exceptions.MainException
 * OUTPUT:
 *         
 */

// import java.util.logging.*;
import java.io.*;


public class MainException {

    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("exceptions/MainException.java");
        file.close();
    }
}