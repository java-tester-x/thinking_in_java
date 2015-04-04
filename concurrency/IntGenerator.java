package concurrency;

import java.io.*;
import java.util.concurrent.*;
import net.mindview.util.*;


/**
 * RUN:
 *         javac concurrency/IntGenerator.java
 *         
 * OUTPUT:
 *         
 */

public abstract class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() { canceled = true; }

    public boolean isCanceled() { return canceled; }
} 