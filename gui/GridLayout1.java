package gui;

/**
 * RUN:
 *         javac gui/GridLayout1.java && java gui.GridLayout1
 * OUTPUT:
 *         
 */

import java.util.concurrent.*;
import javax.swing.*;
import java.awt.*;
import net.mindview.util.*;

public class GridLayout1 extends JFrame {

    public GridLayout1() {
        setLayout(new GridLayout(7, 3));
        for (int i = 0; i < 20; i++) {
            add(new JButton("Button " + i));
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new GridLayout1(), 300, 300);
    }
}
