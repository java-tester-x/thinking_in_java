package io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.util.concurrent.*;

/**
 * RUN:
 *         javac io/FileLocking.java && java io.FileLocking
 *         
 * OUTPUT:
 *         File locked
 *         Lock released
 */

public class FileLocking {

    public static void main(String[] args) {
        
        try {
            FileOutputStream fos = new FileOutputStream(new File("file.txt"));
            
            FileLock fl = fos.getChannel().tryLock();
            if (fl != null) {
                System.out.println("File locked");
                TimeUnit.MILLISECONDS.sleep(1000);
                fl.release();
                System.out.println("Lock released");            
            }
            fos.close();    
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}