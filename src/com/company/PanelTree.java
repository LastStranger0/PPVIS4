package com.company;

import javax.swing.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.math.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

public class PanelTree extends JPanel{
    private JTree tree;
    private List<String> treename;
    JScrollPane scrollPane;
    PanelTree(){
        setSize(new Dimension(300, 500));
        treename = new ArrayList<>();
        treename.add("");
        setTree(treename);
        add(scrollPane);
    }

    void setTree(List<String> prim){
        if(prim.size() == 0){
            return;
        }
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        List<DefaultMutableTreeNode> allnodes = new ArrayList<DefaultMutableTreeNode>();
        DefaultMutableTreeNode nodel = new DefaultMutableTreeNode();
        DefaultMutableTreeNode noder = new DefaultMutableTreeNode();
        boolean is_first = true;
        for(String x : prim){
            DefaultMutableTreeNode tmp = new DefaultMutableTreeNode(x);
            allnodes.add(tmp);
        }
        for(int i = 0; i < allnodes.size(); i++) {
            DefaultMutableTreeNode tmp = allnodes.get(i);
            if (prim.get(i).equals("+") || prim.get(i).equals("-") || prim.get(i).equals("*") || prim.get(i).equals("/") || prim.get(i).equals("sqrt") || prim.get(i).equals("√") || prim.get(i).equals("sin") || prim.get(i).equals("cos") || prim.get(i).equals("tan") || prim.get(i).equals("ctg")) {
                if (is_first) {
                    root.setUserObject(tmp.getUserObject());
                    nodel = allnodes.get(i - 1);
                    noder = allnodes.get(i - 2);
                    allnodes = delete(allnodes, i - 1);
                    allnodes = delete(allnodes, i - 2);

                    prim = del(prim, i - 1);
                    prim = del(prim, i - 2);
                    i -= 2;
                    root.add(nodel);
                    root.add(noder);
                    is_first = false;
                } else {
                    nodel = allnodes.get(i - 1);
                    noder = allnodes.get(i - 2);
                    allnodes = delete(allnodes, i - 1);
                    allnodes = delete(allnodes, i - 2);

                    prim = del(prim, i - 1);
                    prim = del(prim, i - 2);
                    root = tmp;
                    root.add(nodel);
                    root.add(noder);
                    i -= 2;
                }
            }
        }
        tree = new JTree(root);
        tree.setRootVisible(true);
        scrollPane = new JScrollPane(tree,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tree.setSize(new Dimension(300, 500));
        scrollPane.setSize(new Dimension(300,500));
    }

    public List<DefaultMutableTreeNode> delete (List<DefaultMutableTreeNode> list, int num){
        List<DefaultMutableTreeNode> result = new ArrayList<DefaultMutableTreeNode>();
        for(int i = 0; i < list.size(); i++){
            if(i != num){
                result.add(list.get(i));
            }
        }
        return result;
    }

    public List<String> del (List<String> list, int num){
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++){
            if(i != num){
                result.add(list.get(i));
            }
        }
        return result;
    }

    public JTree getTree() {
        return tree;
    }

    public void setTreename(List<String> treename) {
        this.treename = treename;
    }
}
