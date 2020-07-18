package codes;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ManagerWindow implements ActionListener {
	
	private JFrame window;
	private JPanel panel;
	private JButton find;
	private JButton add;
	//private JButton remove;
	private JButton cancel;
	private JButton clear;
	//private JButton edit;
	private JTextField id;
	private JTextField title;
	private JTextField quantity;
	private JTextField price;
	
	public ProductDatabase pd = new ProductDatabase("Product\\product.txt");
	
	public ManagerWindow() {
	
		window = new JFrame();
		panel = new JPanel(new GridLayout(6,2,5,5));
		
		add = new JButton("add");
		//remove = new JButton("remove");
		find = new JButton("find");
		clear = new JButton("clear");
		//edit = new JButton("edit");
		cancel = new JButton("cancel");
		
		id = new JTextField();
		title = new JTextField();
		quantity = new JTextField();
		price = new JTextField();
		
	}
	
	public void showWindow() {
		
		layoutSetting();
		
		window.setSize(800, 600);
		window.setTitle("mr.manager");
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setVisible(true);
	}
	
	public void layoutSetting() {
		
		panel.add(new JLabel("id"));
		panel.add(id);
		
		panel.add(new JLabel("title"));
		panel.add(title);
		
		panel.add(new JLabel("quantity"));
		panel.add(quantity);
		
		panel.add(new JLabel("price"));
		panel.add(price);
		
		
		panel.add(add);
		//panel.add(remove);
		panel.add(find);
		panel.add(clear);
		panel.add(cancel);
	//	panel.add(edit);
		
		panel.setBounds(200, 290, 400, 250);
		panel.setFocusable(true);
		window.add(panel);
		
		JPanel panel_2 = new JPanel(new GridLayout(1,0));
		JLabel message = new JLabel("welcome mr.manager");
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 30);
		message.setFont(font);
		message.setForeground(Color.BLUE);
		panel_2.add(new JLabel(new ImageIcon("images\\EditIcon.png")));
		panel_2.add(message);
		panel_2.setBounds(0, 20, 800, 260);
		window.add(panel_2);
		
		

		find.addActionListener(this);
		add.addActionListener(this);
		//remove.addActionListener(this);
		clear.addActionListener(this);
		//edit.addActionListener(this);
		cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == find) {
			
			//ProductDatabase pw = new ProductDatabase(path);
			
			Product found = pd.find(id.getText());
			if(found != null){
			
				id.setText(found.getId());
				title.setText(found.getTitle());
				quantity.setText(found.getQuantity());
				price.setText(found.getPrice());
				
				System.out.println(found.getId()+"\n"+found.getPrice());
			}
			
		}
		
		
		else if(e.getSource() == add) {
			
			Product a = new Product(id.getText().toString(),title.getText().toString(),quantity.getText().toString(),price.getText().toString());
			
			System.out.println(id.getText()+title.getText()+quantity.getText()+price.getText());
			
			pd.add(a);
			
			pd.saveToFile();
		}
		
		
		
//		else if(e.getSource() == remove) {
//				
//			pd.remove(id.getText());
//			pd.saveToFile();
//			
//			id.setText("removed");
//			title.setText("removed");
//			quantity.setText("removed");
//			price.setText("removed");
//			
//			
//				
//	}
		
		
		else if(e.getSource() == clear) {
			id.setText("");
			title.setText("");
			quantity.setText("");
			price.setText("");
		}
		
//		else if(e.getSource() == edit) {
//			
//			Product found = pd.find(id.getText());
//				
//			}
		
		else if(e.getSource() == cancel) {
			window.dispose();
			//LoginWindow loginWindow = new LoginWindow();
			//l11oginWindow.showWindow();
		}
			
			
		}
		
		
//		else
//			id.setText("invalid");
//			title.setText("invalid");
//			quantity.setText("invalid");
//			price.setText("invalid");
	}	
	
	
