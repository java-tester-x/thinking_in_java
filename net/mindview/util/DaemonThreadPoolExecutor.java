package net.mindview.util;

import java.io.*;
import java.util.concurrent.*;
import java.util.*;


/**
 * RUN:
 *         javac net/mindview/util/DaemonThreadPoolExecutor.java
 *         
 * OUTPUT:
 *         
 */

public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {

    public DaemonThreadPoolExecutor() {
        super(
              0
            , Integer.MAX_VALUE
            , 60L
            , TimeUnit.SECONDS
            , new SynchronousQueue<Runnable>()
            , new DaemonThreadFactory()
        );
    }
}