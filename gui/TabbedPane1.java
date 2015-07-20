package gui;

/**
 * RUN:
 *         javac -cp .; gui/TabbedPane1.java && java -cp .; gui.TabbedPane1
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class TabbedPane1 extends JFrame {

    private static final int WIDTH  = 400;
    private static final int HEIHGT = 250;

    private String[] flavors = {
        "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
        "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
        "Praline Cream", "Mud Pie"
    };

    private JTabbedPane tabs = new JTabbedPane();
    private JTextField  txt  = new JTextField(20);

    public TabbedPane1() {
        int i = 0;
        for (String flavor : flavors) {
            tabs.addTab(flavors[i], new JButton("Tabbed pane "+ i++));
        }

        tabs.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                // txt.setText("Tab selected: " + tabs.getSelectedIndex());
                txt.setText("Tab selected: " + tabs.getTitleAt(tabs.getSelectedIndex()));
            }
        });

        add(BorderLayout.SOUTH, txt);
        add(tabs);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TabbedPane1(), WIDTH, HEIHGT);
    }
}