package gui;

/**
 * RUN:
 *         javac -cp .; gui/RectangleRotation.java && java -cp .; gui.RectangleRotation
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

public class RectangleRotation extends JFrame {
    
    private static final int WIDTH  = 640;
    private static final int HEIHGT = 480;

    private MainContentPane mainPane = new MainContentPane();
    private JSlider sizeSlider       = new JSlider(0, 255, 50);
    private JSlider speedSlider      = new JSlider(0, 255, 50);

    public RectangleRotation()
    {
        mainPane.setOpaque(true); //content panes must be opaque
        // setContentPane(mainPane);

        add(mainPane);

        sizeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                mainPane.setSize(
                    ((JSlider) e.getSource()).getValue()
                );
            }
        });

        speedSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                mainPane.setSpeed(
                    ((JSlider) e.getSource()).getValue()
                );
            }
        });

        JPanel botomPane = new JPanel();
        GroupLayout layout = new GroupLayout(botomPane);
        botomPane.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sizeSlider)
                    .addComponent(speedSlider)
                )
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(sizeSlider)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(speedSlider)
                )
        );

        add(BorderLayout.SOUTH, botomPane);
    }

    public static void main(String[] args) {
        SwingConsole.run(new RectangleRotation(), WIDTH, HEIHGT);
    }

    static class MainContentPane extends JPanel {

        private int rectSize        = 0;
        private int rotationSpeed   = 0;

        public MainContentPane() {
            drawRectangle(30, 0);
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            int maxWidth  = getWidth();
            int maxHeight = getHeight();

            int xTopLeft  = (maxWidth  - rectSize)/2;
            int yTopLeft  = (maxHeight - rectSize)/2;

            g.setColor(Color.RED);
            g.drawRect(xTopLeft, yTopLeft, rectSize, rectSize);
        }

        public void setSize(int newSize) {
            drawRectangle(newSize, rotationSpeed);
        }

        public void setSpeed(int newSpeed) {
            drawRectangle(rectSize, newSpeed);
        }

        public void drawRectangle(int newSize, int newSpeed)
        {
            rectSize      = newSize;
            rotationSpeed = newSpeed;

            repaint();
        }
    }
}