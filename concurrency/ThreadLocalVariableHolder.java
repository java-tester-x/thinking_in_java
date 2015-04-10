package concurrency;

import java.util.concurrent.*;
import java.util.*;

/**
 * RUN:
 *         javac concurrency/ThreadLocalVariableHolder.java && java concurrency.ThreadLocalVariableHolder
 *         
 * OUTPUT:
 *         
 */

public class ThreadLocalVariableHolder {

    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        private Random rand = new Random(47);
        protected synchronized Integer initialValue() {
            return rand.nextInt(10000);
        }
    };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() { return value.get(); }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        
        for (int i = 0; i < 5; i++) {
            exec.execute(new Accessor(i));
        }

        TimeUnit.SECONDS.sleep(3);
        exec.shutdown();
    }
}


class Accessor implements Runnable {
    
    private final int id;
    
    public Accessor(int id) { this.id = id; }

    public void run() {
        while (! Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    public String toString() {
        return "#" + id + " " + ThreadLocalVariableHolder.get();
    }
}