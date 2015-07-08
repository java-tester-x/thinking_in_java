package gui;

/**
 * RUN:
 *         javac -cp .; gui/Borders.java && java -cp .; gui.Borders
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class Borders extends JFrame {
    
    private static final int WIDTH  = 500;
    private static final int HEIHGT = 300;

    static JPanel showBorder(Border b) {
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());

        String nm = b.getClass().toString();
        nm = nm.substring(nm.lastIndexOf('.') + 1);
        
        jp.add(new JLabel(nm, JLabel.CENTER), BorderLayout.CENTER);
        jp.setBorder(b);

        return jp;
    }
    
    public Borders() {
        setLayout(new GridLayout(2, 4));
        add(showBorder(new TitledBorder("Title")));
        add(showBorder(new EtchedBorder()));
        add(showBorder(new LineBorder(Color.BLUE)));
        add(showBorder(new MatteBorder(5, 5, 30, 30, Color.GREEN)));
        add(showBorder(new BevelBorder(BevelBorder.RAISED)));
        add(showBorder(new SoftBevelBorder(BevelBorder.LOWERED)));
        add(showBorder(new CompoundBorder(new EtchedBorder(), new LineBorder(Color.RED))));
    }


    public static void main(String[] args) {
        SwingConsole.run(new Borders(), WIDTH, HEIHGT);
    }
}