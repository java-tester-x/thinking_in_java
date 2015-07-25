package gui;

/**
 * RUN:
 *         javac -cp .; gui/MessageBoxes2.java && java -cp .; gui.MessageBoxes2
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class MessageBoxes2 extends JFrame {

    private static final int WIDTH  = 400;
    private static final int HEIHGT = 250;

    
    private JButton alertBtn = new JButton("Alert");
    private JButton yesnoBtn = new JButton("Yes/No");
    private JButton colorBtn = new JButton("Color");
    private JButton inputBtn = new JButton("Input");
    private JButton valsBtn  = new JButton("3 Vals");


    private ActionListener alertLsnr = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(
                MessageBoxes2.this, "There's a bug on you!", "Hey!",
                JOptionPane.ERROR_MESSAGE
            );
         }
    };

    private ActionListener yesnoLsnr = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showConfirmDialog(
                MessageBoxes2.this, "or no", "choose yes",
                JOptionPane.YES_NO_OPTION
            );
         }
    };

    private ActionListener colorLsnr = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Object[] options = {"Red", "Green"};
            int sel = JOptionPane.showOptionDialog(
                MessageBoxes2.this, "Choose a Color!", "Warning",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null, options, options[0]
            );

            if (sel != JOptionPane.CLOSED_OPTION) {
                txt.setText("Color Selected: " + options[sel]);
            }
         }
    };

    private ActionListener inputLsnr = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String val = JOptionPane.showInputDialog(
                MessageBoxes2.this, "How many fingers do you see?"
            );
            txt.setText(val);
         }
    };

    private ActionListener valsLsnr = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Object[] selections = {"First", "Second", "Third"};
            Object val = JOptionPane.showInputDialog(
                MessageBoxes2.this, "Choose one", "Input",
                JOptionPane.INFORMATION_MESSAGE,
                null, selections, selections[0]
            );

            if (val != null) {
                txt.setText(val.toString());
            }
         }
    };

    private JTextField txt = new JTextField(15);

    public MessageBoxes2() {
        setLayout(new FlowLayout());
        
        alertBtn.addActionListener(alertLsnr);
        yesnoBtn.addActionListener(yesnoLsnr);
        colorBtn.addActionListener(colorLsnr);
        inputBtn.addActionListener(inputLsnr);
        valsBtn.addActionListener (valsLsnr); 

        for (JButton b : (new JButton[]{alertBtn, yesnoBtn, colorBtn, inputBtn, valsBtn})) {
            add(b);
        }
        add(txt);
    }

    public static void main(String[] args) {
        SwingConsole.run(new MessageBoxes2(), WIDTH, HEIHGT);
    }
}