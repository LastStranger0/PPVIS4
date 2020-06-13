package com.company.View.Calculator;

import com.company.Controller.Command;
import com.company.Controller.Insert;
import com.company.Controller.Radio;

import javax.swing.*;
import java.awt.*;

import com.company.View.Tree;
import com.company.View.MainFrame;

public class PanelButtons {
    public final static String COMMAND = "command";
    public final static String INSERT = "insert";
    public JRadioButton PanelTrig;
    private final Box panelButtons;
    private final PanelScreen panelScreen;
    private final Tree tree;

    public PanelButtons(PanelScreen panelScreen, MainFrame mainFrame, Tree tree) {

        panelButtons = Box.createVerticalBox();
        this.panelScreen = panelScreen;
        this.tree=tree;

        PanelTrig = new JRadioButton("Trig");
        PanelTrig.addActionListener(new Radio(this, mainFrame,tree));
        panelButtons.add(newPanel());
        panelButtons.add(mainPanel());

    }

    private Box newPanel() {
        Box newpanel = Box.createHorizontalBox();
        newpanel.add(PanelTrig);
        newpanel.add(Box.createHorizontalGlue());
        return newpanel;
    }

    private void addButton(JPanel panel, String label, String listener) {
        PanelNumberofButton button = new PanelNumberofButton(label);
        switch (listener) {
            case PanelButtons.INSERT -> button.getButton().addActionListener(new Insert(button.getButton(), panelScreen));
            case PanelButtons.COMMAND -> button.getButton().addActionListener(new Command(button.getButton(), panelScreen, tree));
        }
        panel.add(button.getButton());
    }

    public Box getPanel() {
        return panelButtons;
    }

    public JPanel mainPanel() {
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new GridLayout(5, 5, 3, 3));
        mainpanel.setBackground(new Color(0x000000));
        addButton(mainpanel, "DEL", PanelButtons.COMMAND);
        addButton(mainpanel, "C", PanelButtons.COMMAND);
        addButton(mainpanel, "(", PanelButtons.INSERT);
        addButton(mainpanel, ")", PanelButtons.INSERT);
        addButton(mainpanel, "sqrt", PanelButtons.COMMAND);

        addButton(mainpanel, "7", PanelButtons.INSERT);
        addButton(mainpanel, "8", PanelButtons.INSERT);
        addButton(mainpanel, "9", PanelButtons.INSERT);
        addButton(mainpanel, "*", PanelButtons.INSERT);
        addButton(mainpanel, "/", PanelButtons.INSERT);

        addButton(mainpanel, "4", PanelButtons.INSERT);
        addButton(mainpanel, "5", PanelButtons.INSERT);
        addButton(mainpanel, "6", PanelButtons.INSERT);
        addButton(mainpanel, "+", PanelButtons.COMMAND);
        addButton(mainpanel, "-", PanelButtons.COMMAND);

        addButton(mainpanel, "1", PanelButtons.INSERT);
        addButton(mainpanel, "2", PanelButtons.INSERT);
        addButton(mainpanel, "3", PanelButtons.INSERT);
        addButton(mainpanel, "%", PanelButtons.COMMAND);
        addButton(mainpanel, "1/x", PanelButtons.COMMAND);

        addButton(mainpanel, "0", PanelButtons.INSERT);
        addButton(mainpanel, ".", PanelButtons.INSERT);
        addButton(mainpanel, "=", PanelButtons.COMMAND);

        mainpanel.setSize(new Dimension(500, 500));
        mainpanel.setMinimumSize(new Dimension(500, 500));

        return mainpanel;
    }

    public JPanel panelTrig() {
        JPanel paneltrig = new JPanel();
        paneltrig.setLayout(new GridLayout(5, 2, 3, 3));

        addButton(paneltrig, "sin", PanelButtons.COMMAND);
        addButton(paneltrig, "cos", PanelButtons.COMMAND);
        addButton(paneltrig, "tan", PanelButtons.COMMAND);

        addButton(paneltrig, "sinh", PanelButtons.COMMAND);
        addButton(paneltrig, "cosh", PanelButtons.COMMAND);
        addButton(paneltrig, "tanh", PanelButtons.COMMAND);

        paneltrig.setSize(new Dimension(100, 500));
        paneltrig.setMinimumSize(new Dimension(100, 500));

        return paneltrig;
    }

}
