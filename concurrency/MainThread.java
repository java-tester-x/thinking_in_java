package concurrency;

import java.io.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/MainThread.java && java concurrency.MainThread
 *         
 * OUTPUT:
 *         #0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
 */

public class MainThread {

    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}