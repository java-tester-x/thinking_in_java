package gui;

/**
 * RUN:
 *         javac gui/SubmitSwingProgram.java && java gui.SubmitSwingProgram
 * OUTPUT:
 *         
 */

import java.util.concurrent.*;
import javax.swing.*;

public class SubmitSwingProgram extends JFrame {
    JLabel label;

    public SubmitSwingProgram() {
        super("Hello Swing");
        
        label = new JLabel("A Label");
        add(label);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);
        setVisible(true);
    }

    static SubmitSwingProgram ssp;

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ssp = new SubmitSwingProgram();
            }
        });

        TimeUnit.SECONDS.sleep(1);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ssp.label.setText("Hey! This is Different!");
            }
        });
    }
}