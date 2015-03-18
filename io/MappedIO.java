package io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/MappedIO.java && java io.MappedIO
 *         
 * OUTPUT:
 *         
 */

public class MappedIO {

    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;

    private abstract static class Tester {
        
        private String name;

        public Tetser(String name) { this.name = name;}

        public void runTest() {
            System.out.print(name +": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("% 2f\n", duration/1.0E9);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public abstract void test() throws IOException;
    }

    private static Tester() tests = {
        new Tester("Stream Write") {
            public void test() throws IOException {
                DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(
                        new FileOutputStream(
                            new File("temp.tmp")
                        )
                    )
                );

                for (int i = 0; i < numOfInts; i++) {
                    dos.writeInt(i);
                }
                dos.close();
            }
        },

        new Tester("Mapped Write") {
            public void test() throws IOException {
                FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                IntBUffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();

                for (int i = 0; i < numOfInts; i++) {
                    ib.put(i);
                }
                fc.close();
            }
        },

        new Tester("Stream Read") {
            public void test() throws IOException {
                DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(
                        new FileInputStream("temp.tmp")
                    )
                );

                for (int i = 0; i < numOfInts; i++) {
                    dis.readInt(i);
                }
                dis.close();
            }
        },

        new Tester("Mapped Read") {
            public void test() throws IOException {
                FileChannel fc = new FileInputStream(new File("temp.tmp")).getChannel();
                IntBUffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();

                for (int i = 0; i < numOfInts; i++) {
                    ib.get(i);
                }
                fc.close();
            }
        },

        new Tester("Stream Read/Write") {
            public void test() throws IOException {
                RandomAccessFile raf = new RandomAccessFile(new File("temp.tmp"), "rw");

                raf.writeInt(1);

                for (int i = 0; i < numOfUbuffInts; i++) {
                    raf.seek(raf.length()-4);
                    raf.writeInt(raf.readInt());
                }
                raf.close();
            }
        },

        new Tester("Mapped Read/Write") {
            public void test() throws IOException {
                
            }
        },
    };

    public static void main(String[] args) {
        for (Tester test : tests) {
            test.runTest();
        }
    }
}