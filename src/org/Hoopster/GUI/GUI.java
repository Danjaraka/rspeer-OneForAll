package org.Hoopster.GUI;

import org.Hoopster.data.Trees;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JComboBox treeComboBox;
    private JButton intiate;
    public GUI() {
        super("Config");

        setLayout(new FlowLayout());

        intiate = new JButton("Initiate");
        treeComboBox = new JComboBox(Trees.values());       //Pulls from Trees enum
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        add(treeComboBox);
        add(intiate);

        pack();                                             //Squishes the GUI
    }

    public static void main(String... args){
        new GUI().setVisible(true);
    }
}
