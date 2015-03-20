package io;

import java.io.*;
import java.util.zip.*;

/**
 * RUN:
 *         javac io/GZIPcompress.java && java io.GZIPcompress io/GZIPcompress.java
 *         
 * OUTPUT:
 *         
 */

public class GZIPcompress {

    public static void main(String[] args)
    {
        if (args.length == 0) {
            System.out.println("Run: \nGZIPcompress file\n"+
                               "\tusing GZIP method to compress file into test.gz");
            System.exit(1);
        }

        try {
            BufferedReader in = new BufferedReader(
                new FileReader(args[0])
            );

            BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(
                    new FileOutputStream("test.gz")
                )
            );

            System.out.println("Writing to file");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.close();

            System.out.println("Reading from file");
            BufferedReader in2 = new BufferedReader(
                new InputStreamReader(
                    new GZIPInputStream(
                        new FileInputStream("test.gz")
                    )
                )
            );
            String s;
            while ((s = in2.readLine()) != null) {
                System.out.println(s);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}