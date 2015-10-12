package gui;

/**
 * RUN:
 *         javac -cp .; gui/ColorBuilder.java && java -cp .; gui.ColorBuilder
 * OUTPUT:
 *         
 */

import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class ColorBuilder extends JFrame {

    private static final int WIDTH  = 700;
    private static final int HEIHGT = 400;

    private JSlider aRedSlider   = new JSlider(0, 255, 1);
    private JSlider aGreenSlider = new JSlider(0, 255, 1);
    private JSlider aBlueSlider  = new JSlider(0, 255, 1);
    
    private JTextField aRedValue    = new JTextField(5);
    private JTextField aGreenValue  = new JTextField(5);
    private JTextField aBlueValue   = new JTextField(5);

    public ColorBuilder() {
        JPanel panel = new JPanel();
        
        Color(int r, int g, int b)
        
        add(panel);

        add(aRedSlider);
        add(aRedValue);
        
        add(aGreenSlider);
        add(aGreenValue);
        
        add(aBlueSlider);
        add(aBlueValue);


        aRedSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {                
                aRedValue = ((JSlider) e.getSource()).getValue();                
            }
        });

        aGreenSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {                
                aGreenValue = ((JSlider) e.getSource()).getValue();                
            }
        });

        aBlueSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {                
                aBlueValue = ((JSlider) e.getSource()).getValue();                
            }
        });

    }

    public static void main(String[] args) {
        SwingConsole.run(new ColorBuilder(), WIDTH, HEIHGT);
    }
}