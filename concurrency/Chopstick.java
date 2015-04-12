package concurrency;

import java.util.concurrent.*;
import java.util.*;
import java.io.*;

/**
 * RUN:
 *         javac concurrency/Chopstick.java && java concurrency.Chopstick
 *         
 * OUTPUT:
 *         
 */

public class Chopstick {

    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}