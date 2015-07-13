package gui;

/**
 * RUN:
 *         javac -cp .; gui/RadioButtons.java && java -cp .; gui.RadioButtons
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class RadioButtons extends JFrame {

    private static final int WIDTH  = 200;
    private static final int HEIHGT = 125;

    private JTextField   t   = new JTextField(15);

    private ButtonGroup  g   = new ButtonGroup();
    private JRadioButton rb1 = new JRadioButton("one", false);
    private JRadioButton rb2 = new JRadioButton("two", false);
    private JRadioButton rb3 = new JRadioButton("three", false);

    private ActionListener al = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            t.setText("Radio button " + ((JRadioButton)e.getSource()).getText());
        }
    };


    public RadioButtons() {
        rb1.addActionListener(al);
        rb2.addActionListener(al);
        rb3.addActionListener(al);
        
        g.add(rb1);
        g.add(rb2);
        g.add(rb3);

        t.setEditable(false);

        setLayout(new FlowLayout());

        add(t);
        add(rb1);
        add(rb2);
        add(rb3);
    }

    public static void main(String[] args) {
        SwingConsole.run(new RadioButtons(), WIDTH, HEIHGT);
    }
}