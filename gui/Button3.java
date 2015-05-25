package gui;

/**
 * RUN:
 *         javac gui/Button3.java && java gui.Button3
 * OUTPUT:
 *         
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.mindview.util.*;

public class Button3 extends JFrame {

    private JButton b1 = new JButton("Button 1");
    private JButton b2 = new JButton("Button 2");
    private JButton b3 = new JButton("Button 3");

    private JTextField txt = new JTextField(10);

    private ActionListener bl = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton)e.getSource()).getText();
            txt.setText(name);
        }
    };

    public Button3() {
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        b3.addActionListener(bl);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        add(txt);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button3(), 200, 150);
    }
}