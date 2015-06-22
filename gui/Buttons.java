package gui;

/**
 * RUN:
 *         javac -cp .; gui/Buttons.java && java -cp .; gui.Buttons
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class Buttons extends JFrame {

    private static final int WIDTH  = 350;
    private static final int HEIHGT = 200;


    private JButton          jb    = new JButton("JButton");
    private BasicArrowButton up    = new BasicArrowButton(BasicArrowButton.NORTH);
    private BasicArrowButton down  = new BasicArrowButton(BasicArrowButton.SOUTH);
    private BasicArrowButton right = new BasicArrowButton(BasicArrowButton.EAST);
    private BasicArrowButton left  = new BasicArrowButton(BasicArrowButton.WEST);

    public Buttons() {
        setLayout(new FlowLayout());
        add(jb);
        add(new JToggleButton("JToggleButton"));
        add(new JCheckBox("JCheckBox"));
        add(new JRadioButton("JRadioButton"));

        JPanel jp = new JPanel();
        jp.setBorder(new TitledBorder("Directions"));
        jp.add(up);
        jp.add(down);
        jp.add(left);
        jp.add(right);

        add(jp);
    }


    public static void main(String[] args) {
        SwingConsole.run(new Buttons(), WIDTH, HEIHGT);
    }
}