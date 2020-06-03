package com.company;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PanelOutput extends JPanel {
    public static JTextField output;
    private String outputData;
    private String input;
    private double doubleData;
    private final InputClear q;
    private PanelTree tree;

    PanelOutput(InputClear in, PanelTree tree){
        setSize(new Dimension(300, 100));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.tree = tree;
        //JScrollPane scrollPane = new JScrollPane(output, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        input = in.getClearinput();
        q = in;
        output = new JTextField("");
        output.setMaximumSize(new Dimension(300, 100));
        output.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "output"), BorderFactory.createEmptyBorder(10, 30, 10, 30)));
        outputData = String.valueOf(doubleData);
        output.setText(outputData);
        add(output);
       // add(scrollPane);
    }

    public static Double calc(List<String> postfix) {
        Deque<Double> stack = new ArrayDeque<>();
        for (String x : postfix) {
            switch (x) {
                case "sqrt":
                case "√":
                    stack.push(Math.sqrt(stack.pop()));
                    break;
                case "cube":
                    Double tmp = stack.pop();
                    stack.push(tmp * tmp * tmp);
                    break;
                case "sin": {
                    Double tm = stack.pop();
                    stack.push(Math.sin(tm));
                    break;
                }
                case "cos": {
                    Double tm = stack.pop();
                    stack.push(Math.cos(tm));
                    break;
                }
                case "tan": {
                    Double tm = stack.pop();
                    stack.push(Math.tan(tm));
                    break;
                }
                case "ctg": {
                    Double tm = stack.pop();
                    stack.push(Math.tan(1 / tm));
                    break;
                }
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-": {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/": {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                case "u-":
                    stack.push(-stack.pop());
                    break;
                default:
                    stack.push(Double.valueOf(x));
                    break;
            }
        }
        return stack.pop();
    }

    public void setOutputData() {
        StringBuilder res = new StringBuilder();
        new BackPolish();
        List<String> expression = BackPolish.parse(input);
        boolean flag = BackPolish.flag;
        if (flag) {
            for (String x : expression) {
                if(res.length() == 0){
                res = new StringBuilder(x);
                } else {
                    res.append(x);
                }
                res.append(" ");
            }

            doubleData = calc(expression);
        }
    }

    public List<String> getExpression(){
        return BackPolish.parse(input);
    }

    public void updateClearInput(){
        input = q.getClearinput();
        setOutputData();
    }

    public void calculate(){
        updateClearInput();
        tree.setTreename(getExpression());
        tree.setTree(getExpression());
        output.setText(String.valueOf(doubleData));
    }

    public double getDoubleData() {
        return doubleData;
    }

    public String getOutputData() {
        outputData = output.getText();
        return outputData;
    }

    public static JTextField getOutput() {
        return output;
    }
}
