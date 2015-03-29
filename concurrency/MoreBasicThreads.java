package concurrency;

import java.io.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/MoreBasicThreads.java && java concurrency.MoreBasicThreads
 *         
 * OUTPUT:
 *         #0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!), #1(9), #1(8),
 *         #1(7), #1(6), #1(5), #1(4), #1(3), #1(2), #1(1), #1(Liftoff!), #3(9), #3(8), #3(7), #3(6), 
 *         #3(5), #3(4), #3(), #3(2), #3(1), #3(Liftoff!), #2(9), #2(8), #4(9), #4(8), #4(7), #4(6), 
 *         #4(5), #4(4), Waiting for LiftOff #4(3), #2(7), #2(6), #2(5), #2(4), #4(2), #2(3), #4(1), 
 *         #4(Liftoff!), #2(2), #2(1), #2(Liftoff!),
 */

public class MoreBasicThreads {

    public static void main(String[] args) {
        
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}