package io;

import java.io.*;
import java.util.concurrent.*;
import java.util.*;


/**
 * RUN:
 *         javac io/SerialCtl.java && java io.SerialCtl
 *         
 * OUTPUT:
 *         Before serialize:
 *         Without transient: Test1
 *         With transient: Test2
 *         After unserialize:
 *         Without transient: Test1
 *         With transient: Test2
 */

public class SerialCtl implements Serializable {

    private String a;

    private transient String b;

    public SerialCtl(String aa, String bb) {
        a = "Without transient: " + aa;
        b = "With transient: " + bb;
    }

    public String toString() {
        return a + "\n" + b;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b = (String)stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Before serialize: \n" + sc);

        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);

        ObjectInputStream in = new ObjectInputStream(
            new ByteArrayInputStream(buf.toByteArray())
        );
        SerialCtl sc2 = (SerialCtl)in.readObject();
        System.out.println("After unserialize: \n" + sc2);
    }
}