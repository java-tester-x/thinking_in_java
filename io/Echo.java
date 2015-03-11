package io;

import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/Echo.java && java io.Echo
 *         
 * OUTPUT:
 *         
 */

public class Echo {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }
    }
}