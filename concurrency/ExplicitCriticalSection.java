package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/ExplicitCriticalSection.java && java concurrency.ExplicitCriticalSection
 *         
 * OUTPUT:
 *         
 */

public class ExplicitCriticalSection {

    public static void main(String[] args) throws Exception {
        PairManager pman1 = new ExplicitPairManager1();
        PairManager pman2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pman1, pman2);
    }
}


class ExplicitPairManager1 extends PairManager {

    private Lock lock = new ReentrantLock();

    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        }
        finally {
            lock.unlock();
        }
    }
}

class ExplicitPairManager2 extends PairManager {

    private Lock lock = new ReentrantLock();

    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        finally {
            lock.unlock();
        }
        store(temp);
    }
}