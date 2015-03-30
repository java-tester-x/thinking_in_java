package concurrency;

import java.io.*;
import java.util.concurrent.*;


/**
 * RUN:
 *         javac concurrency/FixedThreadpool.java && java concurrency.FixedThreadpool
 *         
 * OUTPUT:
 *         #0(9), #4(9), #1(9), #2(9), #3(9), #2(8), #1(8), #4(8), #0(8), #4(7), #1(7), 
 *         #2(7), #3(8), #2(6), #1(6), #4(6), #0(7), #4(5), #1(5), #2(5), #3(7), #2(4), 
 *         #1(4), #4(4), #0(6), #4(3), #1(3), #2(3), #3(6), #2(2), #1(2), #4(2), #0(5), 
 *         #4(1), #1(1), #2(1), #3(5), #2(Liftoff!), #1(Liftoff!), #4(Liftoff!), #0(4), 
 *         #3(4), #0(3), #3(3), #0(2), #3(2), #3(1), #3(Liftoff!), #0(1), #0(Liftoff!),
 */

public class FixedThreadpool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }

        exec.shutdown();
    }
}