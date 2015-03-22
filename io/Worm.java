package io;

import java.io.*;
import java.util.zip.*;
import java.util.*;

/**
 * RUN:
 *         javac io/Worm.java && java io.Worm
 *         
 * OUTPUT:
 *         Construcot Worm: 6
 *         Construcot Worm: 5
 *         Construcot Worm: 4
 *         Construcot Worm: 3
 *         Construcot Worm: 2
 *         Construcot Worm: 1
 *         w = :a(853):b(119):c(802):d(788):e(199):f(881)
 *         Worm storage
 *         w2 = :a(853):b(119):c(802):d(788):e(199):f(881)
 *         Memory of object Worm
 *         w3 = :a(853):b(119):c(802):d(788):e(199):f(881)
 */

public class Worm implements Serializable {

    private static Random rand = new Random(47);

    private Data[] d = {
        new Data(rand.nextInt(10)),
        new Data(rand.nextInt(10)),
        new Data(rand.nextInt(10))
    };

    private Worm next;
    private char c;

    public Worm(int i, char x) {
        System.out.println("Construcot Worm: " + i);
        c = x;
        if (--i > 0) {
            next = new Worm(i, (char)(x+1));
        }
    }

    public Worm() {
        System.out.println("Default constructor");
    }

    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data dat : d) {
            result.append(dat);
        }
        result.append(")");
        if (next != null) {
            result.append(next);
        }

        return result.toString();
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Worm w = new Worm(6, 'a');
        System.out.println("w = " + w);

        ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream("worm.out")
        );
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();

        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("worm.out")
        );
        String s = (String)in.readObject();
        Worm w2 = (Worm)in.readObject();
        System.out.println(s + "w2 = " + w2);
        
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Memory of object Worm\n");
        out2.writeObject(w);
        out2.flush();

        ObjectInputStream in2 = new ObjectInputStream(
            new ByteArrayInputStream(bout.toByteArray())
        );
        s = (String)in2.readObject();
        Worm w3 = (Worm)in2.readObject();
        System.out.println(s +"w3 = "+w3);
    }
}

class Data implements Serializable {
    private int n;
    public Data(int n) { this.n = n; }
    public String toString() { return Integer.toString(n); }
}