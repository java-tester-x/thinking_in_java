package io;

import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/BufferToText.java && java io.BufferToText
 *         
 * OUTPUT:
 *         ?????
 *         Decoded in Cp1251: Some text
 *         Some text
 *         Some text
 */

public class BufferToText {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        // 1
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer()); // show incorrect text: ?????

        // decode with default codepage
        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded in " + encoding + ": "
            + Charset.forName(encoding).decode(buffer)
        );

        // 2
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes("UTF-16BE")));
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());

        // 3
        fc = new FileOutputStream("data2.txt").getChannel();
        buffer = ByteBuffer.allocate(30);
        buffer.asCharBuffer().put("Some text");
        fc.write(buffer);
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }
}