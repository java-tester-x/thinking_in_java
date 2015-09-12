package gui;

/**
 * RUN:
 *         javac -cp .; gui/Popup.java && java -cp .; gui.Popup
 * OUTPUT:
 *         
 */

import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class Popup extends JFrame {

    private static final int WIDTH  = 300;
    private static final int HEIHGT = 200;

    private JPopupMenu popup = new JPopupMenu();
    private JTextField t     = new JTextField(10);

    public Popup() {
        setLayout(new FlowLayout());

        add(t);

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText(((JMenuItem)e.getSource()).getText());
            }
        };

        JMenuItem m = new JMenuItem("Hither");
        m.addActionListener(al);
        popup.add(m);

        m = new JMenuItem("Yon");
        m.addActionListener(al);
        popup.add(m);

        m = new JMenuItem("Afar");
        m.addActionListener(al);
        popup.add(m);

        popup.addSeparator();

        m = new JMenuItem("Stay Here");
        m.addActionListener(al);
        popup.add(m);

        PopupListener pl = new PopupListener();
        addMouseListener(pl);

        t.addMouseListener(pl);
    }


    class PopupListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void maybeShowPopup(MouseEvent e) {
            popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }


    public static void main(String[] args) {
        SwingConsole.run(new Popup(), WIDTH, HEIHGT);
    }    
}