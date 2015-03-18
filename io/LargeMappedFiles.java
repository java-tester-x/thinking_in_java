package io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/LargeMappedFiles.java && java io.LargeMappedFiles
 *         
 * OUTPUT:
 *         
 */

public class LargeMappedFiles {

    static int length = 0x8FFFFFF; // 128 MB

    public static void main(String[] args) throws Exception {
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw")
                                    .getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte)'x');
        }
        System.out.println("Write completed");

        for (int i = length/2; i < length/2 + 6; i++) {
            System.out.print((char)out.get(i));
        }
    }
}