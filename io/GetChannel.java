package io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/GetChannel.java && java io.GetChannel
 *         
 * OUTPUT:
 *         
 */

public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        // write in file
        FileChannel fc = new FileOutputStream("io/data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        // append to end of file
        fc = new RandomAccessFile("io/data.txt", "rw").getChannel();
        fc.position(fc.size()); // move to end of file
        fc.write(ByteBuffer.wrap("Some more ".getBytes()));
        fc.close();

        // read from file
        fc = new FileInputStream("io/data.txt").getChannel();
        // ByteBuffer buff = ByteBuffer.allocateDirect(BSIZE);
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.print((char)buff.get());
        }
    }
}