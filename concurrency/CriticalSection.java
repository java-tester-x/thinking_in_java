package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/CriticalSection.java && java concurrency.CriticalSection
 *         
 * OUTPUT:
 *         
 */

public class CriticalSection {

}


// NOT THREAD-SAVE
class Pair {

    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() { this(0, 0); }

    public int getX() { return x; }

    public int getY() { return y; }

    public void incrementX() { x++; }

    public void incrementY() { y++; }

    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }
}


// protection for Pair.class inside thread-save class 
abstract class PairManager {

    AtomicInteger checkCounter = new AtomicInteger(0);

    protected Pair p = new Pair();

    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        // create copy for secure original
        return new Pair(p.getX(), p.getY());
    }

    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        }
        catch (InterruptedException e) {
            //
        }
    }

    public abstract void increment();
}