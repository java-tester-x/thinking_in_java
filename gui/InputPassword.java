package gui;

/**
 * RUN:
 *         javac -cp .; gui/InputPassword.java && java -cp .; gui.InputPassword
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import java.util.Arrays;

import net.mindview.util.*;

public class InputPassword extends JFrame {

    private static final int WIDTH  = 400;
    private static final int HEIHGT = 250;

    private char[] correctPassword = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

    private JPasswordField pwd = new JPasswordField(15);


    private ActionListener pwdListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            char[] input = pwd.getPassword();

            if (isPasswordCorrect(input)) {
                JOptionPane.showMessageDialog(InputPassword.this,
                    "Success! You typed the right password.");
            } else {
                JOptionPane.showMessageDialog(InputPassword.this,
                    "Invalid password. Try again.",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            }

            //Zero out the possible password, for security.
            Arrays.fill(input, '0');

            pwd.selectAll();
            resetFocus();
        }
    };

    private boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals(input, correctPassword);
        }

        return isCorrect;
    }

    protected void resetFocus() {
        pwd.requestFocusInWindow();
    }

    public InputPassword() {
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter password");
        add(label);
        add(pwd);
        pwd.addActionListener(pwdListener);
    }


    public static void main(String[] args) {
        SwingConsole.run(new InputPassword(), WIDTH, HEIHGT);
    }
}