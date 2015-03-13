package io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/TransferTo.java && java io.TransferTo io/TransferTo.java io/TransferTo.txt
 *         
 * OUTPUT:
 *         
 */

public class TransferTo {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("parameters: Source Target");
            System.exit(1);
        }

        FileChannel in  = new FileInputStream("io/TransferTo.java").getChannel();
        FileChannel out = new FileOutputStream("io/TransferTo.txt").getChannel();

        in.transferTo(0, in.size(), out);
        // or
        // out.transferFrom(in, 0, in.size());
    }
}