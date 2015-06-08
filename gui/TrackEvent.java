package gui;

/**
 * RUN:
 *         javac gui/TrackEvent.java && java gui.TrackEvent
 * OUTPUT:
 *         
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

import net.mindview.util.*;

public class TrackEvent extends JFrame {

    private HashMap<String, JTextField> h = new HashMap<String, JTextField>();

    private String[] = {
        "focusGained", "focusLost", "focusPressed",
        "keyReleased", "keyTyped", "mouseClicked",
        "mouseEntered", "mouseExited", "mousePressed",
        "mouseReleased", "mouseDragged", "mouseMoved"
    };

    public TrackEvent() {
        
    }

    public static void main(String[] args) {
        SwingConsole.run(new TrackEvent(), 300, 400;
    }
}