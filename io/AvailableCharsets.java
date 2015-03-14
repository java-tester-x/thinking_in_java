package io;

import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.*;
import java.util.*;

/**
 * RUN:
 *         javac io/AvailableCharsets.java && java io.AvailableCharsets
 *         
 * OUTPUT:
 *         
 */

public class AvailableCharsets {

    public static void main(String[] args) throws Exception {

        FileChannel   fc     = new FileOutputStream("AvailableCharsets.txt").getChannel();
        ByteBuffer    buffer = ByteBuffer.allocate(450);
        
        SortedMap<String, Charset> charSets = Charset.availableCharsets();
        Iterator<String> it = charSets.keySet().iterator();
        
        while (it.hasNext())
        {
            String csName = it.next();
            System.out.print(csName);

            StringBuilder sb  = new StringBuilder();
            sb.append(csName);
            
            Iterator aliases = charSets.get(csName).aliases().iterator();
            
            if (aliases.hasNext()) {
                System.out.print(": ");
                sb.append(": ");
            }

            while (aliases.hasNext()) {
                Object obj = aliases.next();
                System.out.print(obj);
                sb.append((String)obj);

                if (aliases.hasNext()) {
                    System.out.print(", ");
                    sb.append(", ");
                }
            }

            System.out.println();
            sb.append("\n");

            buffer.asCharBuffer().put(sb.toString());
            fc.write(buffer);
            buffer.clear();
        }

        fc.close();
    }
}