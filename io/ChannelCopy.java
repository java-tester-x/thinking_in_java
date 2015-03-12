package io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/ChannelCopy.java && java io.ChannelCopy io/ChannelCopy.java io/test.txt
 *         
 * OUTPUT:
 *         
 */

public class ChannelCopy {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("parameters: Sourse Target");
            System.exit(1);
        }

        FileChannel in  = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }
}