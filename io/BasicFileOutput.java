package io;

import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/BasicFileOutput.java && java io.BasicFileOutput
 *         
 * OUTPUT:
 *         
 */

public class BasicFileOutput {

    static String file = "io/BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        
        BufferedReader in = new BufferedReader(
            new StringReader(
                BufferedInputFile.read("io/BasicFileOutput.java")
            )
        );

        PrintWriter out = new PrintWriter(
            new BufferedWriter(
                new FileWriter(file)
            )
        );

        int lineCount = 1;
        String s;

        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + " " + s);
        }

        out.close();

        System.out.println(BufferedInputFile.read(file));
    }
}