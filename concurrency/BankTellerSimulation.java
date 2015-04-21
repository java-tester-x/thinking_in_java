package concurrency;

import java.util.concurrent.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/BankTellerSimulation.java && java concurrency.BankTellerSimulation
 *         
 * OUTPUT:
 *         
 */

public class BankTellerSimulation {

    static final int MAX_LINE_SIZE = 50;

    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws Exception {
        ExecutorService exec =Executors.newCachedThreadPool();

        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);

        exec.execute(new CustomerGenerator(customers));

        exec.execute(new TellerManager(exec, customers, ADJUSTMENT_PERIOD));

        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        }
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }

        exec.shutdownNow();
    }
}

// -----------------------------------------------------------------------------

class Customer {

    private final int serviceTime;

    public Customer(int tm) { serviceTime = tm; }

    public int getServiceTime() { return serviceTime; }

    public String toString() { return String.format("[%1$d]", serviceTime); }
}

// -----------------------------------------------------------------------------

class CustomerLine extends ArrayBlockingQueue<Customer> {

    public CustomerLine(int maxLineSize) {
        super(maxLineSize);
    }

    public String toString() {
        if (this.size() == 0) {
            return "[empty]";
        }

        StringBuilder sb = new StringBuilder();
        for (Customer customer : this) {
            sb.append(customer);
        }

        return sb.toString();
    }
}

// -----------------------------------------------------------------------------

class CustomerGenerator implements Runnable {

    private CustomerLine customers;

    private static Random rand = new Random(47);

    public CustomerGenerator(CustomerLine customers) {
        this.customers = customers;
    }

    public void run() {
        try {
            while (! Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new Customer(rand.nextInt(1000)));
            }
        }
        catch (InterruptedException e) {
            System.out.println("CustomerGenerator interrupted");
        }
        System.out.println("CustomerGenerator terminating");
    }
}

// -----------------------------------------------------------------------------

class Teller implements Runnable, Comparable<Teller> {

    private static int counter = 0;

    private final int id = counter++;

    private int customerServed = 0;

    private CustomerLine customers;

    private boolean servingCustomerLine = true;

    public Teller(CustomerLine customers) {
        this.customers = customers;
    }

    public void run() {
        try {
            while (! Thread.interrupted()) {
                Customer customer = customers.take();
                
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());

                synchronized(this) {
                    customerServed++;
                    while (! servingCustomerLine) {
                        wait();
                    }
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " terminating");
    }

    public synchronized void doSomethingElse() {
        customerServed = 0;
        servingCustomerLine = false;
    }

    public synchronized void serveCustomerLine() {
        assert (! servingCustomerLine): "serving now: " + this;
        servingCustomerLine = true;
        notifyAll();
    }

    public String toString() { return "Teller " + id + " "; }

    public String shortString() { return "T" + id; }

    public synchronized int compareTo(Teller other) {
        return (customerServed  < other.customerServed) ? -1 : 
               (customerServed == other.customerServed  ?  0 : 1);
    }
}

// -----------------------------------------------------------------------------

class TellerManager implements Runnable {

    private ExecutorService exec;

    private CustomerLine customers;

    private PriorityQueue<Teller> workingTellers = new PriorityQueue<Teller>();

    private Queue<Teller> tellersDoingOtherThings = new LinkedList<Teller>();

    private int adjustmentPeriod;

    private static Random rand = new Random(47);

    public TellerManager(ExecutorService exec, CustomerLine customers, int adjustmentPeriod) {
        this.exec             = exec;
        this.customers       = customers;
        this.adjustmentPeriod = adjustmentPeriod;

        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }

    public void adjustTellerNumber()
    {
        if (customers.size() / workingTellers.size() > 2)
        {
            // pass customer to @free@ teller
            if (tellersDoingOtherThings.size() > 0)
            {
                Teller teller = tellersDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
                return;
            }

            // hire new teller if there is a big number of customers
            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }

        if (workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2) {
            reassignOneTeller();
        }

        if (customers.size() == 0) {
            while (workingTellers.size() > 1) {
                reassignOneTeller();
            }
        }
    }


    private void reassignOneTeller() {
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellersDoingOtherThings.offer(teller);
    }

    public void run() {
        try {
            while (! Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();

                System.out.print(customers + " { ");
                for (Teller teller : workingTellers) {
                    System.out.print(teller.shortString() + " ");
                }
                System.out.println(" }");
            }
        }
        catch(InterruptedException w) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " terminating");
    }

    public String toString() {
        return "TellerManager ";
    }
}