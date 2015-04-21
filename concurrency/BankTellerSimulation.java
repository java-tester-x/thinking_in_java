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

}


class Customer {

    private final int serviceTime;

    public Customer(int tm) { serviceTime = tm; }

    public int getServiceTime() { return serviceTime; }

    public String toString() { return String.format("[%1$d]", serviceTime) }
}

class CustomerLine extends ArrayBlockingQueue<Customer> {

    public CustomerLine(int maxLineSize) {
        super(maxLineSize);
    }

    public String toString() {
        if (this.size == 0) {
            return "[empty]";
        }

        StringBuilder sb = new StringBuilder();
        for (Customer customer : this) {
            sb.append(customer);
        }

        return sb.toString();
    }
}


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



class Teller implements Runnable, Comparable<Teller> {

    private static int counter = 0;

    private final int id = counter++;

    private int customerServed = 0;

    private CustomerLine customers;

    private boolean servingCustomerLine = true;

    public Teller(CustomerLine custometrs) {
        this.custometrs = custometrs;
    }

    public void run() {
        try {
            while (! Thread.interrupted()) {
                Customer customer = custometrs.take();
                
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
            Ssytem.out.println(this + " interrupted");
        }
        System.out.println(this + " terminating");
    }

    public synchronized void doSomethingElse() {
        customerServed = 0;
        servingCustomerLine = false;
    }

    public synchronized void serveCustomerLine() {
        assert ! servingCustomerLine : "serving now: " + this;
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



class TellerManager implements Runnable {
    
}