package gui;

/**
 * RUN:
 *         javac -cp .; gui/MenuItemsFromFile.java && java -cp .; gui.MenuItemsFromFile
 * OUTPUT:
 *         
 */

import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class MenuItemsFromFile extends JFrame {

    private static final int WIDTH  = 300;
    private static final int HEIHGT = 200;

    private JMenuBar mb = new JMenuBar();

    public MenuItemsFromFile()
    {
        add(mb);
        String[] words = getWordsFromFile("gui/MenuItemsFromFile.java");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    private String[] getWordsFromFile(String fileName)
    {
        java.util.List<String> words = new ArrayList<String>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));

            try {                
                String line;
                while ( (line = in.readLine()) != null) {
                    String[] tokens = line.split("\\s+");
                    words.addAll(Arrays.asList(tokens));
                }
            }
            finally {
                in.close();
            }    
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        String[] arr = new String[words.size()];
        return words.toArray(arr);
    }

    public static void main(String[] args) {
        SwingConsole.run(new MenuItemsFromFile(), WIDTH, HEIHGT);
    }
}