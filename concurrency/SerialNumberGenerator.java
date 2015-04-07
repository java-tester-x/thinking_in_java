package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;


/**
 * RUN:
 *         javac concurrency/SerialNumberGenerator.java
 *         
 * OUTPUT:
 *         
 */

public class SerialNumberGenerator {

    private static volatile int serialNumber = 0;

    public static synchronized int nextSerialNumber() {
        return serialNumber++;
    }
}