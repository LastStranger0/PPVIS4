package com.company.Controller;

import com.company.View.Calculator.*;
import com.company.View.Tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Command implements ActionListener {
    static BackPolish backPolish;

    JButton button;
    PanelScreen screen;
    Tree tree;
    String value;
    String prevText;
    DefaultMutableTreeNode child;
    DefaultMutableTreeNode parent;

    private static final Logger log = Logger.getLogger(Command.class.getName());

    public Command(JButton button, PanelScreen screen, Tree tree) {
        this.button = button;
        this.screen = screen;
        this.tree = tree;

        backPolish = new BackPolish(tree);
    }

    public void actionPerformed(ActionEvent event) {

        String input = event.getActionCommand();
        switch (button.getText()) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                screen.getScreen().setText(screen.getScreen().getText() + input);
                break;
            case "sin":
            case "cos":
            case "tan":
            case "sinh":
            case "cosh":
            case "tanh":
                screen.getScreen().setText(screen.getScreen().getText() + input + "(");
                break;
            case "=":
                try {
                    if (tree.getOperationnames().size() != 0) {
                        tree.getOperationnames().removeLast();
                        if (!tree.getOperationnames().getLast().equals(screen.getScreen().getText()))
                            tree.getOperationnames().add(screen.getScreen().getText());
                    } else
                        tree.getOperationnames().add(screen.getScreen().getText());

                    screen.getScreen().setText(String.valueOf(backPolish.parsing(screen.getScreen().getText())));
                    tree.update();
                } catch (NumberFormatException e) {
                    log.log(Level.INFO, "parseException", e);
                } catch (IndexOutOfBoundsException e) {
                    log.log(Level.INFO, "memException", e);
                } catch (NoSuchElementException e) {
                    log.log(Level.INFO, "zeroException", e);
                }
                break;
            case "C":
                screen.getScreen().setText("");
                tree.getRoot().removeAllChildren();
                tree.getRoot().setUserObject("=");
                tree.update();
                backPolish = new BackPolish(tree);
                while (tree.getOperationnames().size() != 0)
                    tree.getOperationnames().removeLast();
                break;
            case "DEL":
                try {
                    if (!screen.getScreen().getText().equals("")) {
                        value = screen.getScreen().getText().substring(0, screen.getScreen().getText().length() - 1);
                        screen.getScreen().setText(value);
                        tree.getRoot().setUserObject(value);
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    log.log(Level.INFO, "nullPointException", e);
                }
                break;
            case "sqrt":
                prevText = screen.getScreen().getText();
                value = String.valueOf(Math.sqrt(Double.parseDouble(screen.getScreen().getText())));
                screen.getScreen().setText(value);
                tree.getRoot().setUserObject(value);
                if (tree.getRoot().getChildCount() == 0)
                    child = new DefaultMutableTreeNode(prevText);
                else {
                    child = tree.getRoot().getNextNode();
                }
                parent = new DefaultMutableTreeNode(value);
                parent.add(child);
                tree.getRoot().removeAllChildren();
                tree.getRoot().add(parent);
                tree.update();
                break;
            case "1/x":
                try {
                    prevText = screen.getScreen().getText();
                    value = String.valueOf(1 / Double.parseDouble(screen.getScreen().getText()));
                    screen.getScreen().setText(value);
                    tree.getRoot().setUserObject(value);
                    if (tree.getRoot().getChildCount() == 0)
                        child = new DefaultMutableTreeNode(prevText);
                    else {
                        child = tree.getRoot().getNextNode();
                    }
                    parent = new DefaultMutableTreeNode(value);
                    parent.add(child);
                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);
                    tree.update();

                } catch (NumberFormatException e) {
                    log.log(Level.INFO, "parseException", e);
                }
                break;
        }
    }
}

