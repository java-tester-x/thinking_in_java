package gui;

/**
 * RUN:
 *         javac gui/ComponentsWithActionListener.java && java gui.ComponentsWithActionListener
 * OUTPUT:
 *         
 */

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

import java.text.*;

import net.mindview.util.*;

public class ComponentsWithActionListener extends JFrame  {

    private JButton b = new JButton("Button 1");
   
    private JCheckBox cb = new JCheckBox("Checkbox 1");
    
    private JRadioButton rb = new JRadioButton("RadioButton 1");
    
    private JMenuItem mi = new JMenuItem("MenuItem 1");
    
    private JCheckBoxMenuItem cbmi = new JCheckBoxMenuItem("CheckBoxMenuItem 1");
    
    private JRadioButtonMenuItem rbmi = new JRadioButtonMenuItem("RadioButtonMenuItem 1");

    private JToggleButton tb = new JToggleButton("ToggleButton 1");

    private JMenuBar menuBar = new JMenuBar();
    private JMenu    menu    = new JMenu("Menu 1");
    private JMenu    submenu = new JMenu("Submenu 1");

    private JTextField textField = new JTextField(20);
    private JFormattedTextField formattedTextField = new JFormattedTextField(NumberFormat.getNumberInstance());
    private JPasswordField passwordField = new JPasswordField(20);

    protected JTextArea textArea;
    private final static String newline = "\n";

    public ComponentsWithActionListener() {
        super();

        menuBar.add(menu);
        menu.add(mi);
        menu.addSeparator();
        menu.add(rbmi);
        menu.addSeparator();
        menu.add(submenu);
        submenu.add(cbmi);

        setJMenuBar(menuBar);

        JPanel panel = new JPanel(new GridBagLayout());
        

        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
 
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, c);
        panel.add(formattedTextField, c);
        formattedTextField.setColumns(20);
 
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        panel.add(scrollPane, c);

        add(panel);
        
    }

    public static void main(String[] args) {
        SwingConsole.run(new ComponentsWithActionListener(), 475, 425);
    }
}