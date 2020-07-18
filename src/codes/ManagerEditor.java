package codes;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ManagerEditor implements ActionListener {
	
	private JFrame window;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_3;
	private JButton find;
	private JButton add;
	private JButton remove;
	private JButton cancel;
	private JButton clear;
	private JButton edit;
	
	private JButton list;
	
	private JTextField id;
	private JTextField title;
	private JTextField post;
	private JTextField salary;
	
	public EmployeeDatabase pd = new EmployeeDatabase("admin manager list\\admin manager list.txt");
	
	public ManagerEditor() {
	
		window = new JFrame();
		panel = new JPanel(new GridLayout(4,2,5,5));
		panel_1 = new JPanel(new GridLayout(2,3,40,10));
		panel_3 = new JPanel(new GridLayout(1,1,0,0));
		add = new JButton(new ImageIcon("images\\add1.png"));
		remove = new JButton(new ImageIcon("images\\remove1.png"));
		find = new JButton(new ImageIcon("images\\find.png"));
		clear = new JButton(new ImageIcon("images\\clear3.png"));
		edit = new JButton(new ImageIcon("images\\edit.png"));
		cancel = new JButton(new ImageIcon("images\\back.png"));
		
		list = new JButton (new ImageIcon("images\\list.png"));
		
		id = new JTextField();
		title = new JTextField();
		post = new JTextField();
		salary = new JTextField();
		
	}
	
	public void showWindow() {
		
		layoutSetting();
		
		window.setSize(800, 600);
		window.setTitle("Manager Editor");
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setVisible(true);
	}
	
	public void layoutSetting() {
		
		panel.add(new JLabel("Id"));
		panel.add(id);
		
		panel.add(new JLabel("Name"));
		panel.add(title);
		
		panel.add(new JLabel("Position"));
		panel.add(post);
		
		panel.add(new JLabel("Salary"));
		panel.add(salary);
		
		
		
		panel_1.add(add);
		panel_1.add(remove);
		panel_1.add(find);
		panel_1.add(clear);
		panel_1.add(cancel);
		panel_1.add(edit);
		
		panel.setBounds(200, 270, 400, 150);
		panel.setFocusable(true);
		window.add(panel);
		
		panel_1.setBounds(200, 440, 400, 100);
		window.add(panel_1);
		
		JPanel panel_2 = new JPanel(new GridLayout(1,0));
		JLabel message = new JLabel("Manager Editor");
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 40);
		message.setFont(font);
		message.setForeground(Color.BLUE);
		panel_2.add(new JLabel(new ImageIcon("images\\EditIcon.png")));
		panel_2.add(message);
		panel_2.setBounds(0, 20, 800, 260);
		window.add(panel_2);
		
		panel_3.add(list);	
		panel_3.setBounds(740, 13, 40, 40);
		window.add(panel_3);
		

		find.addActionListener(this);
		add.addActionListener(this);
		remove.addActionListener(this);
		clear.addActionListener(this);
		edit.addActionListener(this);
		cancel.addActionListener(this);
		list.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == find) {
			if(id.getText().length() > 0) {
				Employee found = pd.find(id.getText());
				if(found != null){
				
					id.setText(found.getId());
					title.setText(found.getName());
					post.setText(found.getPosition());
					salary.setText(found.getSalary() + "");
					
				}
				
				else {
					id.setText("Not Found");
				}
			}
			
			else if(title.getText().length() > 0) {
				Employee found = pd.find(title.getText());
				if(found != null){
				
					id.setText(found.getId());
					title.setText(found.getName());
					post.setText(found.getPosition());
					salary.setText(found.getSalary() + "");
					
				}
				
				else {
					title.setText("Not Found");
				}
			}
			
		}
		
		
		else if(e.getSource() == add) {
			
			try {
				if(id.getText().length() > 0 && title.getText().length() > 0 && post.getText().length() > 0 && salary.getText().length() > 0) {
					
					Employee a1 = new Employee(id.getText().toString(),title.getText().toString(),post.getText().toString(),Double.parseDouble(salary.getText().toString()));
					Employee p = (Employee) pd.findProductToAdd(a1.getId().toString(), title.getText().toString());
					if(p == null) {
						ManagerSignUpWindow m = new ManagerSignUpWindow();
						m.showWindow();
						
						pd.add(a1);
						pd.saveToFile();
						
						id.setText("");
						title.setText("");
						post.setText("");
						salary.setText("");
					}
						
					else {
						id.setText("Id already exist");
						title.setText("Title already exist");
						post.setText("");
						salary.setText("");
					}
					
				}
				
				else {
					id.setText("Fill Up All Fields");
				}
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}	
		}
		
		
		else if(e.getSource() == remove) {
				
			if(id.getText().length() > 0) {
				pd.remove(id.getText());
				pd.saveToFile();
				
				id.setText("");
				title.setText("");
				post.setText("");
				salary.setText("");
			}
			
			else if(title.getText().length() > 0) {
				pd.remove(title.getText());
				pd.saveToFile();
				
				id.setText("");
				title.setText("");
				post.setText("");
				salary.setText("");
			}
			
			else {
				id.setText("Error!!!");
			}
				
		}
		
		
		else if(e.getSource() == clear) {
			id.setText("");
			title.setText("");
			post.setText("");
			salary.setText("");
		}
		
		else if(e.getSource() == edit) {
			try {
				if(id.getText().length() > 0 && title.getText().length() > 0 && post.getText().length() > 0 && salary.getText().length() > 0) {
					
					Employee em = new Employee(id.getText(), title.getText(), post.getText(), Double.parseDouble(salary.getText()));
					pd.update(em);
					pd.saveToFile();
					
					id.setText("");
					title.setText("");
					post.setText("");
					salary.setText("");
						
				}
				
				else {
					id.setText("Fill up all Fields");
				}
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
		}
		
		else if(e.getSource() == cancel) {
			window.dispose();
			AdminWindow d = new AdminWindow();
			d.showWindow();
		}
		
		else if(e.getSource() == list) {
			window.dispose();
			ManagerList c = new ManagerList();
			c.showWindow();
		}
			
			
	}

}	
	
	
