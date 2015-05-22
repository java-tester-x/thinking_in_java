package gui;

/**
 * RUN:
 *         javac gui/Button1.java && java gui.Button1
 * OUTPUT:
 *         
 */

import java.util.concurrent.*;
import javax.swing.*;
import java.awt.*;
import net.mindview.util.*;

public class Button1 extends JFrame {

    private JButton b1 = new JButton("Button 1");
    private JButton b2 = new JButton("Button 2");

    public Button1() {
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button1(), 200,200);
    }
}