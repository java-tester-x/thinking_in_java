package concurrency;

import java.util.concurrent.*;
import java.util.*;
import java.io.*;

/**
 * RUN:
 *         javac concurrency/PipedIO.java && java concurrency.PipedIO
 *         
 * OUTPUT:
 *         Read: A, Read: B, Read: C, Read: D, Read: E, Read: F, Read: G, Read: H, Read: I, 
 *         Read: J, Read: K, Read: L, Read: M, 
 *         java.io.InterruptedIOException Receiver read exception
 *         java.lang.InterruptedException: sleep interrupted Sender slepp interrupted
 */

public class PipedIO {

    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4); // change here seconds value :)
        exec.shutdownNow();
    }
}


class Sender implements Runnable {

    private Random rand = new Random(47);

    private PipedWriter out = new PipedWriter();

    public PipedWriter getPipedWriter() { return out; }

    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        }
        catch (IOException e) {
            System.out.println(e + " Sender write exception");
        }
        catch (InterruptedException e) {
            System.out.println(e + " Sender slepp interrupted");
        }
    }
}


class Receiver implements Runnable {

    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }

    public void run() {
        try {
            while (true) {
                System.out.print("Read: "+(char)in.read() + ", ");
            }
        }
        catch (IOException e) {
            System.out.println(e + " Receiver read exception");
        }
    }
}

