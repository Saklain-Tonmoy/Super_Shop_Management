package codes;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class SwitchAdminWindow implements ActionListener {
	
	private JFrame window;
	private JButton submit;
	private JButton cancel;
	private JTextField userText;
	private JPasswordField passText;
	private JTextField oldUserText;
	private JPasswordField oldPassText;
	
	public SwitchAdminWindow() {
		window = new JFrame();
		submit = new JButton(new ImageIcon("images\\submit.png"));
		cancel = new JButton(new ImageIcon("images\\cancel007.png"));
		userText = new JTextField();
		passText = new JPasswordField();
		oldPassText = new JPasswordField();
		oldUserText = new JTextField();
	}
	
	public void showWindow() {
		
		layoutSetting();
		
		window.setSize(800, 600);
		window.setTitle("Switch Admin Window");
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setVisible(true);
	}
	
	public void layoutSetting() {
		
		JPanel panel_1  = new JPanel(new GridLayout(1,4,10,10));
		panel_1.add(new JLabel(new ImageIcon("images\\switchAdmin.png")));
		JLabel message = new JLabel("Switch Admin");
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 30);
		message.setFont(font);
		message.setForeground(Color.BLUE);
		panel_1.add(message);
		panel_1.setBounds(60, 60, 600, 180);
		window.add(panel_1);
		
		JPanel panel = new JPanel(new GridLayout(4,2,80,10));
		panel.add(new JLabel("Old Username"));
		panel.add(oldUserText);
		panel.add(new JLabel("Old Password"));
		panel.add(oldPassText);
		panel.add(new JLabel("New Username"));
		panel.add(userText);
		panel.add(new JLabel("New Password"));
		panel.add(passText);
		panel.setBounds(170, 270, 430, 160);
		window.add(panel);
		
		JPanel panel_2 = new JPanel(new GridLayout(1,2,60,40));
		panel_2.add(cancel);
		panel_2.add(submit);
		panel_2.setBounds(240, 450, 300, 50);
		window.add(panel_2);
		
		submit.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit) {
			File file = new File("Admin Data\\admin data.txt");
			try {
				Scanner scan = new Scanner(file);
				while(scan.hasNextLine()) {
					String name = scan.nextLine();
					String password = scan.nextLine();
					
					if(name.equals(oldUserText.getText()) && password.equals(oldPassText.getText()) && userText.getText().length() > 0 && passText.getText().length() > 0) {
						
						try{
							FileWriter fw = new FileWriter(file,false);
							String data = userText.getText() + "\n" + passText.getText() + "\n";
							fw.write(data);
							fw.close();
						} catch(Exception ex) {
							ex.getMessage();
						}
						window.dispose();
						
						break;
					}
					
					else {
						oldUserText.setText("Wrong Username or Password");
						oldPassText.setText("");
					}
				}
				
				scan.close();
				
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		if(e.getSource() == cancel) {
			window.dispose();
		}
	}
	
}
