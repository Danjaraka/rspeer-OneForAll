package org.Hoopster.GUI;

import org.Hoopster.Main;
import org.Hoopster.data.Trees;
import org.rspeer.runetek.api.movement.position.Area;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private JComboBox treeComboBox;
    private JButton initiate;
    public GUI() {
        super("Config");

        setLayout(new FlowLayout());

        initiate = new JButton("Initiate");

        treeComboBox = new JComboBox(Trees.values());       //Pulls from Trees enum
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        add(treeComboBox);
        add(initiate);

        initiate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.tree = (Trees) treeComboBox.getSelectedItem();
                setVisible(false);
            }
        });
        pack();                                             //Squishes the GUI
    }



    public static void main(String... args){
        new GUI().setVisible(true);
    }


}
