package com.company.View.Calculator;

import javax.swing.*;
import java.awt.*;

public class PanelNumberofButton {
    JButton numberofButton;

    public PanelNumberofButton(String number) {
        numberofButton = new JButton(number);
        numberofButton.setSize(50,50);
        numberofButton.setPreferredSize(new Dimension(50,50));
    }
    public JButton getButton(){
        return numberofButton;
    }
}
