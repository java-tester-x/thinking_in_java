package io;

import java.io.*;
import java.util.zip.*;
import java.util.*;

/**
 * RUN:
 *         javac io/ZipCompress.java && java io.ZipCompress io/ZipCompress.java
 *         
 * OUTPUT:
 *         
 */

public class ZipCompress {

    public static void main(String[] args) throws IOException {
        FileOutputStream       f = new FileOutputStream("test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream      zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);

        zos.setComment("Check ZIP-compressing Java"); // but Java have no method getComment()

        for (String arg : args) {
            System.out.println("Writing file " + arg);
            
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

            in.close();
            out.flush();
        }

        out.close();

        // Checksum is availabel ONLY after zip file closing !
        System.out.println("Checksum " + csum.getChecksum().getValue());

        // Unziping archive
        System.out.println("Reading zip-file");

        FileInputStream       fi = new FileInputStream("test.zip");
        CheckedInputStream csum1 = new CheckedInputStream(fi, new Adler32());
        ZipInputStream       in2 = new ZipInputStream(csum1);
        BufferedInputStream  bis = new BufferedInputStream(in2);

        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null) {
            System.out.println("Reading file " + ze);
            
            int x;
            while ((x = bis.read()) != -1) {
                System.out.write(x);
            }
        }

        if (args.length == 1) {
            System.out.println("\nChecksum: " + csum1.getChecksum().getValue());
        }

        bis.close();


        System.out.println();
        System.out.println("Alternate method reading zip=files");
        System.out.println();

        // Alternate method reading zip=files
        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry)e.nextElement();
            System.out.println("File: " + ze2);

            InputStream input = zf.getInputStream(ze2);

            int x;
            while ((x = input.read()) != -1) {
                System.out.write(x);
            }
            input.close();
        }

        zf.close();   
    }
}