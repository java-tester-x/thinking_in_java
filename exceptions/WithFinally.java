package exceptions;

/**
 * RUN:
 *         javac exceptions/WithFinally.java && java exceptions.WithFinally
 * OUTPUT:
 *         on
 *         off
 */

// import java.util.logging.*;
// import java.io.*;


public class WithFinally {

    static Switch sw = new Switch();

    public static void main(String[] args) {
        try {
            sw.on();            
            OnOffSwitch.f();
        }
        catch(OnOffException1 e) {
            System.out.println("OnOffException1");
        }
        catch(OnOffException2 e) {
            System.out.println("OnOffException2");
        }
        finally {
            sw.off();
        }
    }
}