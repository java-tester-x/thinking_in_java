package gui;

/**
 * RUN:
 *         javac -cp .; gui/TextFields.java && java -cp .; gui.TextFields
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

import net.mindview.util.*;

public class TextFields extends JFrame {

    private static final int WIDTH  = 375;
    private static final int HEIHGT = 200;

    private JButton b1 = new JButton("Get Text");
    private JButton b2 = new JButton("Set Text");

    private JTextField t1 = new JTextField(30);
    private JTextField t2 = new JTextField(30);
    private JTextField t3 = new JTextField(30);

    private String s = "";

    private UpperCaseDocument ucd = new UpperCaseDocument();

    public TextFields() {
        t1.setDocument(ucd);
        ucd.addDocumentListener(new T1());

        b1.addActionListener(new B1());
        b2.addActionListener(new B2());

        t1.addActionListener(new T1A());

        setLayout(new FlowLayout());

        add(b1);
        add(b2);
        add(t1);
        add(t2);
        add(t3);
    }

    class T1 implements DocumentListener {
        public void changedUpdate(DocumentEvent e) {}

        public void insertUpdate(DocumentEvent e) {
            // t2.setText(t1.getText());
            t2.setText(t2.getText()+ucd.getOriginalText());
            t3.setText("Text: " + t1.getText());
        }

        public void removeUpdate(DocumentEvent e) {
            t2.setText(t1.getText());
        }
    }

    class T1A implements ActionListener {
        private int count = 0;

        public void actionPerformed(ActionEvent e) {
            t3.setText("t1 Action Event: " + count++);
        }
    }

    class B1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (t1.getSelectedText() == null) {
                s = t1.getText();
            }
            else {
                s = t1.getSelectedText();
            }
            t1.setEditable(true);
        }
    }

    class B2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ucd.setUpperCase(false);
            t1.setText("Inserted by Button 2: " + s);
            ucd.setUpperCase(true);
            t1.setEditable(false);
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextFields(), WIDTH, HEIHGT);
    }
}

class UpperCaseDocument extends PlainDocument {

    private boolean upperCase = true;
    private String  originalText;

    public void setUpperCase(boolean flag) {
        upperCase = flag;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void insertString(int offset, String str, AttributeSet attSet) 
    throws BadLocationException {
        originalText = str;
        if (upperCase) {
            str = str.toUpperCase();
        }
        super.insertString(offset, str, attSet);
    }
}