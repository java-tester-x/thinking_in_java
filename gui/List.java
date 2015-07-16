package gui;

/**
 * RUN:
 *         javac -cp .; gui/List.java && java -cp .; gui.List
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class List extends JFrame {

    private static final int WIDTH  = 250;
    private static final int HEIHGT = 375;

    private String[] flavors = {
        "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
        "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
        "Praline Cream", "Mud Pie"
    };

    private DefaultListModel lItems = new DefaultListModel();
    private JList            lst    = new JList(lItems);
    private JTextArea        t      = new JTextArea(flavors.length, 20);
    private JButton          b      = new JButton("Add item");

    private ActionListener bl = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            if (count < flavors.length) {
                lItems.add(0, flavors[count++]);
            }
            else {
                b.setEnabled(false);
            }
        }
    };

    

    public List() {

    }

    public static void main(String[] args) {
        SwingConsole.run(new List(), WIDTH, HEIHGT);
    }
}