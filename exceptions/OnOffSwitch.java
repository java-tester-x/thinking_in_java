package exceptions;

/**
 * RUN:
 *         javac exceptions/OnOffSwitch.java && java exceptions.OnOffSwitch
 * OUTPUT:
 *         on
 *         off
 */

// import java.util.logging.*;
// import java.io.*;


public class OnOffSwitch {

    private static Switch sw = new Switch();

    static void f() throws OnOffException1, OnOffException2 {}

    public static void main(String[] args) {
        try {
            sw.on();
            
            f();

            sw.off();
        }
        catch(OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        }
        catch(OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }
}