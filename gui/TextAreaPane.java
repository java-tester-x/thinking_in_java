package gui;

/**
 * RUN:
 *         javac -cp .; gui/TextAreaPane.java && java -cp .; gui.TextAreaPane
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class TextAreaPane extends JFrame {

    private static final int WIDTH  = 475;
    private static final int HEIHGT = 425;

    private JButton   b = new JButton("Add Text");
    private JTextArea ta = new JTextArea();

    private static Generator sg = new RandomGenerator.String(7);

    public TextAreaPane() {
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 10; i++) {
                    ta.append(sg.next() + "\n");
                }
            }
        });

        add(new JScrollPane(ta));
        add(BorderLayout.SOUTH, b);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextAreaPane(), WIDTH, HEIHGT);
    }
}