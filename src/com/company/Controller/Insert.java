package com.company.Controller;

import com.company.View.Calculator.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Insert implements ActionListener {

    JButton button;
    PanelScreen screen;

    public Insert(JButton button, PanelScreen screen) {
        this.button = button;
        this.screen = screen;
    }

    public void actionPerformed(ActionEvent event) {

        String input = event.getActionCommand();
        screen.getScreen().setText(screen.getScreen().getText() + input);
    }
}
