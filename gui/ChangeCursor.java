package gui;

/**
 * RUN:
 *         javac gui/ChangeCursor.java && java gui.ChangeCursor
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

import java.text.*;

import net.mindview.util.*;

public class ChangeCursor extends JFrame {

    private JButton b0 = new JButton("Button 0");
    private JButton b1 = new JButton("Button 1");
    private JButton b2 = new JButton("Button 2");
    private JButton b3 = new JButton("Button 3");

    public ChangeCursor() {
        super();

        b0.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        b2.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        b3.setCursor(new Cursor(Cursor.MOVE_CURSOR));

        // Create panell
        JPanel panel = new JPanel(new GridBagLayout());

        panel.add(b0);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);

        add(panel); 
    }

    public static void main(String[] args) {
        SwingConsole.run(new ChangeCursor(), 475, 425);
    }
}