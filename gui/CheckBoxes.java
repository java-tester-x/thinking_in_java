package gui;

/**
 * RUN:
 *         javac -cp .; gui/CheckBoxes.java && java -cp .; gui.CheckBoxes
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class CheckBoxes extends JFrame {

    private static final int WIDTH  = 200;
    private static final int HEIHGT = 300;

    private JTextArea t = new JTextArea(6, 15);

    private JCheckBox cb1 = new JCheckBox("Check Box 1"); 
    private JCheckBox cb2 = new JCheckBox("Check Box 2"); 
    private JCheckBox cb3 = new JCheckBox("Check Box 3"); 

    public CheckBoxes() {
        cb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trace("1", cb1);
            }
        });
        cb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trace("1", cb2);
            }
        });
        cb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trace("1", cb3);
            }
        });

        setLayout(new FlowLayout());
        add(new JScrollPane(t));
        add(cb1);
        add(cb2);
        add(cb3);
    }

    private void trace(String b, JCheckBox cb) {
        if (cb.isSelected()) {
            t.append("Box " + b + " Set\n");
            return;
        }
        t.append("Box " + b + " Cleared\n");
    }

    public static void main(String[] args) {
        SwingConsole.run(new CheckBoxes(), WIDTH, HEIHGT);
    }
}