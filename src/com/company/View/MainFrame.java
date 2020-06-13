package com.company.View;

import com.company.Controller.TreeListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    JFrame mainframe;

    public MainFrame() {
        mainframe = new JFrame("Calculator");
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Tree panelTree=new Tree();
        CalcFrame calculator =new CalcFrame(this,panelTree);

        Box box =Box.createHorizontalBox();
        JScrollPane treeScrollPane=new JScrollPane(panelTree.getTree());
        treeScrollPane.setPreferredSize(new Dimension(300, 600));

        box.add(treeScrollPane);
        box.add(Box.createHorizontalStrut(12));
        box.add(calculator.getCalc());

        panelTree.getTree().addTreeExpansionListener(new TreeListener(panelTree, calculator.getScreen()));

        mainframe.setContentPane(box);
        mainframe.setSize(new Dimension(800,600));
        mainframe.setVisible(true);
    }

    public JFrame getFrame(){
        return mainframe;
    }

}
