package gui;

/**
 * RUN:
 *         javac gui/BoxLayout1.java && java gui.BoxLayout1
 * OUTPUT:
 *         
 */

import java.util.concurrent.*;
import javax.swing.*;
import java.awt.*;
import net.mindview.util.*;

public class BoxLayout1 extends JFrame {

    public BoxLayout1() {
        //Set up the content pane.
        addComponentsToPane(getContentPane());
    }

    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
 
        JButton b;
        for (int i = 0; i < 4; i++) {
            b = new JButton("Button " + i);
            b.setAlignmentX(Component.LEFT_ALIGNMENT);
            pane.add(b);
        }

        b = new JButton("Long-Named Button 4");
        b.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pane.add(b);
        
        b = new JButton("5");
        b.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pane.add(b);
    }

    public static void main(String[] args) {
        SwingConsole.run(new BoxLayout1(), 300, 300);
    }
}
