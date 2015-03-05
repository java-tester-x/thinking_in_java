package io;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * RUN:
 *         javac io/MakeDirectories.java && java io.MakeDirectories MakeDirectoriesTest
 *         
 * OUTPUT:
 *         created MakeDirectoriesTest
 *         Full name: D:\\univer\java\\thinking_in_java\\MakeDirectoriesTest
 *          awailable for reading: true
 *          awailable for writing: true
 *          file name getName(): MakeDirectoriesTest
 *          parent directory getParent(): null
 *          path getPath(): MakeDirectoriesTest
 *          size: 0
 *          last modified date: 1425444969289
 *         Is directory
 */

public class MakeDirectories {

    private static void usage() {
        System.err.println(
            "Using: MakeDirectories path1 ...\n" +
            "Create all paths\n" +
            "Using: MakeDirectories -d paht1 ...\n" +
            "Remove all paths\n" +
            "Using: MakeDirectories -r path1 path2\n" +
            "Rename path1 to path2\n"
        );
        System.exit(1);
    }

    private static void fileData(File f) {
        System.out.println(
            "Full name: " + f.getAbsolutePath() +
            "\n awailable for reading: " + f.canRead() +
            "\n awailable for writing: " + f.canWrite() +
            "\n file name getName(): " + f.getName() +
            "\n parent directory getParent(): " + f.getParent() +
            "\n path getPath(): " + f.getPath() +
            "\n size: " + f.length() +
            "\n last modified date: " + f.lastModified()
        );

        if (f.isFile()) {
            System.out.println("Is file");
        }
        else if (f.isDirectory()) {
            System.out.println("Is directory");
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            usage();
        }

        if (args[0].equals("-r")) {
            if (args.length != 3) {
                usage();
            }

            File old = new File(args[1]);
            File rname = new File(args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return;
        }

        int count = 0;
        boolean del = false;
        if (args[0].equals("-d")) {
            count++;
            del = true;
        }
        count--;

        while (++count < args.length) {
            File f = new File(args[count]);
            if (f.exists()) {
                System.out.println(f + " exists");
                if (del) {
                    System.out.println("deleting "+f);
                    f.delete();
                }
            }
            else {
                if (! del) {
                    f.mkdirs();
                    System.out.println("created " + f);
                }
            }
            fileData(f);
        }
    }
}