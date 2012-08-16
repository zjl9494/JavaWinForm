package com.bitter;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;

public class MyTableTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyTable table;
	public MyTableTest() {
		
		table = new MyTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.PINK);
		getContentPane().add(table, BorderLayout.CENTER);
	}

}
