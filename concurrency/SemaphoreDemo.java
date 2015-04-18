package concurrency;

import java.util.concurrent.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/SemaphoreDemo.java && java concurrency.SemaphoreDemo
 *         
 * OUTPUT:
 *         
 */

public class SemaphoreDemo {

    final static int SIZE = 25;

    public static void main(String[] args) throws Exception {
        final Pool<Fat> pool = new Pool<Fat>(Fat.class, SIZE);

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new CheckoutTask<Fat>(pool));
        }
        System.out.println("All CheckoutTasks created");

        List<Fat> list = new ArrayList<Fat>();
        for (int i = 0; i < SIZE; i++) {
            Fat f = pool.checkOut();
            System.out.print(i + " main() thread checked out ");
            f.operation();
            list.add(f);
        }

        Future<?> blocked = exec.submit(new Runnable() {
            public void run() {
                try {
                    // Semaphore blocking this checkOut() eexecution
                    pool.checkOut();
                }
                catch (InterruptedException e) {
                    System.out.println("checkOut() interrupted");
                }
            }
        });

        TimeUnit.SECONDS.sleep(2);

        blocked.cancel(true); // return from blocking

        System.out.println("Checking in objects in " + list);

        for (Fat f : list) {
            pool.checkIn(f);
        }

        for (Fat f : list) {
            pool.checkIn(f);  // this checkIn() ignored
        }

        exec.shutdown();
    }
}


class CheckoutTask<T> implements Runnable {

    private static int counter = 0;

    private final int id = counter++;

    private Pool<T> pool;

    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }

    public void run() {
        try {
            T item = pool.checkOut();
            System.out.println(this + " checked out " + item);

            TimeUnit.SECONDS.sleep(1);

            System.out.println(this + " checked in " + item);
            pool.checkIn(item);
        }
        catch (InterruptedException e) {
            //
        }
    }

    public String toString() {
        return String.format("CheckoutTask %1$d ", id);
    }
}