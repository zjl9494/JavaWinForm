package com.bitter;

import java.io.DataOutputStream;

import javax.swing.JFrame;

public class JTableDemo extends JFrame {
	int RowCount = 10;
	int ColumnCount = 3;
	Object[][] m_data = new Object[RowCount][ColumnCount];
	String[] m_columnName = { "ID", "NAME", "AGE" };
	DataOutputStream m_dos = null;

}
