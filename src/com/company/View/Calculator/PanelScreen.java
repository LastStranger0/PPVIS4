package com.company.View.Calculator;

import javax.swing.*;
import java.awt.*;

public class PanelScreen {
    JTextField screen;

    public PanelScreen(){
        screen=new JTextField();
        screen.setEnabled(false);
        screen.setFont(new Font("Arial", Font.BOLD, 20));
        screen.setBackground(new Color(0x000000));
        screen.setPreferredSize(new Dimension(500,100));
        screen.setSize(500,100);
    }

    public JTextField getScreen(){
        return screen;
    }
}
