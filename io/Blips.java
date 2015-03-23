package io;

import java.io.*;


/**
 * RUN:
 *         javac io/Blips.java && java io.Blips
 *         
 * OUTPUT:
 *         Creation objects:
 *         Constructor Blip1()
 *         Constructor Blip2()
 *         Serialize objects:
 *         Blip1.writeExternal()
 *         Blip2.writeExternal()
 *         unserialize b1:
 *         Constructor Blip1()
 *         Blip1.readExternal()
 */

public class Blips {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Creation objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();

        ObjectOutputStream o = new ObjectOutputStream(
            new FileOutputStream("Blips.out")
        );
        
        System.out.println("Serialize objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();

        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("Blips.out")
        );

        System.out.println("unserialize b1:");
        b1 = (Blip1)in.readObject();

        // 
        // ERROR:
        // 
        // java.io.InvalidClassException: io.Blip2; no valid constructor
        // 
        
        // System.out.println("unserialize b2:");
        // b2 = (Blip2)in.readObject();
    }
}


class Blip1 implements Externalizable {

    public Blip1() {
        System.out.println("Constructor Blip1()");
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal()");
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal()");
    }
}

class Blip2 implements Externalizable {

    Blip2() {
        System.out.println("Constructor Blip2()");
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal()");
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal()");
    }
}