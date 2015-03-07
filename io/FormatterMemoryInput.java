package io;

import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/FormatterMemoryInput.java && java io.FormatterMemoryInput
 *         
 * OUTPUT:
 *         
 */

public class FormatterMemoryInput {

    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(
                    BufferedInputFile.read("io/FormatterMemoryInput.java").getBytes()
                )
            );

            while (true) {
                System.out.print((char)in.readByte());
            }
        }
        catch (IOException e) {
            System.err.println("End of stream");
        }
    }
}