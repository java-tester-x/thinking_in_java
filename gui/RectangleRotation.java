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
import java.awt.geom.*;

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

            //
            Graphics2D g2 = (Graphics2D) g;

            // 
            g2.setRenderingHints(new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
            ));
            g2.setRenderingHints(new RenderingHints(
                RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY
            ));

            // 
            AffineTransform at = new AffineTransform();
            
            Dimension  d  = getSize();
            int w = d.width;
            int h = d.height;
            
            int xTopLeft  = (w - rectSize)/2;
            int yTopLeft  = (h - rectSize)/2;

            at.rotate(Math.toRadians(45));            
            Shape rect = new Rectangle(xTopLeft, yTopLeft, rectSize, rectSize);
            
            g2.setColor(Color.RED);
            g2.draw(rect);           
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