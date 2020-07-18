package codes;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ManagerMainWindow implements ActionListener {
	
	private JFrame window;
	
	private JPanel upperPanel;
	private JPanel lowerPanel;
	
	private JButton productButton;
	private JButton employeeButton;
	private JButton sellingHistory;
	private JButton logout;
	
	public ManagerMainWindow(){
		
		window = new JFrame();
		
		upperPanel = new JPanel(new GridLayout(1,2));
		lowerPanel = new JPanel(new GridLayout(5,1,10,10));
		
		productButton = new JButton("About Product");
		employeeButton = new JButton("About Employee");
		sellingHistory = new JButton("Sales History");
		logout = new JButton("Logout");
		
	}
	
	public void showWindow(){
		layoutSetting();
		window.setSize(800, 600);
		window.setTitle("Manager Main Window");
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setVisible(true);
		
	}
	
	public void layoutSetting(){
		
		upperPanel.add(new JLabel(new ImageIcon("images\\man.png")));
		JLabel message = new JLabel("Welcome!!!");
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 30);
		message.setFont(font);
		message.setForeground(Color.BLUE);
		upperPanel.add(message);
		
		upperPanel.setBounds(80,40,600,260);
		window.add(upperPanel);
		
		
		sellingHistory.add(new JLabel(new ImageIcon("images//sales1.png")));
		logout.add(new JLabel(new ImageIcon("images//logout.png")));
		employeeButton.add(new JLabel(new ImageIcon("images//employee2.png")));
		productButton.add(new JLabel(new ImageIcon("images//info.png")));
		lowerPanel.add(productButton);
		lowerPanel.add(employeeButton);
		lowerPanel.add(sellingHistory);
		lowerPanel.add(logout);
		
		lowerPanel.setBounds(300,300,200,240);
		lowerPanel.setFocusable(true);
		window.add(lowerPanel);
		
		productButton.addActionListener(this);
		employeeButton.addActionListener(this);
		sellingHistory.addActionListener(this);
		logout.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==productButton){
			window.dispose();
			ManagerProductWindow a = new ManagerProductWindow();
			a.showWindow();
		}
		
		else if(e.getSource()==employeeButton){
			window.dispose();
			EmployeeEditByManager a = new EmployeeEditByManager();
			a.showWindow();
		}
		
		else if(e.getSource() == sellingHistory) {
			SalesHistoryWindow shw = new SalesHistoryWindow();
			shw.showWindow();
		}
		else if (e.getSource()==logout){
			window.dispose();
			ManagerLoginWindow mw = new ManagerLoginWindow();
			mw.showWindow();
		}
		
	}
	
}
