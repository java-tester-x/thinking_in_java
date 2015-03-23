package io;

import java.io.*;


/**
 * RUN:
 *         javac io/FreezeAlien.java && java io.FreezeAlien
 *         
 * OUTPUT:
 *         
 */

public class FreezeAlien {

    public static void main(String[] args) throws Exception {
        ObjectOutput out = new ObjectOutputStream(
            new FileOutputStream("X.file")
        );

        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
}