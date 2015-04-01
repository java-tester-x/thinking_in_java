package net.mindview.util;

import java.io.*;
import java.util.concurrent.*;
import java.util.*;


/**
 * RUN:
 *         javac net/mindview/util/DaemonThreadFactory.java
 *         
 * OUTPUT:
 *         
 */

public class DaemonThreadFactory implements ThreadFactory {

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}