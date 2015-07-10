package gui;

/**
 * RUN:
 *         javac -cp .; gui/TextPane.java && java -cp .; gui.TextPane
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class TextPane extends JFrame {

    private static final int WIDTH  = 475;
    private static final int HEIHGT = 425;

    private JButton   b = new JButton("Add Text");
    private JTextPane tp = new JTextPane();

    private static Generator sg = new RandomGenerator.String(7);

    public TextPane() {
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 10; i++) {
                    tp.setText(tp.getText() + sg.next() + "\n");
                }
            }
        });

        add(new JScrollPane(tp));
        add(BorderLayout.SOUTH, b);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextPane(), WIDTH, HEIHGT);
    }
}