package com.company;

import com.company.View.MainFrame;

public class Main {
    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel(new GTKLookAndFeel());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        MainFrame mainFrame = new MainFrame();
    }
}

