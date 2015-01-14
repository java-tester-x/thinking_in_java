package exceptions;

/**
 * RUN:
 *         javac exceptions/LoggingExceptions2.java && java exceptions.LoggingExceptions2
 * OUTPUT:
 *         Jan 14, 2015 7:10:42 AM exceptions.LoggingExceptions2 logException
 *         SEVERE: java.lang.NullPointerException
 *                 at exceptions.LoggingExceptions2.main(LoggingExceptions2.java:26)
 */

import java.util.logging.*;
import java.io.*;


public class LoggingExceptions2 {

    private static Logger logger = Logger.getLogger("LoggingExceptions2");

    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        }
        catch (NullPointerException e) {
            logException(e);
        }
    }
}