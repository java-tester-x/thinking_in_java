package gui;

/**
 * RUN:
 *         javac gui/Button2b.java && java gui.Button2b
 * OUTPUT:
 *         
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.mindview.util.*;

public class Button2b extends JFrame {

    private JButton b1 = new JButton("Button 1");
    private JButton b2 = new JButton("Button 2");

    private JTextField txt = new JTextField(10);

    private ActionListener bl = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton)e.getSource()).getText();
            txt.setText(name);
        }
    };

    public Button2b() {
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(txt);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button2b(), 200, 150);
    }
}