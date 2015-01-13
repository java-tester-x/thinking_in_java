package exceptions;

/**
 * RUN:
 *         javac exceptions/LoggingExceptions.java && java exceptions.LoggingExceptions
 * OUTPUT:
 *         Jan 13, 2015 7:16:30 AM exceptions.LoggingException <init>
 *         SEVERE: exceptions.LoggingException
 *                 at exceptions.LoggingExceptions.main(LoggingExceptions.java:19)
 *         
 *         Catched: exceptions.LoggingException
 *
 * 
 *         Jan 13, 2015 7:16:30 AM exceptions.LoggingException <init>
 *         SEVERE: exceptions.LoggingException
 *                 at exceptions.LoggingExceptions.main(LoggingExceptions.java:26)
 *         
 *         Catched: exceptions.LoggingException
 */

import java.util.logging.*;
import java.io.*;


public class LoggingExceptions {

    public static void main(String[] args)
    {
        try {
            throw new LoggingException();
        }
        catch (LoggingException e) {
            System.err.println("Catched: " + e);
        }

        try {
            throw new LoggingException();
        }
        catch (LoggingException e) {
            System.err.println("Catched: " + e);
        }        
    }
}


class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}