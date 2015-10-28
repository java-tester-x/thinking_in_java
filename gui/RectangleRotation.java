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
    private JSlider speedSlider      = new JSlider(0, 200, 10);

    

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

    static class MainContentPane extends JPanel implements ActionListener {

        private int rectSize        = 30;
        private int rotationSpeed   =  0;
        private int rotationAngle   =  0;

        private javax.swing.Timer timer;

        public MainContentPane() {
            // timer = new javax.swing.Timer(rotationSpeed, this);
            // timer.setInitialDelay(100);
            // timer.start();

            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    drawRectangle(rectSize, rotationSpeed);
                }
            };
            timer = new javax.swing.Timer(rotationSpeed, taskPerformer);
            timer.start();
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

            Dimension  d  = getSize();
            int w = d.width;
            int h = d.height;            
            int xTopLeft  = (w - rectSize)/2;
            int yTopLeft  = (h - rectSize)/2;

            g2.setColor(Color.RED);
            Shape rect = new Rectangle(xTopLeft, yTopLeft, rectSize, rectSize);
            Rectangle rb = rect.getBounds();
            
            Path2D.Double path = new Path2D.Double();
            path.append(rect, false);
            
            AffineTransform at = new AffineTransform();
            
            at.setToIdentity();
            // at.translate((rb.width/2), (rb.height/2));
            at.rotate(Math.toRadians(rotationAngle), w/2, h/2);
            path.transform(at);
            g2.draw(path);
        }

        public void setSize(int newSize) {
            // drawRectangle(newSize, rotationSpeed);
            this.rectSize = newSize;
        }

        public void setSpeed(int newSpeed) {
            // drawRectangle(rectSize, newSpeed);
            this.rotationSpeed = newSpeed;
        }

        public void drawRectangle(int newSize, int newSpeed)
        {
            rectSize      = newSize;
            rotationSpeed = newSpeed;
            this.rotationAngle++;

            timer.setDelay(rotationSpeed);

            repaint();
        }

        public void actionPerformed(ActionEvent e) {
            drawRectangle(this.rectSize, this.rotationSpeed);
            
        }
    }
}