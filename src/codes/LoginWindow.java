package codes;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class LoginWindow implements ActionListener {

	private JFrame window;
	private JButton admin;
	private JButton manager;
	private JButton employee;
	private JButton exit;
	private ImageIcon coverIcon;
	private ImageIcon coverIcon1;
	private ImageIcon icon;
	
	private JPanel btnpanel;
	private JPanel upperMiddle;
	private JPanel upperRight;
	private ImageIcon icon1;
	private ImageIcon icon2;
	private ImageIcon icon3;
	
	public LoginWindow() {
		window = new JFrame();
		window.setLayout(null);
		
		admin = new JButton("Administrator");
		manager = new JButton("Manager");
		employee = new JButton("Employee");
		exit = new JButton("Exit");
		coverIcon = new ImageIcon("images//middle.png");
		coverIcon1 = new ImageIcon("images//right side.png");
		icon = new ImageIcon("images//admin1.png");
		icon1 = new ImageIcon("images//employee icon.png");
		icon2 = new ImageIcon("images//manager icon.png");
		icon3 = new ImageIcon("images//exit.png");
		
		btnpanel = new JPanel();
	}
	
	public void showWindow() {
		
		panelSetting();
		
		window.setSize(800, 600);
		window.setTitle("LoginWindow");
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setVisible(true);
	}
	
	public void panelSetting() {
		
		btnpanel = new JPanel();
		btnpanel.setLayout(new GridLayout(2,2,80,10));
		admin.add(new JLabel(icon));
		employee.add(new JLabel(icon1));
		manager.add(new JLabel(icon2));
		exit.add(new JLabel(icon3));
		btnpanel.add(admin);
		btnpanel.add(manager);
		btnpanel.add(employee);
		btnpanel.add(exit);
		btnpanel.setBounds(170,350,450,130);
		btnpanel.setFocusable(true);
		window.add(btnpanel);
		
		upperRight = new JPanel(new GridLayout(1,0));
		upperRight.add(new JLabel(coverIcon1));
		upperRight.setBounds(550, 10, 210, 300);
		window.add(upperRight);
		
		upperMiddle = new JPanel(new GridLayout(1,0));
		upperMiddle.add(new JLabel(coverIcon));
		upperMiddle.setBounds(50,0,400,300);
		window.add(upperMiddle);
		
		admin.addActionListener(this);
		manager.addActionListener(this);
		employee.addActionListener(this);
		exit.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == admin) {
			window.dispose();
			AdminLoginWindow adminWindow = new AdminLoginWindow();
			adminWindow.showWindow();
		}
		
		else if(e.getSource() == manager) {
			window.dispose();
			ManagerLoginWindow managerWindow = new ManagerLoginWindow();
			managerWindow.showWindow();
		}
		
		else if(e.getSource() == employee) {
			window.dispose();
			TableWindow table = new TableWindow();
		}
		
		else if(e.getSource() == exit) {
			window.dispose();
			
		}
		
	}

}
