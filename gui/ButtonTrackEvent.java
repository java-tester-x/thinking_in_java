package gui;

/**
 * RUN:
 *         javac gui/ButtonTrackEvent.java && java gui.ButtonTrackEvent
 * OUTPUT:
 *         
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

import net.mindview.util.*;

public class ButtonTrackEvent extends JFrame {

    private static final int WIDTH  = 400;
    private static final int HEIGHT = 300;


    private JButton    button = new JButton("Button 0");
    private JTextField field  = new JTextField(25);

    public ButtonTrackEvent() {
        addComponentsToPane(getContentPane());
    }

    public void addComponentsToPane(Container pane) {
        JPanel panel = new JPanel(new GridBagLayout());

        
        panel.add(field);
        panel.add(button);

        pane.add(panel);
    }

    public static void main(String[] args) {
        SwingConsole.run(new ButtonTrackEvent(), WIDTH, HEIGHT);
    }
}