package com.bitter;

import javax.swing.JTable;

public class MyTable extends JTable  {
	public MyTable() {
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Object DataSource;
	private String DataMember;
	private Boolean AllowUserToAddRows;
	private Boolean AllowUserToDeleteRows;
	private Boolean AllowUserToOrderColumns;
	private Boolean AllowUserToResizeColumns;
	private Boolean AllowUserToResizeRows;
	
}
