package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * RUN:
 *         javac io/CopyBytes.java && java io.CopyBytes
 *         
 * OUTPUT:
 *         
 */

public class CopyBytes {

    public static void main(String[] args) throws IOException {

        FileInputStream  in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}