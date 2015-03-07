package io;

import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/MemoryInput.java && java io.MemoryInput
 *         
 * OUTPUT:
 *         
 */

public class MemoryInput {

    public static void main(String[] args) throws IOException {
        
        StringReader in = new StringReader(BufferedInputFile.read("io/MemoryInput.java"));

        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }

    }

}