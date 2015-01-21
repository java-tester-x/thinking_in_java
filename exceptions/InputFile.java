package exceptions;

/**
 * RUN:
 *         javac exceptions/InputFile.java && java exceptions.InputFile
 * OUTPUT:
 *         
 */

// import java.util.logging.*;
import java.io.*;


public class InputFile {

    private BufferedReader in;

    public InputFile(String fname) throws Exception
    {
        try {
            in = new BufferedReader(new FileReader(fname));

            // . . .
        }
        catch(FileNotFoundException e) {
            System.out.println("Can not open file " + fname);
            throw e;
        }
        catch(Exception e) {
            try {
                in.close();
            }
            catch(IOException e2) {
                System.out.println("in.close() failure");
            }
            throw e; // rethrowing here !!!
        }
        finally {
            // DO NOT CLOSE FILE HERE !!!
        }
    }

    public String getLine()
    {
        String s;
        try {
            s = in.readLine();
        }
        catch(IOException e) {
            throw new RuntimeException("readLine() failure");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() success");
        }
        catch(IOException e) {
            System.out.println("in.close() failure");
        }
    }
}