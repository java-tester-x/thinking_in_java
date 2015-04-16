package concurrency;

import java.util.concurrent.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/DelayQueueDemo.java && java concurrency.DelayQueueDemo
 *         
 * OUTPUT:
 *         
 */

public class DelayQueueDemo {

    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();

        DelayQueue<DelayedTask> queue = new DelayQueue<DelayedTask>();

        for (int i = 0; i < 20; i++) {
            queue.put(new DelayedTask(rand.nextInt(5000)));
        }

        queue.add(new DelayedTask.EndSentinel(5000, exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}


class DelayedTask implements Runnable, Delayed {

    private static int counter = 0;

    private final int id = counter++;

    private final int delta;

    private final long trigger;

    protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();

    public DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }

    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask)arg;
        if (trigger < that.trigger) {
            return -1;
        }
        if (trigger > that.trigger) {
            return 1;
        }
        return 0;
    }

    public void run() { System.out.print(this + " "); }

    public String toString() {
        return String.format("[%1$-4d] Task %2$d", delta, id);
    }

    public String summary() {
        return String.format("(%1$d, %2$d)", id, delta);
    }

    public static class EndSentinel extends DelayedTask {
        
        private ExecutorService exec;

        public EndSentinel(int delay, ExecutorService exec) {
            super(delay);
            this.exec = exec;
        }

        public void run() {
            for (DelayedTask pt : sequence) {
                System.out.print(pt.summary() + " ");
            }
            System.out.println();
            System.out.println(this + " calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}

class DelayedTaskConsumer implements Runnable {

    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    public void run() {
        try {
            while (! Thread.interrupted()) {
                q.take().run();
            }
        }
        catch (InterruptedException e) {
            //
        }
        System.out.println("Ending DelayedTaskConsumer");
    }
}