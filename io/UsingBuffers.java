package io;

import java.nio.*;
import java.util.*;

/**
 * RUN:
 *         javac io/UsingBuffers.java && java io.UsingBuffers
 *         
 * OUTPUT:
 *         UsingBuffers
 *         sUniBgfuefsr
 *         UsingBuffers
 */

public class UsingBuffers {

    public static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        
        symmetricScramble(cb);
        System.out.println(cb.rewind());

        symmetricScramble(cb);
        System.out.println(cb.rewind());
    }
}