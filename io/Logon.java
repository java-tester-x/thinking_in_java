package io;

import java.io.*;
import java.util.concurrent.*;
import java.util.*;


/**
 * RUN:
 *         javac io/Logon.java && java io.Logon
 *         
 * OUTPUT:
 *         Session a = session info
 *          user: User
 *          date: Wed Mar 25 07:27:32 EET 2015
 *          password: Password
 *         
 *         Unserialize object Time:Wed Mar 25 07:27:33 EET 2015
 *         Session a = session info
 *          user: User
 *          date: Wed Mar 25 07:27:32 EET 2015
 *          password: null
 */

public class Logon implements Serializable {

    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    public String toString() {
        return "session info\n user: "+username
                + "\n date: " + date
                + "\n password: "+ password;
    }

    public static void main(String[] args) throws Exception {
        Logon a = new Logon("User", "Password");
        System.out.println("Session a = "+a);

        ObjectOutputStream o = new ObjectOutputStream(
            new FileOutputStream("Logon.out")
        );
        o.writeObject(a);
        o.close();

        TimeUnit.SECONDS.sleep(1);

        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("Logon.out")
        );
        System.out.println("Unserialize object Time:" + new Date());
        a = (Logon)in.readObject();
        System.out.println("Session a = "+a);
    }
}