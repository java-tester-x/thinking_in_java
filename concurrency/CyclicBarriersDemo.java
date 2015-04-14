package concurrency;

import java.util.concurrent.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/CyclicBarriersDemo.java && java concurrency.CyclicBarriersDemo
 *         
 * OUTPUT:
 *         
 */

public class CyclicBarriersDemo {

    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 200;

        new HorseRace(nHorses, pause);
    }


    public static class HorseRace {

        static final int FINISH_LINE = 75;

        private List<Horse> horses = new ArrayList<Horse>();

        private ExecutorService exec = Executors.newCachedThreadPool();

        private CyclicBarrier barrier;

        public HorseRace(int nHorses, final int pause) {
            barrier = new CyclicBarrier(nHorses, new Runnable() {
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < FINISH_LINE; i++) {
                        sb.append("=");
                    }

                    System.out.println(sb.toString());

                    for (Horse horse : horses) {
                        System.out.println(horse.tracks());
                    }

                    for (Horse horse : horses) {
                        if (horse.getStrides() >= FINISH_LINE) {
                            System.out.println(horse+" won!");
                            exec.shutdownNow();
                            return;
                        }
                    }

                    try {
                        TimeUnit.MILLISECONDS.sleep(pause);
                    }
                    catch (InterruptedException e) {
                        System.out.print("barrier-action sleep interrupte");
                    }
                }
            });
            
            for (int i = 0; i < nHorses; i++) {
                Horse horse = new Horse(barrier);
                horses.add(horse);
                exec.execute(horse);
            }
        }

    }

    public static class Horse implements Runnable {

        private static int counter = 0;

        private final int id = counter++;

        private int strides = 0;

        private static Random rand = new Random(47);

        private static CyclicBarrier barrier;


        public Horse(CyclicBarrier b) { barrier = b; }

        public synchronized int getStrides() { return strides; }

        public void run() {
            try {
                while(! Thread.interrupted()) {
                    synchronized(this) {
                        strides += rand.nextInt(3);
                    }
                    barrier.await();
                }
            }
            catch (InterruptedException e) {
                //
            }
            catch (BrokenBarrierException e) {
                // interesting exception !!!
                throw new RuntimeException(e);
            }
        }

        public String toString() { return String.format("Horse %1$-3d ", id); }

        public String tracks() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < getStrides(); i++) {
                sb.append("*");
            }
            sb.append(id);
            return sb.toString();
        }
    }

}