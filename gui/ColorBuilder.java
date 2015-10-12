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

    private static final int WIDTH  = 300;
    private static final int HEIHGT = 180;

    private JSlider aRedSlider   = new JSlider(0, 255, 50);
    private JSlider aGreenSlider = new JSlider(0, 255, 50);
    private JSlider aBlueSlider  = new JSlider(0, 255, 50);
    
    private JTextField aRedValue    = new JTextField("50", 5);
    private JTextField aGreenValue  = new JTextField("50", 5);
    private JTextField aBlueValue   = new JTextField("50", 5);

    private JLabel aRedLabel    = new JLabel("Red");
    private JLabel aGreenLabel  = new JLabel("Green");
    private JLabel aBlueLabel   = new JLabel("Blue");

    private JPanel colorPanel = new JPanel();

    public ColorBuilder()
    {
        add(colorPanel);
        colorPanel.setOpaque(true);
        colorPanel.setBackground(buildColor());

        aRedValue.setEditable(false);
        aGreenValue.setEditable(false);
        aBlueValue.setEditable(false);

        GroupLayout layout = new GroupLayout(colorPanel);
        colorPanel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(aRedLabel)
                    .addComponent(aGreenLabel)
                    .addComponent(aBlueLabel)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(aRedSlider)
                    .addComponent(aGreenSlider)
                    .addComponent(aBlueSlider)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(aRedValue)
                    .addComponent(aGreenValue)
                    .addComponent(aBlueValue)
                )
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(aRedLabel)
                    .addComponent(aRedSlider)
                    .addComponent(aRedValue, GroupLayout.PREFERRED_SIZE,
                                             GroupLayout.DEFAULT_SIZE,
                                             GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(aGreenLabel)
                    .addComponent(aGreenSlider)
                    .addComponent(aGreenValue, GroupLayout.PREFERRED_SIZE,
                                               GroupLayout.DEFAULT_SIZE,
                                               GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(aBlueLabel)
                    .addComponent(aBlueSlider)
                    .addComponent(aBlueValue, GroupLayout.PREFERRED_SIZE,
                                              GroupLayout.DEFAULT_SIZE,
                                              GroupLayout.PREFERRED_SIZE)
                )
        );

        aRedSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {                
                aRedValue.setText(String.valueOf(((JSlider) e.getSource()).getValue()));
                colorPanel.setBackground(buildColor());
            }
        });

        aGreenSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {                
                aGreenValue.setText(String.valueOf(((JSlider) e.getSource()).getValue()));
                colorPanel.setBackground(buildColor());
            }
        });

        aBlueSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {                
                aBlueValue.setText(String.valueOf(((JSlider) e.getSource()).getValue()));
                colorPanel.setBackground(buildColor());
            }
        });

    }

    private Color buildColor() {
        return new Color(
            Integer.parseInt(aRedValue.getText()),
            Integer.parseInt(aGreenValue.getText()),
            Integer.parseInt(aBlueValue.getText())
        );
    }

    public static void main(String[] args) {
        SwingConsole.run(new ColorBuilder(), WIDTH, HEIHGT);
    }
}