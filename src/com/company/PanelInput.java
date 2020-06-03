package com.company;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class PanelInput extends JPanel {
    private static JTextField Input;
    private String inputData;

    PanelInput(){
        setSize(new Dimension(500, 100));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        //JScrollPane scrollPane = new JScrollPane(input, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        Input = new JTextField("");
        Input.setMaximumSize(new Dimension(500, 100));
        Input.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "input panel"), BorderFactory.createEmptyBorder(10, 30, 10, 30)));
        add(Input);

        //add(scrollPane);
    }

    public String getInputData() {
        inputData = Input.getText();
        return inputData;
    }

    public void add(String text){
        inputData+=text;
        Input.setText(inputData);
    }

    public void clear(){
        inputData="";
        Input.setText(inputData);
    }

}
