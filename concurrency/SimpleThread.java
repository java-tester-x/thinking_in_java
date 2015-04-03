package concurrency;

import java.io.*;
import java.util.concurrent.*;
import net.mindview.util.*;


/**
 * RUN:
 *         javac concurrency/SimpleThread.java && java concurrency.SimpleThread
 *         
 * OUTPUT:
 *         #2(5), #1(5), #3(5), #4(5), #4(4), #4(3), #2(4), #2(3), #2(2), #4(2), #4(1), 
 *         #5(5), #5(4), #5(3), #5(2), #3(4), #1(4), #1(3), #1(2), #1(1), #3(3), #3(2), 
 *         #3(1), #5(1), #2(1),
 */

public class SimpleThread extends Thread {

    private int countDown = 5;

    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }

    public void run() {
        while (true) {
            System.out.print(this);

            if (--countDown == 0) {
                return;
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i< 5; i++) {
            new SimpleThread();
        }
    }
}