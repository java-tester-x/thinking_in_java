package gui;

/**
 * RUN:
 *         javac gui/BorderLayout1.java && java gui.BorderLayout1
 * OUTPUT:
 *         
 */

import java.util.concurrent.*;
import javax.swing.*;
import java.awt.*;
import net.mindview.util.*;

public class BorderLayout1 extends JFrame {

    public BorderLayout1() {
        add(BorderLayout.NORTH, new JButton("North"));
        add(BorderLayout.SOUTH, new JButton("South"));
        add(BorderLayout.EAST, new JButton("East"));
        add(BorderLayout.WEST, new JButton("West"));
        add(BorderLayout.CENTER, new JButton("Center"));
    }

    public static void main(String[] args) {
        SwingConsole.run(new BorderLayout1(), 300, 250);
    }
}