package gui;

/**
 * RUN:
 *         javac -cp .; gui/List2.java && java -cp .; gui.List2
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class List2 extends JFrame {
    
    private static final int WIDTH  = 250;
    private static final int HEIHGT = 375;

    private String[] flavors = {
        "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
        "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
        "Praline Cream", "Mud Pie",
        
    };

    // private DefaultListModel lItems = new DefaultListModel();
    // private JList            lst    = new JList(lItems);
    
    private JList            lst    = new JList(flavors);
    private JTextArea        t      = new JTextArea(flavors.length, 20);

    private ListSelectionListener ll = new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }

            t.setText("");
            for (Object item : lst.getSelectedValues()) {
                t.append(item + "\n");
            }
        }
    };

    private int count = 0;

    public List2() {
        t.setEditable(false);

        setLayout(new FlowLayout());

        Border brd = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK);
        // lst.setBorder(brd);
        t.setBorder(brd);

        // for (int i = 0; i < 4; i++) {
        //     lItems.addElement(flavors[count++]);
        // }

        add(t);

        JScrollPane scrollPane = new JScrollPane(lst);
        scrollPane.setPreferredSize(new Dimension(150, 100));
        add(scrollPane);

        lst.addListSelectionListener(ll);
    }

    public static void main(String[] args) {
        SwingConsole.run(new List2(), WIDTH, HEIHGT);
    }

}