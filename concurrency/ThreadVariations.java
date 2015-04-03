package concurrency;

import java.io.*;
import java.util.concurrent.*;
import net.mindview.util.*;


/**
 * RUN:
 *         javac concurrency/ThreadVariations.java && java concurrency.ThreadVariations
 *         
 * OUTPUT:
 *         InnerThread1: 5
 *         InnerThread2: 5
 *         InnerThread1: 4
 *         InnerRunnable1: 5
 *         InnerRunnable2: 5
 *         ThreadMethod: 5
 *         InnerThread1: 3
 *         InnerThread2: 4
 *         ThreadMethod: 4
 *         InnerRunnable2: 4
 *         InnerRunnable1: 4
 *         InnerThread2: 3
 *         ThreadMethod: 3
 *         InnerThread1: 2
 *         InnerRunnable2: 3
 *         InnerRunnable1: 3
 *         ThreadMethod: 2
 *         InnerThread1: 1
 *         InnerThread2: 2
 *         InnerThread2: 1
 *         InnerRunnable1: 2
 *         InnerRunnable2: 2
 *         ThreadMethod: 1
 *         InnerRunnable1: 1
 *         InnerRunnable2: 1
 */

public class ThreadVariations {

    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}


class InnerThread1 {

    private int countDown = 5;

    private Inner inner;

    private class Inner extends Thread {

        Inner(String name) {
            super(name);
            start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    sleep(10);
                }
            }
            catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }

        public String toString() {
            return getName() + ": " + countDown;
        }
    }

    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}


class InnerThread2 {

    private int countDown = 5;

    private Thread t;

    public InnerThread2(String name) {
        t = new Thread(name) {

            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                }
                catch (InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }

            public String toString() {
                return getName() + ": " + countDown;
            }
        };

        t.start();
    }
}


class InnerRunnable1 {

    private int countDown = 5;

    private Inner inner;

    private class Inner implements Runnable {

        Thread t;

        Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            }
            catch (InterruptedException e) {
                System.out.println("sleep() interrupted");
            }
        }

        public String toString() {
            return t.getName() + ": " + countDown;
        }
    }

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }
}

class InnerRunnable2 {

    private int countDown = 5;

    private Thread t;

    public InnerRunnable2(String name) {
        t = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                }
                catch (InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }

            public String toString() {
                return t.getName() + ": " + countDown;
            }
        }, name);

        t.start();
    }
}


class ThreadMethod {
    
    private int countDown = 5;

    private Thread t;

    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if (t != null) {
            return;
        }

        t = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                }
                catch (InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }

            public String toString() {
                return t.getName() + ": " + countDown;
            }
        };

        t.start();
    }
}