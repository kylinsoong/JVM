package com.kylin.test.swing.tree;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class SelectableTree extends JFrame implements TreeSelectionListener {

	private static final long serialVersionUID = -7786818292413457574L;

	public static void main(String[] args) {
		new SelectableTree();
	}
	
	public SelectableTree(){
	
		super("JTree Selections");
		Container content = getContentPane();
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode child;
		DefaultMutableTreeNode grandChild;
		
		for (int i = 1; i < 4; i++) {
			child = new DefaultMutableTreeNode("Child " + i);
			root.add(child);
			for (int j = 1; j < 4; j++) {
				grandChild = new DefaultMutableTreeNode("Grandchild " + i + "." + j);
				child.add(grandChild);
			}
		}
		
		tree = new JTree(root);
	    tree.addTreeSelectionListener(this);
	    
	    DefaultTreeCellRenderer render = new DefaultTreeCellRenderer();
	    render.setClosedIcon(closedIcon);
	    render.setOpenIcon(openedIcon);
	    render.setLeafIcon(leafIcon);
	    tree.setCellRenderer(render);
	    
	    content.add(new JScrollPane(tree), BorderLayout.CENTER);
	    currentSelectionField = new JTextField("Current Selection: NONE");
	    content.add(currentSelectionField, BorderLayout.SOUTH);
	    setSize(300, 350);
	    setVisible(true);
	}
	
	private Icon closedIcon = new ImageIcon("img/close.gif");
	private Icon openedIcon = new ImageIcon("img/close.gif");
	private Icon leafIcon = new ImageIcon("img/leaf.gif");

	private JTree tree;
	private JTextField currentSelectionField;

	public void valueChanged(TreeSelectionEvent e) {
		try {
			currentSelectionField.setText ("Current Selection: " + tree.getLastSelectedPathComponent().toString());
		} catch (Exception ex) {
		}
	}

}
