package com.company.View;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.LinkedList;

public class Tree {
    private final JTree tree;
    private final DefaultMutableTreeNode root;
    private final LinkedList<String> operationnames;

    public Tree() {
        operationnames = new LinkedList<>();

        root = new DefaultMutableTreeNode("result");
        tree = new JTree(root);

        tree.setMinimumSize(new Dimension(300, 600));
    }


    public DefaultMutableTreeNode getRoot() {
        return root;
    }

    public JTree getTree() {
        return tree;
    }

    public LinkedList<String> getOperationnames(){
        return operationnames;
    }

    public void update() {
        tree.validate();
        tree.updateUI();
    }


}
