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
    private JTextField field  = new JTextField(40);
    private JTextArea  area   = new JTextArea(40, 65);

    FocusListener fl = new FocusListener() {
        public void focusGained(FocusEvent e) {
            log(e.paramString());
        }
        
        public void focusLost(FocusEvent e) {
            log(e.paramString());
        }
    };

    KeyListener kl = new KeyListener() {
        public void keyPressed(KeyEvent e) {
            log(e.paramString());
        }
        
        public void keyReleased(KeyEvent e) {
            log(e.paramString());
        }

        public void keyTyped(KeyEvent e) {
            log(e.paramString());
        }
    };

    private void log(String message) {
        area.append(message+"\n");
    }

    public ButtonTrackEvent() {
        addComponentsToPane(getContentPane());
    }

    public void addComponentsToPane(Container pane) {
        

        button.addFocusListener(fl);
        button.addKeyListener(kl);
        
        JPanel panel = new JPanel();
        panel.add(button);

        pane.add(BorderLayout.SOUTH, panel);
        pane.add(new JScrollPane(area)); 
    }

    public static void main(String[] args) {
        SwingConsole.run(new ButtonTrackEvent(), WIDTH, HEIGHT);
    }
}