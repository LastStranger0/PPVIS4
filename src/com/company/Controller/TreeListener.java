package com.company.Controller;

import com.company.View.Calculator.PanelScreen;
import com.company.View.Tree;

import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.util.LinkedList;

public class  TreeListener implements TreeExpansionListener {

    private Tree tree;
    private PanelScreen panelScreen;
    LinkedList<String> min;
    LinkedList<String> div;
    LinkedList<String> mod;
    private int index;

    public final static String SECOND = "second";
    public final static String FIRST = "first";

    public TreeListener(Tree tree, PanelScreen panelScreen) {
        this.tree = tree;
        this.panelScreen = panelScreen;

        min = new LinkedList<>();
        div = new LinkedList<>();
        mod = new LinkedList<>();

        index = 0;
    }

    @Override
    public void treeCollapsed(TreeExpansionEvent treeExpansionEvent) {
        TreePath path = treeExpansionEvent.getPath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
        if (node.getChildCount() == 1) {
            DefaultMutableTreeNode firstOperand = node.getNextNode();
            if (node.getUserObject().toString().equals("1/x")) {
                node.setUserObject(String.valueOf(1 / Double.parseDouble(firstOperand.toString())));
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("sqrt")) {
                node.setUserObject(String.valueOf(Math.sqrt(Double.parseDouble(firstOperand.toString()))));
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("sin")) {
                node.setUserObject(String.valueOf(Math.sin(Double.parseDouble(firstOperand.toString()))));
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("cos")) {
                node.setUserObject(String.valueOf(Math.cos(Double.parseDouble(firstOperand.toString()))));
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("tan")) {
                node.setUserObject(String.valueOf(Math.tan(Double.parseDouble(firstOperand.toString()))));
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("sinh")) {
                node.setUserObject(String.valueOf(Math.sinh(Double.parseDouble(firstOperand.toString()))));
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("cosh")) {
                node.setUserObject(String.valueOf(Math.cosh(Double.parseDouble(firstOperand.toString()))));
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("tanh")) {
                node.setUserObject(String.valueOf(Math.tanh(Double.parseDouble(firstOperand.toString()))));
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            }

        } else {
            DefaultMutableTreeNode firstOperand = node.getNextNode();
            DefaultMutableTreeNode secondOperand = firstOperand.getNextSibling();

            if (node.getUserObject().toString().equals("+")) {
                node.setUserObject(Double.parseDouble(firstOperand.toString()) + Double.parseDouble(secondOperand.toString()));
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("+")) {
                node.setUserObject(Double.parseDouble(firstOperand.toString()) + Double.parseDouble(secondOperand.toString()));
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("-") && min.getLast() == TreeListener.FIRST) {
                node.setUserObject(Double.parseDouble(firstOperand.toString()) - Double.parseDouble(secondOperand.toString()));
                min.removeLast();
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("-") && min.getLast() == TreeListener.SECOND) {
                node.setUserObject(Double.parseDouble(secondOperand.toString()) - Double.parseDouble(firstOperand.toString()));
                min.removeLast();
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("/") && div.getLast() == TreeListener.FIRST) {
                node.setUserObject(Double.parseDouble(firstOperand.toString()) / Double.parseDouble(secondOperand.toString()));
                div.removeLast();
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("/") && div.getLast() == TreeListener.SECOND) {
                node.setUserObject(Double.parseDouble(secondOperand.toString()) / Double.parseDouble(firstOperand.toString()));
                div.removeLast();
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("*")) {
                node.setUserObject((Double.parseDouble(secondOperand.toString()) * Double.parseDouble(firstOperand.toString())));
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("%") && mod.getLast() == TreeListener.FIRST) {
                node.setUserObject(Double.parseDouble(firstOperand.toString()) % Double.parseDouble(secondOperand.toString()));
                mod.removeLast();
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            } else if (node.getUserObject().toString().equals("%") && mod.getLast() == TreeListener.SECOND) {
                node.setUserObject(Double.parseDouble(secondOperand.toString()) % Double.parseDouble(firstOperand.toString()));
                mod.removeLast();
                index++;
                panelScreen.getScreen().setText(tree.getOperationnames().get(index));
            }
        }

    }

    @Override
    public void treeExpanded(TreeExpansionEvent treeExpansionEvent) {
        if (index == 0)
            index = tree.getOperationnames().size() - 1;
        TreePath path = treeExpansionEvent.getPath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
        if (path.getPathCount() != 1) {
            if (node.getChildCount() == 1) {
                DefaultMutableTreeNode firstOperand = node.getNextNode();
                if ((1 / Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("1/x");
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Math.sqrt(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("sqrt");
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Math.sin(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("sin");
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Math.cos(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("cos");
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Math.tan(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("tan");
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Math.sinh(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("sinh");
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Math.cosh(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("cosh");
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Math.tanh(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("tanh");
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                }
            } else {
                DefaultMutableTreeNode firstOperand = node.getNextNode();
                DefaultMutableTreeNode secondOperand = firstOperand.getNextSibling();

                if (Double.parseDouble(firstOperand.toString()) + Double.parseDouble(secondOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("+");
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Double.parseDouble(firstOperand.toString()) * Double.parseDouble(secondOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("*");
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Double.parseDouble(firstOperand.toString()) % Double.parseDouble(secondOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("%");
                    mod.add(TreeListener.FIRST);
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Double.parseDouble(secondOperand.toString()) % Double.parseDouble(firstOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("%");
                    mod.add(TreeListener.SECOND);
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Double.parseDouble(secondOperand.toString()) - Double.parseDouble(firstOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("-");
                    min.add(TreeListener.SECOND);
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Double.parseDouble(firstOperand.toString()) - Double.parseDouble(secondOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("-");
                    min.add(TreeListener.FIRST);
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Double.parseDouble(firstOperand.toString()) / Double.parseDouble(secondOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("/");
                    div.add(TreeListener.FIRST);
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                } else if (Double.parseDouble(secondOperand.toString()) / Double.parseDouble(firstOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("/");
                    div.add(TreeListener.SECOND);
                    index--;
                    panelScreen.getScreen().setText(tree.getOperationnames().get(index));
                }
            }
        }

    }
}
