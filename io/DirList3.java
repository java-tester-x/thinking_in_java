package io;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * RUN:
 *         javac io/DirList3.java && java io.DirList3
 *
 * OUTPUT:
 *         
 */

public class DirList3 {

    public static void main(final String[] args) {
        File path = new File(".");
        String[] list;

        if (args.length == 0) {
            list = path.list();
        }
        else {
            list = path.list(new FilenameFilter() {    
                private Pattern pattern = Pattern.compile(args[0]);
                
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }

        // System.out.println(Arrays.toString(list));

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}