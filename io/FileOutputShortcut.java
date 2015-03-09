package io;

import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/FileOutputShortcut.java && java io.FileOutputShortcut
 *         
 * OUTPUT:
 *         
 */

public class FileOutputShortcut {

    static String file = "io/FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {
        
        BufferedReader in = new BufferedReader(
            new StringReader(
                BufferedInputFile.read("io/FileOutputShortcut.java")
            )
        );

        // short syntax
        PrintWriter out = new PrintWriter(file);

        int lineCount = 1;
        String s;

        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + " " + s);
        }

        out.close();

        System.out.println(BufferedInputFile.read(file));
    }
}