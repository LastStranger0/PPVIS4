package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelButtons extends JPanel{

    PanelButtons(PanelInput input, PanelOutput output){
        setSize(new Dimension(500, 500));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(firstpanel(input));
        add(secondpanel(input));
        add(thirdpanel(input));
        add(fourthpanel(input));
        add(fifthpanel(input, output));
    }

    private JPanel firstpanel(PanelInput input){
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.LINE_AXIS));

        Font font = new Font("Arial", Font.BOLD, 50);
        Font font1 = new Font("Arial", Font.BOLD, 40);

        JButton clear = new JButton("C");
        clear.setMaximumSize(new Dimension(100, 100));
        clear.setFont(font);
        clear.addActionListener(e -> input.clear());

        JButton openBracket = new JButton("(");
        openBracket.setMaximumSize(new Dimension(100,100));
        openBracket.setFont(font);
        openBracket.addActionListener(e -> input.add("("));

        JButton closeBracket = new JButton(")");
        closeBracket.setMaximumSize(new Dimension(100,100));
        closeBracket.setFont(font);
        closeBracket.addActionListener(e -> input.add(")"));

        JButton plus = new JButton("+");
        plus.setMaximumSize(new Dimension(100,100));
        plus.setFont(font);
        plus.addActionListener(e -> input.add("+"));

        JButton sin = new JButton("sin");
        sin.setMaximumSize(new Dimension(100,100));
        sin.setFont(font1);
        sin.addActionListener(e -> input.add("sin"));

        firstPanel.add(clear);
        firstPanel.add(openBracket);
        firstPanel.add(closeBracket);
        firstPanel.add(plus);
        firstPanel.add(sin);
        return firstPanel;
    }

    private JPanel secondpanel(PanelInput input){
        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.LINE_AXIS));

        Font font = new Font("Arial", Font.BOLD, 50);
        Font font1 = new Font("Arial", Font.BOLD, 38);

        JButton seven = new JButton("7");
        seven.setMaximumSize(new Dimension(100, 100));
        seven.setFont(font);
        seven.addActionListener(e -> input.add("7"));

        JButton eight = new JButton("8");
        eight.setMaximumSize(new Dimension(100,100));
        eight.setFont(font);
        eight.addActionListener(e -> input.add("8"));

        JButton nine = new JButton("9");
        nine.setMaximumSize(new Dimension(100,100));
        nine.setFont(font);
        nine.addActionListener(e -> input.add("9"));

        JButton minus = new JButton("-");
        minus.setMaximumSize(new Dimension(100,100));
        minus.setFont(font);
        minus.addActionListener(e -> input.add("-"));

        JButton cos = new JButton("cos");
        cos.setFont(font1);
        cos.setMaximumSize(new Dimension(100,100));
        cos.addActionListener(e -> input.add("cos"));

        secondPanel.add(seven);
        secondPanel.add(eight);
        secondPanel.add(nine);
        secondPanel.add(minus);
        secondPanel.add(cos);
        return secondPanel;
    }

    private JPanel thirdpanel(PanelInput input){
        JPanel thirdPanel = new JPanel();
        thirdPanel.setLayout(new BoxLayout(thirdPanel, BoxLayout.LINE_AXIS));

        Font font = new Font("Arial", Font.BOLD, 50);
        Font font1 = new Font("Arial", Font.BOLD, 40);

        JButton four = new JButton("4");
        four.setFont(font);
        four.setMaximumSize(new Dimension(100, 100));
        four.addActionListener(e -> input.add("4"));

        JButton five = new JButton("5");
        five.setFont(font);
        five.setMaximumSize(new Dimension(100,100));
        five.addActionListener(e -> input.add("5"));

        JButton six = new JButton("6");
        six.setFont(font);
        six.setMaximumSize(new Dimension(100,100));
        six.addActionListener(e -> input.add("6"));

        JButton multiply = new JButton("x");
        multiply.setFont(font);
        multiply.setMaximumSize(new Dimension(100,100));
        multiply.addActionListener(e -> input.add("*"));

        JButton tg = new JButton("tan");
        tg.setFont(font1);
        tg.setMaximumSize(new Dimension(100,100));
        tg.addActionListener(e -> input.add("tan"));

        thirdPanel.add(four);
        thirdPanel.add(five);
        thirdPanel.add(six);
        thirdPanel.add(multiply);
        thirdPanel.add(tg);
        return thirdPanel;
    }

    private JPanel fourthpanel(PanelInput input){
        JPanel fourthPanel = new JPanel();
        Font font = new Font("Arial", Font.BOLD, 50);
        Font font1 = new Font("Arial", Font.BOLD, 40);
        fourthPanel.setLayout(new BoxLayout(fourthPanel, BoxLayout.LINE_AXIS));

        JButton one = new JButton("1");
        one.setMaximumSize(new Dimension(100, 100));
        one.setFont(font);
        one.addActionListener(e -> input.add("1"));

        JButton two = new JButton("2");
        two.setMaximumSize(new Dimension(100,100));
        two.setFont(font);
        two.addActionListener(e -> input.add("2"));

        JButton three = new JButton("3");
        three.setMaximumSize(new Dimension(100,100));
        three.setFont(font);
        three.addActionListener(e -> input.add("3"));

        JButton del = new JButton("/");
        del.setMaximumSize(new Dimension(100,100));
        del.setFont(font);
        del.addActionListener(e -> input.add("/"));

        JButton ctg = new JButton("ctg");
        ctg.setMaximumSize(new Dimension(100,100));
        ctg.setFont(font1);
        ctg.addActionListener(e -> input.add("ctg"));

        fourthPanel.add(one);
        fourthPanel.add(two);
        fourthPanel.add(three);
        fourthPanel.add(del);
        fourthPanel.add(ctg);
        return fourthPanel;
    }

    private JPanel fifthpanel(PanelInput input, PanelOutput output){
        JPanel fifthPanel = new JPanel();
        Font font = new Font("Arial", Font.BOLD, 50);
        Font font1 = new Font("Arial", Font.BOLD, 38);
        fifthPanel.setLayout(new BoxLayout(fifthPanel, BoxLayout.LINE_AXIS));

        JButton xback = new JButton("1/x");
        xback.setMaximumSize(new Dimension(100, 100));
        xback.setFont(font1);
        xback.addActionListener(e -> input.add("1/"+output.getOutputData()));

        JButton zero = new JButton("0");
        zero.setMaximumSize(new Dimension(100,100));
        zero.setFont(font);
        zero.addActionListener(e -> input.add("0"));

        JButton dot = new JButton(".");
        dot.setMaximumSize(new Dimension(100,100));
        dot.setFont(font);
        dot.addActionListener(e -> input.add("."));

        JButton sqrt = new JButton("√");
        sqrt.setMaximumSize(new Dimension(100,100));
        sqrt.setFont(font);
        sqrt.addActionListener(e -> input.add("sqrt"));

        JButton equaly = new JButton("=");
        equaly.setMaximumSize(new Dimension(100,100));
        equaly.setFont(font);
        equaly.addActionListener(e -> output.calculate());

        fifthPanel.add(xback);
        fifthPanel.add(zero);
        fifthPanel.add(dot);
        fifthPanel.add(sqrt);
        fifthPanel.add(equaly);
        return fifthPanel;
    }
}
