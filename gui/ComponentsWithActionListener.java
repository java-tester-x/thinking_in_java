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

    private ActionListener action = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String name = new String("x");
            if (e.getSource() instanceof JButton ) {
                name = ((JButton)e.getSource()).getText();
            }
            else if (e.getSource() instanceof JCheckBox) {
                name = ((JCheckBox)e.getSource()).getText();
            }
            else if (e.getSource() instanceof JRadioButton) {
                name = ((JRadioButton)e.getSource()).getText();
            }
            else if (e.getSource() instanceof JMenuItem) {
                name = ((JMenuItem)e.getSource()).getText();
            }
            else if (e.getSource() instanceof JCheckBoxMenuItem) {
                name = ((JMenuItem)e.getSource()).getText();
            }
            else if (e.getSource() instanceof JRadioButtonMenuItem) {
                name = ((JCheckBoxMenuItem)e.getSource()).getText();
            } 
            else if (e.getSource() instanceof JToggleButton) {
                name = ((JToggleButton)e.getSource()).getText();
            } 
            else if (e.getSource() instanceof JTextField) {
                name = ((JTextField)e.getSource()).getText();
            } 
            else if (e.getSource() instanceof JFormattedTextField) {
                name = ((JFormattedTextField)e.getSource()).getText();
            }
            else if (e.getSource() instanceof JPasswordField) {
                name = ((JPasswordField)e.getSource()).getText();
            }  
            textArea.append(name + newline);
            
        }
    };

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

        panel.add(passwordField, c);
 
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        panel.add(scrollPane, c);


        b.addActionListener(action);
        cb.addActionListener(action);
        rb.addActionListener(action);
        tb.addActionListener(action);
        textField.addActionListener(action);
        formattedTextField.addActionListener(action);
        passwordField.addActionListener(action);

        panel.add(b);
        panel.add(rb);
        panel.add(cb);
        panel.add(tb);

        add(panel);
        
    }

    public static void main(String[] args) {
        SwingConsole.run(new ComponentsWithActionListener(), 475, 425);
    }
}