package io;

import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/BufferedInputFile.java && java io.BufferedInputFile
 *         
 * OUTPUT:
 *         
 */

public class BufferedInputFile {

    public static String read(String fileName) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(fileName));
        
        String s;
        StringBuilder sb = new StringBuilder();
        while ( (s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        
        System.out.println(read("io/BufferedInputFile.java"));
        
    }
}