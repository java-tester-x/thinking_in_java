package gui;

/**
 * RUN:
 *         javac gui/SubmitSwingProgram2.java && java gui.SubmitSwingProgram2
 * OUTPUT:
 *         
 */

import net.mindview.util.*;

import java.util.concurrent.*;
import javax.swing.*;

public class SubmitSwingProgram2 extends JFrame {
    JLabel label;

    public SubmitSwingProgram2() {
        super("Hello Swing");
        
        label = new JLabel("A Label");
        add(label);
    }

    static SubmitSwingProgram2 ssp;

    public static void main(String[] args) throws Exception {
        ssp = new SubmitSwingProgram2();
        SwingConsole.run(ssp, 300, 100);

        TimeUnit.SECONDS.sleep(1);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ssp.label.setText("Hey! This is Different!");
            }
        });
    }
}