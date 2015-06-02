package gui;

/**
 * RUN:
 *         javac gui/FlowLayout1.java && java gui.FlowLayout1
 * OUTPUT:
 *         
 */

import java.util.concurrent.*;
import javax.swing.*;
import java.awt.*;
import net.mindview.util.*;

public class FlowLayout1 extends JFrame {

    public FlowLayout1() {
        setLayout(new FlowLayout());
        for (int i = 0; i < 20; i++) {
            add(new JButton("Button " + i));
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new FlowLayout1(), 300, 300);
    }
}
