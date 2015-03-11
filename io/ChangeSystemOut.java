package io;

import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/ChangeSystemOut.java && java io.ChangeSystemOut
 *         
 * OUTPUT:
 *         
 */

public class ChangeSystemOut {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world!");
    }
}