package com.company.Controller;

import com.company.View.Calculator.*;
import com.company.View.Tree;
import com.company.View.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Radio implements ActionListener {

    private final PanelButtons buttons;
    private final MainFrame mainFrame;
    private final Tree tree;


    public Radio(PanelButtons buttons, MainFrame mainFrame, Tree tree) {
        this.buttons = buttons;
        this.mainFrame = mainFrame;
        this.tree = tree;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (buttons.PanelTrig.isSelected()) {
            buttons.getPanel().remove(buttons.getPanel().getComponentCount() - 1);

            Box newPanel = Box.createHorizontalBox();
            newPanel.add(buttons.mainPanel());
            newPanel.add(buttons.panelTrig());

            buttons.getPanel().add(newPanel);

            Dimension panelDimension = new Dimension(buttons.mainPanel().getWidth() + buttons.panelTrig().getWidth(), buttons.getPanel().getHeight());
            buttons.getPanel().setMinimumSize(panelDimension);
            buttons.getPanel().setSize(panelDimension);

            Dimension frameDimension=new Dimension(tree.getTree().getWidth() + buttons.getPanel().getWidth()+14, mainFrame.getFrame().getHeight());
            mainFrame.getFrame().setMinimumSize(frameDimension);
            mainFrame.getFrame().setSize(frameDimension);

            buttons.getPanel().validate();

        } else {
            buttons.getPanel().remove(buttons.getPanel().getComponentCount() - 1);
            buttons.getPanel().add(buttons.mainPanel());

            Dimension panelDimension = new Dimension(buttons.mainPanel().getWidth(), buttons.getPanel().getHeight());

            buttons.getPanel().setMinimumSize(panelDimension);
            buttons.getPanel().setSize(panelDimension);

            Dimension frameDimension=new Dimension(tree.getTree().getWidth() + buttons.getPanel().getWidth()+14, mainFrame.getFrame().getHeight());
            mainFrame.getFrame().setMinimumSize(frameDimension);
            mainFrame.getFrame().setSize(frameDimension);

            buttons.getPanel().validate();
        }


    }
}
