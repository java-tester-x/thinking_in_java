package exceptions;

/**
 * RUN:
 *         javac exceptions/TurnOffChecking.java && java exceptions.TurnOffChecking
 * OUTPUT:
 *         FileNotFoundException: java.io.FileNotFoundException
 *         IOException: java.io.IOException
 *         Throwable: java.lang.RuntimeException: Where I am?
 *         SomeOtherException: exceptions.SomeOtherException
 */

// import java.util.logging.*;
import java.io.*;


public class TurnOffChecking {

    public static void main(String[] args)
    {
        WrapCheckedException wce = new WrapCheckedException();
        
        // one way
        wce.throwRuntimeException(3);

        // second way
        for (int i = 0; i < 4; i++)
        {
            try {
                if (i < 3) {
                    wce.throwRuntimeException(i);
                }
                else {
                    throw new SomeOtherException();
                }
            }
            catch(SomeOtherException e) {
                System.out.println("SomeOtherException: " + e);
            }
            catch(RuntimeException re) {
                try {
                    throw re.getCause();
                }
                catch(FileNotFoundException e) {
                    System.out.println("FileNotFoundException: " + e);
                }
                catch(IOException e) {
                    System.out.println("IOException: " + e);
                }
                catch(Throwable e) {
                    System.out.println("Throwable: " + e);
                }
            }
        }
    }
}

class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch(type) {
                case 0: throw new FileNotFoundException();
                case 1: throw new IOException();
                case 2: throw new RuntimeException("Where I am?");
                default: return;
            }
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class SomeOtherException extends Exception {}