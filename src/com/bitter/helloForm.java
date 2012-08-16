package com.bitter;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@SuppressWarnings("unused")
public class helloForm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
//		childForm _child = new childForm();
//		_child.setTitle("hello");
//		_child.setVisible(true);
//		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//		_child.setLocation((dim.width - _child.getWidth()) / 2,
//				(dim.height - _child.getHeight()) / 2);

		JTableDemo test = new JTableDemo();

		// MyFrame frame = new MyFrame();
		// // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setTitle("改变窗体的观感");
		// frame.setVisible(true);
	}

}

/*
 * @auto : bitter
 * 
 * @create date :
 */
@SuppressWarnings("serial")
class MyFrame extends JFrame {
	// public static int ScreenWidth;
	// public static int ScreenHeight;

	public MyFrame() {
		SetStatus();

		MyPanel panel = new MyPanel();
		add(panel);

		// 监听捕捉窗体事件
		WindowListener listener = new Terminator(MyFrame.this); // MyFrame.this
		addWindowListener(listener);
		// 监听窗体变化
		WindowStateListener stateListener = new StateChange(MyFrame.this); // MyFrame.this
		addWindowStateListener(stateListener);
	}

	public void SetStatus() {
		// GetScreenSize getScreenSize = new GetScreenSize();
		// ScreenWidth = getScreenSize.getScreenWidth();
		// ScreenHeight = getScreenSize.getScreenHeight();
		setSize(500, 200);
		setLocation(100, 100);

	}
}

@SuppressWarnings("serial")
class MyPanel extends JPanel {
	public MyPanel() {
		// 用getInstalledLookAndFeels获得已经安装在系统上的窗体样式的名字和类名，
		// 并利用它们创建3个按钮
		UIManager.LookAndFeelInfo[] infos = UIManager
				.getInstalledLookAndFeels();
		for (int i = 0; i < infos.length; i++) {
			makeButton(infos[i].getName(), infos[i].getClassName());
		}
	}

	void makeButton(String name, String className) {
		JButton myButton = new JButton(name);
		add(myButton);
		Action myAction = new Action(className, MyPanel.this); // MyPanel.this
		myButton.addActionListener(myAction);
	}
}

// 这里没有作为内部类，而是独立出来处理
class Action implements ActionListener {
	private String plaf;
	private JPanel myPanel;

	public Action(String className, JPanel myPanel) {
		plaf = className;
		this.myPanel = myPanel;
	}

	// 在Action类中实现继承自ActionListener类的抽象方法actionPerformed
	public void actionPerformed(ActionEvent event) {
		try {
			UIManager.setLookAndFeel(plaf);
			SwingUtilities.updateComponentTreeUI(myPanel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// 窗口适配器
class Terminator extends WindowAdapter {
	@SuppressWarnings("unused")
	private MyFrame myFrame;

	public Terminator(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	public void windowClosing(WindowEvent e) {
		int k = JOptionPane.showConfirmDialog(null, "hello，quit program?",
				"请确定", 1);
		while (k == 0) {
			System.exit(0);
		}
	}
}

// 监听窗体状态改变
class StateChange implements WindowStateListener {
	private MyFrame myFrame;

	public StateChange(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	public void windowStateChanged(WindowEvent e) {
		int k = e.getNewState();
		if ((k == Frame.MAXIMIZED_HORIZ) || (k == Frame.MAXIMIZED_VERT)
				|| (k == Frame.MAXIMIZED_BOTH) || (k == Frame.ICONIFIED)) {
			JOptionPane.showMessageDialog(null,
					"Sorry，but I will Change it Back!"); // 显示一个对话框
			myFrame.SetStatus();
		}
	}
}