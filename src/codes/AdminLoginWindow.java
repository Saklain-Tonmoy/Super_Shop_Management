package codes;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AdminLoginWindow implements ActionListener {
	
	private JFrame window;
	private JPanel panel;
	private JPanel lowerPanel;
	private JPanel btnPanel;
	private JButton login;
	private JButton cancel;
	private JButton switchAdmin;
	private JTextField userText;
	private JPasswordField passText;
	private ImageIcon icon;
	private ImageIcon icon1;
	
	public AdminLoginWindow() {
		window = new JFrame();
		panel = new JPanel(new GridLayout(2,2,40,10));
		
		icon = new ImageIcon("images\\cancel007.png");
		icon1 = new ImageIcon("images\\login1.png");
		lowerPanel = new JPanel(new GridLayout(1,1));
		btnPanel = new JPanel(new GridLayout(1,2,60,10));
		login = new JButton("Login");
		cancel = new JButton("Cancel");
		switchAdmin = new JButton(new ImageIcon("images\\new.png"));
		userText = new JTextField();
		passText = new JPasswordField();
	}
	
	public void showWindow() {
		
		layoutSetting();
		
		window.setSize(800, 600);
		window.setTitle("AdminWindow");
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setVisible(true);
	}
	
	public void layoutSetting() {
		
		panel.add(new JLabel("Username"));
		panel.add(userText);
		panel.add(new JLabel("Password"));
		panel.add(passText);
		panel.setBounds(200, 280, 400, 90);
		window.add(panel);
		
		JPanel panel_2 = new JPanel(new GridLayout(1,0));
		JLabel message = new JLabel("Welcome to Administrator Login");
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 28);
		message.setFont(font);
		message.setForeground(Color.BLUE);
		panel_2.add(new JLabel(new ImageIcon("images\\admin.png")));
		panel_2.add(message);
		panel_2.setBounds(-40, 30, 800, 250);
		window.add(panel_2);
		
		cancel.add(new JLabel(icon));
		login.add(new JLabel(icon1));
		btnPanel.add(cancel);
		btnPanel.add(login);
		btnPanel.setBounds(200, 390, 400, 50);
		window.add(btnPanel);
		
		lowerPanel.setBounds(670, 490, 100,60 );
		lowerPanel.add(switchAdmin);
		window.add(lowerPanel);
		
		
		switchAdmin.addActionListener(this);
		login.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			File file = new File("Admin Data\\admin data.txt");
			try {
				Scanner scan = new Scanner(file);
				while(scan.hasNextLine()) {
					String name = scan.nextLine();
					String password = scan.nextLine();
					
					if(name.equals(userText.getText()) && password.equals(passText.getText())) {
						
						window.dispose();
						
						AdminWindow a = new AdminWindow();
						a.showWindow();
						
						break;
					}
					
					else {
						userText.setText("Wrong Username or Password");
						passText.setText(null);
					}
				}
				scan.close();
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		if(e.getSource() == switchAdmin) {
			SwitchAdminWindow s = new SwitchAdminWindow();
			s.showWindow();
		}
		
		if(e.getSource() == cancel) {
			window.dispose();
			LoginWindow loginWindow = new LoginWindow();
			loginWindow.showWindow();
		}
	}
	
}
