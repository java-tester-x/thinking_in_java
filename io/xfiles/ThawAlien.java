package io.xfiles;

import java.io.*;


/**
 * RUN:
 *         javac io/xfiles/ThawAlien.java && java io.xfiles.ThawAlien
 *         
 * OUTPUT:
 *         
 */

public class ThawAlien {

    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream(new File("X.file"))
        );

        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}