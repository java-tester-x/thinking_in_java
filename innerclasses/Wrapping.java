package innerclasses;

/**
 * RUN:
 *         javac innerclasses/Wrapping.java && java innerclasses.Wrapping
 * OUTPUT:
 *         
 */

public class Wrapping {

    private int i;

    public Wrapping(int x) { i = x; }

    public int value() { return i; }
}