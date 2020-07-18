package codes;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ManagerSignUpWindow implements ActionListener {
	
	private JFrame window;
	private JButton submit;
	private JButton cancel;
	private JTextField userText;
	private JPasswordField passText;
	
	public ManagerSignUpWindow() {
		window = new JFrame();
		submit = new JButton(new ImageIcon("images\\submitManager.png"));
		cancel = new JButton(new ImageIcon("images\\cancelManager.png"));
		userText = new JTextField();
		passText = new JPasswordField();
	}
	
	public void showWindow() {
		
		layoutSetting();
		
		window.setSize(400, 300);
		window.setTitle("Manager Sign Up");
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setVisible(true);
	}
	
	public void layoutSetting() {
		

		JPanel panel_1  = new JPanel(new GridLayout(1,2,10,10));
		panel_1.add(new JLabel(new ImageIcon("images\\managerAdd.png")));
		JLabel message = new JLabel("Manager Data");
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 15);
		message.setFont(font);
		message.setForeground(Color.BLUE);
		panel_1.add(message);
		panel_1.setBounds(60, 10, 200, 120);
		window.add(panel_1);
		
		JPanel panel = new JPanel(new GridLayout(2,2,20,10));
		panel.add(new JLabel("Username"));
		panel.add(userText);
		panel.add(new JLabel("Password"));
		panel.add(passText);
		panel.setBounds(80, 120, 220, 70);
		window.add(panel);
		
		JPanel panel_2 = new JPanel(new GridLayout(1,2,20,20));
		panel_2.add(cancel);
		panel_2.add(submit);
		panel_2.setBounds(90, 200, 200, 30);
		window.add(panel_2);
		
		submit.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit) {
			
			if(userText.getText().length() > 0 && passText.getText().length() > 0) {
				File file = new File("manager login data//manager login data.txt");
				try{
					FileWriter fw = new FileWriter(file,true);
					String data = userText.getText() + "\n" + passText.getText() + "\n";
					fw.write(data);
					fw.close();
				} catch(Exception ex) {
					ex.getMessage();
				}
				
				window.dispose();
			}
			
			else{
				userText.setText("Fill up all fields");
			}
		}
		
		if(e.getSource() == cancel) {
			window.dispose();
		}
	}
	
}
