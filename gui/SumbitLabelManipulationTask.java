package gui;

/**
 * RUN:
 *         javac gui/SumbitLabelManipulationTask.java && java gui.SumbitLabelManipulationTask
 * OUTPUT:
 *         
 */

import java.util.concurrent.*;
import javax.swing.*;

public class SumbitLabelManipulationTask {

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Hello Swing");
        final JLabel label = new JLabel("A Label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                label.setText("Hey! This is Different!");
            }
        });
    }
}