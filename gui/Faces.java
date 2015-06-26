package gui;

/**
 * RUN:
 *         javac -cp .; gui/Faces.java && java -cp .; gui.Faces
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

import java.lang.reflect.*;

import net.mindview.util.*;

public class Faces extends JFrame {
    private static final int WIDTH  = 250;
    private static final int HEIHGT = 125;

    private static Icon[] faces;

    private JButton jb;
    private JButton jb2 = new JButton("Disable");

    private boolean mad = false;

    public Faces() {
        faces = new Icon[] {
            new ImageIcon(getClass().getResource("Face0.gif")),
            new ImageIcon(getClass().getResource("Face1.gif")),
            new ImageIcon(getClass().getResource("Face2.gif")),
            new ImageIcon(getClass().getResource("Face3.gif")),
            new ImageIcon(getClass().getResource("Face4.gif")),
        };
        
        jb = new JButton("JButton", faces[3]);

        setLayout(new FlowLayout());

        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (mad) {
                    jb.setIcon(faces[3]);
                    mad = false;
                }
                else {
                    jb.setIcon(faces[0]);
                    mad = true;
                }
                jb.setVerticalAlignment(JButton.TOP);
                jb.setHorizontalAlignment(JButton.LEFT);
            }
        });
        jb.setRolloverEnabled(true);
        jb.setRolloverIcon(faces[1]);
        jb.setPressedIcon(faces[2]);
        jb.setDisabledIcon(faces[4]);
        jb.setToolTipText("Yow!");
        add(jb);

        jb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (jb.isEnabled()) {
                    jb.setEnabled(false);
                    jb2.setText("Enabled");
                }
                else {
                    jb.setEnabled(true);
                    jb2.setText("Disabled");
                }                
            }
        });
        add(jb2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Faces(), WIDTH, HEIHGT);
    }
}