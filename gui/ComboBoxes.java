package gui;

/**
 * RUN:
 *         javac -cp .; gui/ComboBoxes.java && java -cp .; gui.ComboBoxes
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class ComboBoxes extends JFrame {

    private static final int WIDTH  = 200;
    private static final int HEIHGT = 175;

    private String[] description = {
        "Ebullient", "Obtuse", "Recalcitrant", "Brilliant",
        "Somnescent", "Timorous", "Florid", "Putrescent"
    };

    private JTextField t = new JTextField(15);
    private JComboBox  c = new JComboBox();
    private JButton    b = new JButton("Add items");

    private int count = 0;

    public ComboBoxes() {
        for (int i = 0; i < 4; i++) {
            c.addItem(description[i]);
        }

        t.setEditable(false);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (count < description.length) {
                    c.addItem(description[count++]);
                }
            }
        });

        c.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t.setText("index: " + c.getSelectedIndex() + " "
                + ((JComboBox)e.getSource()).getSelectedItem());
            }
        });

        setLayout(new FlowLayout());
        add(t);
        add(c);
        add(b);
    }

    public static void main(String[] args) {
        SwingConsole.run(new ComboBoxes(), WIDTH, HEIHGT);
    }
} 