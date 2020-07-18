package codes;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AdminWindow implements ActionListener {
	
	private JFrame window;
	
	private JPanel upperPanel;
	private JPanel lowerPanel;
	
	private JButton productButton;
	private JButton managerButton;
	private JButton employeeButton;
	private JButton sellingHistory;
	private JButton logout;
	
	public AdminWindow(){
		
		window = new JFrame();
		
		upperPanel = new JPanel(new GridLayout(1,2));
		lowerPanel = new JPanel(new GridLayout(5,1,10,10));
		
		productButton = new JButton("About Product");
		managerButton = new JButton("About Manager");
		employeeButton = new JButton("About Employee");
		sellingHistory = new JButton("Sales History");
		logout = new JButton("Logout");
		
	}
	
	public void showWindow(){
		layoutSetting();
		window.setSize(800, 600);
		window.setTitle("Admin Window");
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setVisible(true);
		
	}
	
	public void layoutSetting(){
		
		upperPanel.add(new JLabel(new ImageIcon("images//AdminEditor.png")));
		JLabel message = new JLabel("Welcome!!!");
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 30);
		message.setFont(font);
		message.setForeground(Color.BLUE);
		upperPanel.add(message);
		
		upperPanel.setBounds(150,20,500,260);
		window.add(upperPanel);
		
		
		sellingHistory.add(new JLabel(new ImageIcon("images//sales1.png")));
		logout.add(new JLabel(new ImageIcon("images//logout.png")));
		employeeButton.add(new JLabel(new ImageIcon("images//employee2.png")));
		productButton.add(new JLabel(new ImageIcon("images//info.png")));
		managerButton.add(new JLabel(new ImageIcon("images/info007.png")));
		lowerPanel.add(productButton);
		lowerPanel.add(managerButton);
		lowerPanel.add(employeeButton);
		lowerPanel.add(sellingHistory);
		lowerPanel.add(logout);
		
		lowerPanel.setBounds(300,280,200,240);
		lowerPanel.setFocusable(true);
		window.add(lowerPanel);
		
		productButton.addActionListener(this);
		managerButton.addActionListener(this);
		employeeButton.addActionListener(this);
		sellingHistory.addActionListener(this);
		logout.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==productButton){
			window.dispose();
			AdminProductWindow a = new AdminProductWindow();
			a.showWindow();
		}
		
		else if(e.getSource()==managerButton){
			window.dispose();
			ManagerEditor me = new ManagerEditor();
			me.showWindow();
		}
		else if(e.getSource()==employeeButton){
			window.dispose();
			EmployeeEditor a = new EmployeeEditor();
			a.showWindow();
		}
		else if(e.getSource() == sellingHistory) {
			SalesHistoryWindow sw = new SalesHistoryWindow();
			sw.showWindow();
		}
		else if (e.getSource()==logout){
			window.dispose();
			AdminLoginWindow login = new AdminLoginWindow();
			login.showWindow();
		}
	}
		
}
