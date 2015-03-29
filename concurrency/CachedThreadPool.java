package concurrency;

import java.io.*;
import java.util.concurrent.*;


/**
 * RUN:
 *         javac concurrency/CachedThreadPool.java && java concurrency.CachedThreadPool
 *         
 * OUTPUT:
 *         #1(9), #4(9), #0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #3(9), #2(9),
 *         #2(8), #3(8), #0(1), #0(Liftoff!), #4(8), #4(7), #1(8), #4(6), #3(7), #2(7), #2(6), 
 *         #3(6), #3(5), #4(5), #4(4), #4(3), #1(7), #4(2), #3(4), #3(3), #2(5), #2(4), #2(3), 
 *         #3(2), #4(1), #4(Liftoff!), #1(6), #3(1), #2(2), #2(1), #2(Liftoff!), #3(Liftoff!), 
 *         #1(5), #1(4), #1(3), #1(2), #1(1), #1(Liftoff!),
 */

public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }

        exec.shutdown();
    }
}