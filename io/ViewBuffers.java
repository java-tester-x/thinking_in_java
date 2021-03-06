package io;

import java.nio.*;
import java.util.*;

/**
 * RUN:
 *         javac io/ViewBuffers.java && java io.ViewBuffers
 *         
 * OUTPUT:
 *         Byte BUffer: 0->0 1->0 2->0 3->0 4->0 5->0 6->0 7->97
 *         Char BUffer: 0->  1->  2->  3->a
 *         Float BUffer: 0->0.0 1->1.36E-43
 *         Int BUffer: 0->0 1->97
 *         Long BUffer: 0->97
 *         Short BUffer: 0->0 1->0 2->0 3->97
 *         Double BUffer: 0->4.8E-322
 */

public class ViewBuffers {

    public static void main(String[] args) {
        
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});

        bb.rewind();
        System.out.print("Byte BUffer: ");
        while (bb.hasRemaining()) {
            System.out.print(bb.position() + "->" + bb.get() + " ");
        }
        System.out.println();

        bb.rewind();
        CharBuffer cb = bb.asCharBuffer();
        System.out.print("Char BUffer: ");
        while (cb.hasRemaining()) {
            System.out.print(cb.position() + "->" + cb.get() + " ");
        }
        System.out.println();

        bb.rewind();
        FloatBuffer fb = bb.asFloatBuffer();
        System.out.print("Float BUffer: ");
        while (fb.hasRemaining()) {
            System.out.print(fb.position() + "->" + fb.get() + " ");
        }
        System.out.println();

        bb.rewind();
        IntBuffer ib = bb.asIntBuffer();
        System.out.print("Int BUffer: ");
        while (ib.hasRemaining()) {
            System.out.print(ib.position() + "->" + ib.get() + " ");
        }
        System.out.println();

        bb.rewind();
        LongBuffer lb = bb.asLongBuffer();
        System.out.print("Long BUffer: ");
        while (lb.hasRemaining()) {
            System.out.print(lb.position() + "->" + lb.get() + " ");
        }
        System.out.println();

        bb.rewind();
        ShortBuffer sb = bb.asShortBuffer();
        System.out.print("Short BUffer: ");
        while (sb.hasRemaining()) {
            System.out.print(sb.position() + "->" + sb.get() + " ");
        }
        System.out.println();

        bb.rewind();
        DoubleBuffer db = bb.asDoubleBuffer();
        System.out.print("Double BUffer: ");
        while (db.hasRemaining()) {
            System.out.print(db.position() + "->" + db.get() + " ");
        }
        System.out.println();
    }
}