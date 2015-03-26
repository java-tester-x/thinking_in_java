package io;

import java.io.*;
import java.util.*;


/**
 * RUN:
 *         javac io/MyWorld.java && java io.MyWorld
 *         
 * OUTPUT:
 *         
 */

public class MyWorld {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();

        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("Bosco the dog", house));
        animals.add(new Animal("Ralph the hamster", house));
        animals.add(new Animal("Molly the cat", house));
        System.out.println("animals: "+animals);

        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream o1 = new ObjectOutputStream(buf1);
        o1.writeObject(animals);
        o1.writeObject(animals); // second copy

        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream o2 = new ObjectOutputStream(buf2);
        o2.writeObject(animals);


        ObjectInputStream in1 = new ObjectInputStream(
            new ByteArrayInputStream(buf1.toByteArray())
        );
        ObjectInputStream in2 = new ObjectInputStream(
            new ByteArrayInputStream(buf2.toByteArray())
        );

        List animals1 = (List)in1.readObject(),
             animals2 = (List)in1.readObject(),
             animals3 = (List)in2.readObject();

        System.out.println("animals1: "+animals1);
        System.out.println("animals2: "+animals2);
        System.out.println("animals3: "+animals3);
    }
}


class House implements Serializable {}

class Animal implements Serializable {

    private String name;
    private House preferredHouse;

    Animal(String name, House house) {
        this.name = name;
        this.preferredHouse = house;
    }

    public String toString() {
        return name + "["+ super.toString() + "], " + preferredHouse + "\n";
    }
}