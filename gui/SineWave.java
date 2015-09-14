package gui;

/**
 * RUN:
 *         javac -cp .; gui/SineWave.java && java -cp .; gui.SineWave
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

public class SineWave extends JFrame {

    private static final int WIDTH  = 700;
    private static final int HEIHGT = 400;

    private SineDraw sines = new SineDraw();

    private JSlider adjustCycles = new JSlider(1, 30, 5);

    public SineWave() {
        add(sines);

        adjustCycles.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sines.setCycles(
                    ((JSlider) e.getSource()).getValue()
                );
            }
        });

        add(BorderLayout.SOUTH, adjustCycles);
    }

    public static void main(String[] args) {
        SwingConsole.run(new SineWave(), WIDTH, HEIHGT);
    }
}


class SineDraw extends JPanel {

    private static final int SCALEFACTOR = 200;

    private int cycles;
    private int points;
    private double[] sines;
    private int[] pts;

    public SineDraw() {
        setCycles(5);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int maxWidth = getWidth();
        
        double hstep = (double)maxWidth / (double)points;

        int maxHeight = getHeight();

        pts = new int[points];
        for (int i =0; i < points; i++) {
            pts[i] = (int) (sines[i]*maxHeight/2 * 0.95 + maxHeight/2);
        }
        g.setColor(Color.RED);

        for(int i = 1; i < points; i++) {
            int x1 = (int) ((i -1) * hstep);
            int x2 = (int) (i * hstep);
            int y1 = pts[i-1];
            int y2 = pts[i];
            g.drawLine(x1,y1, x2, y2);
        }
    }

    public void setCycles(int newCycles) {
        cycles = newCycles;
        points = SCALEFACTOR * cycles * 2;

        sines = new double[points];

        for(int i = 0; i < points; i++) {
            double radians = (Math.PI / SCALEFACTOR) * i;
            sines[i] = Math.sin(radians);
        }

        repaint();
    }
}