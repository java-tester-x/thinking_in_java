package concurrency;

import java.util.concurrent.*;
import java.util.*;
import java.io.*;

/**
 * RUN:
 *         javac concurrency/Philosopher.java && java concurrency.Philosopher
 *         
 * OUTPUT:
 *         
 */

public class Philosopher implements Runnable {

    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) {
            return;
        }

        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }

    public Philosopher(Chopstick left, Chopstick right, int ident, int ponder) {
        this.left    = left;
        this.right   = right;
        id           = ident;
        ponderFactor = ponder;
    }

    public void run() {
        try {
            while (! Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();
                
                
                
                System.out.println(this + " " + "take left");
                left.take();

                System.out.println(this + " " + "take right");
                right.take();
                
                System.out.println(this + " " + "eat");
                pause();
                
                right.drop();
                left.drop();
            }
        }
        catch (InterruptedException e) {
            System.out.println(this + " " + " exit through interruption");
        }
    }

    public String toString() { return "Philosopher " + id; }
}