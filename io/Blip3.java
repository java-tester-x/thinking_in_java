package io;

import java.io.*;


/**
 * RUN:
 *         javac io/Blip3.java && java io.Blip3
 *         
 * OUTPUT:
 *         Creation object:
 *         Blip3(String x, int a)
 *         String47
 *         Saving object:
 *         Blip3.writeExternal
 *         Unserialize b3:
 *         Constructor Blip3()
 *         Blip3.readExternal
 *         String47
 */

public class Blip3 implements Externalizable {

    private int i;

    private String s;

    public Blip3() {
        System.out.println("Constructor Blip3()");
    }

    public Blip3(String x, int a) {
        System.out.println("Blip3(String x, int a)");
        s = x;
        i = a;
    }

    public String toString() {
        return s + i;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        // DO THIS HERE:
        out.writeObject(s);
        out.writeInt(i);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        // DO THIS HERE:
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Creation object:");
        Blip3 b3 = new Blip3("String", 47);
        System.out.println(b3);

        ObjectOutputStream o = new ObjectOutputStream(
            new FileOutputStream("blip3.out")
        );
        System.out.println("Saving object:");
        o.writeObject(b3);
        o.close();

        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("blip3.out")
        );
        System.out.println("Unserialize b3:");
        b3 = (Blip3)in.readObject();
        System.out.println(b3);
    }
}