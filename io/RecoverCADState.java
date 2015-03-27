package io;

import java.io.*;
import java.util.*;


/**
 * RUN:
 *         javac io/RecoverCADState.java && java io.RecoverCADState
 *         
 * OUTPUT:
 *         
 */

public class RecoverCADState {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("CADState.out")
        );

        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>)in.readObject();
        Line.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>)in.readObject();

        System.out.println(shapes);
    }
}