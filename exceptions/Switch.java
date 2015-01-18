package exceptions;

/**
 * RUN:
 *         javac exceptions/Switch.java && java exceptions.Switch
 * OUTPUT:
 *         
 */

// import java.util.logging.*;
// import java.io.*;


class Switch {
    private boolean state = false;
    public boolean read() { return state; }
    public void on() { state = true; System.out.println(this); }
    public void off() { state = false; System.out.println(this); }
    public String toString() { return state ? "on" : "off"; }
}