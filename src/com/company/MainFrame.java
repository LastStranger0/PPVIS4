package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    MainFrame(){
        super("Calculator");
        setSize(new Dimension(800, 600));
        JPanel main = new JPanel();
        JPanel northSide = new JPanel();
        JPanel southSide = new JPanel();
        PanelInput input = new PanelInput();
        InputClear clear = new InputClear(input);
        PanelTree tree = new PanelTree();
        PanelOutput output = new PanelOutput(clear, tree);
        PanelButtons buttons = new PanelButtons(input, output);

        northSide.setSize(new Dimension(800, 100));
        northSide.setLayout(new BoxLayout(northSide, BoxLayout.LINE_AXIS));
        southSide.setSize(new Dimension(800, 500));
        southSide.setLayout(new BoxLayout(southSide, BoxLayout.LINE_AXIS));
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setSize(new Dimension(800,600));

        northSide.add(input);
        northSide.add(output);

        southSide.add(buttons);
        southSide.add(tree);

        main.add(northSide);
        main.add(southSide);
        add(main);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
