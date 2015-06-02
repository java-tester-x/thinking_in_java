package gui;

/**
 * RUN:
 *         javac gui/SplitPaneDemo2.java && java gui.SplitPaneDemo2
 * OUTPUT:
 *         
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
 
import java.util.*;

import net.mindview.util.*;
 
public class SplitPaneDemo2 extends JFrame {
    
    private AbstractDocument doc;

    private JTextPane  textPane; 
    private JTextArea  changeLog; 
    private JLabel     label;

    public SplitPaneDemo2() {
        super("SplitPaneDemo2");

        textPane = new JTextPane();
        textPane.setCaretPosition(0);
        textPane.setMargin(new Insets(5,5,5,5));
        StyledDocument styledDoc = textPane.getStyledDocument();
        if (styledDoc instanceof AbstractDocument) {
            doc = (AbstractDocument)styledDoc;
        } else {
            System.err.println("Text pane's document isn't an AbstractDocument!");
            System.exit(-1);
        }
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(200, 200));

        //Create the text area for the status log and configure it.
        changeLog = new JTextArea(5, 30);
        changeLog.setEditable(false);
        JScrollPane scrollPaneForLog = new JScrollPane(changeLog);
 
        //Create a split pane for the change log and the text area.
        JSplitPane leftPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, scrollPaneForLog);
        leftPane.setOneTouchExpandable(true);


        
        //XXXX: Bug #4131528, borders on nested split panes accumulate.
        //Workaround: Set the border on any split pane within
        //another split pane to null. Components within nested split
        //panes need to have their own border for this to work well.
        leftPane.setBorder(null);
 
        //Create a regular old label
        label = new JLabel("Click on an image name in the list.", JLabel.CENTER);
 
        //Create a split pane and put "top" (a split pane)
        //and JLabel instance in it.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, leftPane, label);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(180);
 
        //Provide minimum sizes for the two components in the split pane
        // leftPane.setMinimumSize(new Dimension(100, 50));
        label.setMinimumSize(new Dimension(100, 30));
 
        //Add the split pane to this frame
        getContentPane().add(splitPane);
    }

    public static void main(String[] args) {
        SwingConsole.run(new SplitPaneDemo2(), 600, 450);
    }
}