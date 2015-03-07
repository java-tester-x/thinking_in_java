package io;

import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/TestEOF.java && java io.TestEOF
 *         
 * OUTPUT:
 *         
 */

public class TestEOF {

    public static void main(String[] args) throws IOException {
        
        DataInputStream in = new DataInputStream(
            new BufferedInputStream(
                new FileInputStream("io/TestEOF.java")
            )
        );

        while (in.available() != 0) {
            System.out.print((char)in.readByte());
        }

    }
}