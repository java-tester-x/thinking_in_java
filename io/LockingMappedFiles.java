package io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.util.concurrent.*;

/**
 * RUN:
 *         javac io/LockingMappedFiles.java && java io.LockingMappedFiles
 *         
 * OUTPUT:
 *         Locked: 0 to 50331647
 *         Locked: 75497471 to 113246206
 *         Unlocked: 75497471 to 113246206
 *         Unlocked: 0 to 50331647
 */

public class LockingMappedFiles {
    static final int LENGTH = 0x8FFFFFF; // 128 MB
    static FileChannel fc;

    public static void main(String[] args) {
        try {
            fc = new RandomAccessFile(new File("test.dat"), "rw").getChannel();
            MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);

            for (int i = 0; i < LENGTH; i++) {
                out.put((byte)'x');
            }

            new LockAndModify(out, 0, 0 + LENGTH/3);
            new LockAndModify(out, LENGTH/2, LENGTH/2 + LENGTH/4);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class LockAndModify extends Thread {
        private ByteBuffer buffer;
        private int start, end;

        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end   = end;

            mbb.limit(end);
            mbb.position(start);

            buffer = mbb.slice();
            start();
        }

        public void run() {
            try {
                // exclusive blocking
                FileLock fl = fc.lock(start, end, false);
                System.out.println("Locked: "+start + " to " + end);

                // Change
                while (buffer.position() < buffer.limit() - 1) {
                    buffer.put((byte)(buffer.get() + 1));
                }

                fl.release();
                System.out.println("Unlocked: "+start + " to " + end);                
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}