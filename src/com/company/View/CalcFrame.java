package com.company.View;

import com.company.View.Calculator.*;

import javax.swing.*;

public class CalcFrame {
    private final Box calculator;
    PanelScreen screen;
    PanelButtons panelButtons;

    public CalcFrame(MainFrame mainFrame, Tree tree) {

        calculator = Box.createVerticalBox();
        screen = new PanelScreen();
        panelButtons =new PanelButtons(screen, mainFrame,tree);

        calculator.add(screen.getScreen());
        calculator.add(Box.createVerticalStrut(6));
        calculator.add(panelButtons.getPanel());

    }

    public Box getCalc() {
        return calculator;
    }

    public PanelScreen getScreen(){
        return screen;
    }
}
