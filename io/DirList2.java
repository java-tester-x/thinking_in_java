package io;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * RUN:
 *         javac io/DirList2.java && java io.DirList2
 *
 * OUTPUT:
 *         
 */

public class DirList2 {

    public static FilenameFilter filter(final String regexp)
    {
        return new FilenameFilter() {    
            private Pattern pattern = Pattern.compile(regexp);
            
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
    
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;

        if (args.length == 0) {
            list = path.list();
        }
        else {
            list = path.list(filter(args[0]));
        }

        // System.out.println(Arrays.toString(list));

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}