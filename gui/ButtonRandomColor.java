package gui;

/**
 * RUN:
 *         javac -cp .; gui/ButtonRandomColor.java && java -cp .; gui.ButtonRandomColor
 * OUTPUT:
 *         
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

import net.mindview.util.*;

public class ButtonRandomColor extends JFrame {

    private static final int WIDTH  = 300;
    private static final int HEIGHT = 230;

    private Random rand = new Random(47);

    public ButtonRandomColor() {
        ColorButton button = new ColorButton("Color button");
        add(button);
    }

    private ActionListener bl = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof ColorButton) {
                ((ColorButton)e.getSource()).setBackground(new Color(rand.nextInt(0xFFFFFF)));
            }
        }
    };

    class ColorButton extends JButton {

        public ColorButton(String label) {
            super(label);
            addActionListener(bl);
            bl.actionPerformed(new ActionEvent("", 0, ""));
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new ButtonRandomColor(), WIDTH, HEIGHT);
    }
}