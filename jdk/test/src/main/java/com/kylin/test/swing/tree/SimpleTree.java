package com.kylin.test.swing.tree;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class SimpleTree extends JFrame {

	private static final long serialVersionUID = -2230115795380955394L;

	public static void main(String[] args) {
		new SimpleTree();
	}
	
	public SimpleTree() {
		super("Creating a Simple JTree");		
		
		Container content = getContentPane();
		
		Object[] hierarchy =
		      { "javax.swing",
		        "javax.swing.border",
		        "javax.swing.colorchooser",
		        "javax.swing.event",
		        "javax.swing.filechooser",
		        new Object[] { "javax.swing.plaf",
		                       "javax.swing.plaf.basic",
		                       "javax.swing.plaf.metal",
		                       "javax.swing.plaf.multi" },
		        "javax.swing.table",
		        new Object[] { "javax.swing.text",
		                       new Object[] { "javax.swing.text.html",
		                                      "javax.swing.text.html.parser" },
		                       "javax.swing.text.rtf" },
		        "javax.swing.tree",
		        "javax.swing.undo" };
		
		DefaultMutableTreeNode root = processHierarchy(hierarchy);
		JTree tree = new JTree(root);
	    content.add(new JScrollPane(tree), BorderLayout.CENTER);
	    setSize(300, 350);
	    setVisible(true);
	}

	private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
		
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(hierarchy[0]);
		DefaultMutableTreeNode child;
		for (int i = 1; i < hierarchy.length; i++) {
			Object nodeSpecifier = hierarchy[i];
			if (nodeSpecifier instanceof Object[]) // Ie node with children
				child = processHierarchy((Object[]) nodeSpecifier);
			else
				child = new DefaultMutableTreeNode(nodeSpecifier); // Ie Leaf
			node.add(child);
		}
		return(node);
	}

}
