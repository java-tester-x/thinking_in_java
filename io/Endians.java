package io;

import java.nio.*;
import java.util.*;

/**
 * RUN:
 *         javac io/Endians.java && java io.Endians
 *         
 * OUTPUT:
 *         [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]
 *         [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]
 *         [97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102, 0]
 */

public class Endians {

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
    }    
}