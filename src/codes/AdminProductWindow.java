package codes;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AdminProductWindow implements ActionListener {
	
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
	private JTextField quantity;
	private JTextField price;
	
	public ProductDatabase pd = new ProductDatabase("Product\\product.txt");
	
	public AdminProductWindow() {
	
		window = new JFrame();
		panel = new JPanel(new GridLayout(4,2,5,5));
		panel_1 = new JPanel(new GridLayout(2,3,30,10));
		panel_3 = new JPanel(new GridLayout(1,1,0,0));
		add = new JButton(new ImageIcon("images\\add.png"));
		remove = new JButton(new ImageIcon("images\\remove.png"));
		find = new JButton(new ImageIcon("images\\find.png"));
		clear = new JButton(new ImageIcon("images\\clear3.png"));
		edit = new JButton(new ImageIcon("images\\edit.png"));
		cancel = new JButton(new ImageIcon("images\\cancel.png"));
		
		list = new JButton (new ImageIcon("images\\products.png"));
		
		id = new JTextField();
		title = new JTextField();
		quantity = new JTextField();
		price = new JTextField();
		
	}
	
	public void showWindow() {
		
		layoutSetting();
		
		window.setSize(800, 600);
		window.setTitle("Product Edit");
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setVisible(true);
	}
	
	public void layoutSetting() {
		
		panel.add(new JLabel("Id"));
		panel.add(id);
		
		panel.add(new JLabel("Title"));
		panel.add(title);
		
		panel.add(new JLabel("Quantity"));
		panel.add(quantity);
		
		panel.add(new JLabel("Price"));
		panel.add(price);
		
		
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
		JLabel message = new JLabel("Product Editor");
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 30);
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
				Product found = pd.find(id.getText());
				if(found != null){
				
					id.setText(found.getId());
					title.setText(found.getTitle());
					quantity.setText(found.getQuantity());
					price.setText(found.getPrice());
					
				}
				
				else {
					id.setText("Not Found");
					title.setText("");
					quantity.setText("");
					price.setText("");
				}
			}
			
			else if(title.getText().length() > 0) {
				Product found = pd.find(title.getText());
				if(found != null){
				
					id.setText(found.getId());
					title.setText(found.getTitle());
					quantity.setText(found.getQuantity());
					price.setText(found.getPrice());
					
				}
				
				else {
					id.setText("");
					title.setText("Not Found");
					quantity.setText("");
					price.setText("");
				}
			}
			
		}
		
		
		else if(e.getSource() == add) {
			
			if(id.getText().length() > 0 && title.getText().length() > 0 && quantity.getText().length() > 0 && price.getText().length() > 0) {
				Product a1 = new Product(id.getText().toString(),title.getText().toString(),quantity.getText().toString(),price.getText().toString());
				Product p = (Product) pd.findProductToAdd(a1.getId().toString(), title.getText().toString());
				if(p == null) {
					pd.add(a1);
					pd.saveToFile();
					
					id.setText("");
					title.setText("");
					quantity.setText("");
					price.setText("");
				}
				
				else {
					id.setText("Id already exist");
					title.setText("Title already exist");
					quantity.setText("");
					price.setText("");
				}
			}
			
			else {
				id.setText("Fill Up All Fields");
				title.setText("");
				quantity.setText("");
				price.setText("");
			}
			
		}
		
		
		
		else if(e.getSource() == remove) {
				
			if(id.getText().length() > 0) {
				Product p = pd.find(id.getText().toString());
				if(p != null) {
					pd.remove(id.getText());
					pd.saveToFile();
					
					id.setText("");
					title.setText("");
					quantity.setText("");
					price.setText("");
				}
				
				else {
					id.setText("Not Found");
					title.setText("");
					quantity.setText("");
					price.setText("");
				}

			}
			
			else if(title.getText().length() > 0) {
				Product p = pd.find(id.getText().toString());
				if(p != null) {
					pd.remove(title.getText());
					pd.saveToFile();
					
					id.setText("");
					title.setText("");
					quantity.setText("");
					price.setText("");
				}
				
				else {
					title.setText("Not Found");
					id.setText("");
					quantity.setText("");
					price.setText("");
				}
			}
			
			else {
				id.setText("Error!!!");
				title.setText("");
				quantity.setText("");
				price.setText("");
			}
				
		}
		
		else if(e.getSource() == clear) {
			id.setText("");
			title.setText("");
			quantity.setText("");
			price.setText("");
		}
		
		else if(e.getSource() == edit) {
			try {
				if(id.getText().length() > 0 && title.getText().length() > 0 && quantity.getText().length() > 0 && price.getText().length() > 0) {
					Product p = new Product(id.getText(), title.getText(), quantity.getText(), price.getText());
					pd.update(p);
					pd.saveToFile();
					
					id.setText("");
					title.setText("");
					quantity.setText("");
					price.setText("");
					
				}
				
				else{
					id.setText("Fill up all fields");
					title.setText("");
					quantity.setText("");
					price.setText("");
				}
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
		}
		
		else if(e.getSource() == cancel) {
			window.dispose();
			AdminWindow mw = new AdminWindow();
			mw.showWindow();
		}
		
		else if(e.getSource() == list) {
			window.dispose();
			AdminProductList c = new AdminProductList();
			c.showWindow();
		}
			
			
	}
	
}	
	
	
