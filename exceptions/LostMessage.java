package exceptions;

/**
 * RUN:
 *         javac exceptions/LostMessage.java && java exceptions.LostMessage
 * OUTPUT:
 *         Secondary exception.
 */

// import java.util.logging.*;
// import java.io.*;


public class LostMessage {

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            }
            finally {
                lm.dispose();
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}

class VeryImportantException extends Exception {
    public String toString() {
        return "Very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "Secondary exception.";
    }
}