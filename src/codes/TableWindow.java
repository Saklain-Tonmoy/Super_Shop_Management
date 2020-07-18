package codes;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.*;

public class TableWindow implements ActionListener {

	private JFrame window;
	
	private JPanel upperPanel_1;
	private JPanel upperPanel;
	private JPanel grandPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel leftBtn;
	private JPanel rightBtn;
	
	private JTextField id;
	private JTextField title;
	private JTextField unitPrice;
	private JTextField grandText;
	private JTextField qtyStock;
	private JTextField percentageText;
	private JTextField thresholdText;
	private JTextField thresholdDiscountText;
	
	private JSpinner qty;
	
	private JButton addBtn;
	private JButton newBtn;
	private JButton clearBtn;
	private JButton printBtn;
	private JButton searchBtn;
	private JButton cancelBtn;
	
	private JTable table;
	
	private Date date;

	private JButton setBtn;

	private JButton resetBtn;

	private JButton exitBtn;
	
	ProductDatabase database = new ProductDatabase("Product//product.txt");

	private JPanel panel_3;

	private JButton list;
	
	public TableWindow() {
		
		window = new JFrame();
		window.setLayout(null);
		
		upperPanel_1 = new JPanel();
		upperPanel_1.setLayout(new GridLayout(1, 2,50,50));
		
		upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(1,1));
		
		panel_3 = new JPanel(new GridLayout(1,1,0,0));
		
		grandPanel = new JPanel();
		grandPanel.setLayout(new GridLayout(1, 1, 10, 10));
		
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(5,2,8,8));
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(4,2,40,7));
		
		rightBtn = new JPanel();
		rightBtn.setLayout(new GridLayout(1,2,40,10));
		
		leftBtn = new JPanel();
		leftBtn.setLayout(new GridLayout(2,3,40,10));
		
		id = new JTextField(20);
		title = new JTextField(20);
		unitPrice = new JTextField(20);
		grandText = new JTextField(20);
		qtyStock = new JTextField();
		percentageText = new JTextField(20);
		thresholdText = new JTextField(20);
		thresholdDiscountText = new JTextField(20);
		
		qty = new JSpinner();
		
		SpinnerNumberModel snm = new SpinnerNumberModel(0, 0, 200000, 0.5);
		qty.setModel(snm);
		
		addBtn = new JButton(new ImageIcon("images\\add1.png"));
		newBtn = new JButton (new ImageIcon("images\\new.png"));
		clearBtn = new JButton(new ImageIcon("images\\clear3.png"));
		printBtn = new JButton(new ImageIcon("images\\printer.png"));
		searchBtn = new JButton(new ImageIcon("images\\find.png"));
		cancelBtn = new JButton(new ImageIcon("images\\back.png"));
		
		setBtn = new JButton(new ImageIcon("images\\submit.png"));
		resetBtn = new JButton(new ImageIcon("images\\clear3.png"));
		exitBtn = new JButton(new ImageIcon("images\\cancel.png"));
		
		list = new JButton (new ImageIcon("images\\products.png"));
		
		
		list.addActionListener(this);
		addBtn.addActionListener(this);
		newBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		printBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		setBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		exitBtn.addActionListener(this);

		table = new JTable(20,6);
		table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Serial");
		table.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Id");
		table.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Name");
		table.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Quantity");
		table.getTableHeader().getColumnModel().getColumn(4).setHeaderValue("Unit Price");
		table.getTableHeader().getColumnModel().getColumn(5).setHeaderValue("Subtotal");
		
		JScrollPane pane = new JScrollPane(table);
		
		upperPanel_1.add(new JLabel(new ImageIcon("images\\sale1.png")));
		JLabel message = new JLabel("Sale On!!!");
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 40);
		message.setFont(font);
		message.setForeground(Color.BLUE);
		upperPanel_1.add(message);
		upperPanel_1.setBounds(150, 10, 450, 140);
		window.add(upperPanel_1);
		
		upperPanel.add(pane);
		upperPanel.setBounds(0, 170, 1000, 150);
		window.add(upperPanel);
		
		panel_3.add(list);	
		panel_3.setBounds(920, 13, 60, 50);
		window.add(panel_3);
		
		
		JLabel grandLabel = new JLabel("Grand Total:");
		Font font1 = new Font("Serif", Font.BOLD + Font.ITALIC, 25);
		grandLabel.setFont(font1);
		grandLabel.setForeground(Color.RED);
		grandPanel.add(grandLabel);
		grandText.setFont(font1);
		grandText.setForeground(Color.BLUE);
		grandPanel.add(grandText);
		grandPanel.setBounds(630, 370, 300, 50);
		window.add(grandPanel, BorderLayout.EAST);
		
		
		
		Font fo = new Font("Serif", Font.BOLD, 16);
		JLabel idlabel = new JLabel("Id");
		idlabel.setForeground(Color.BLACK);
		idlabel.setFont(fo);
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(fo);
		JLabel qtylabel = new JLabel("Quantity Sold");
		qtylabel.setForeground(Color.BLACK);
		qtylabel.setFont(fo);
		JLabel stockLabel = new JLabel("Quantity Stock");
		stockLabel.setForeground(Color.BLACK);
		stockLabel.setFont(fo);
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setForeground(Color.BLACK);
		priceLabel.setFont(fo);
		
		
		leftPanel.add(idlabel);
		leftPanel.add(id);
		leftPanel.add(nameLabel);
		leftPanel.add(title);
		leftPanel.add(qtylabel);
		leftPanel.add(qty);
		leftPanel.add(stockLabel);
		leftPanel.add(qtyStock);
		leftPanel.add(priceLabel);
		leftPanel.add(unitPrice);
		leftPanel.setBounds(100, 370, 430, 180);
		window.add(leftPanel);
		
		
		leftBtn.add(newBtn);
		leftBtn.add(addBtn);
		leftBtn.add(searchBtn);
		leftBtn.add(cancelBtn);
		leftBtn.add(clearBtn);
		leftBtn.add(printBtn);
		leftBtn.setBounds(100, 560, 430, 100);
		window.add(leftBtn);
		
		
		Font f = new Font("Serif", Font.BOLD + Font.ITALIC, 16);
		JLabel pd = new JLabel("Percentage Discount");
		pd.setFont(f);
		pd.setForeground(Color.BLUE);
		JLabel p = new JLabel("Threshold Amount");
		p.setFont(f);
		p.setForeground(Color.BLUE);
		JLabel td = new JLabel("Threshold Discount");
		td.setFont(f);
		td.setForeground(Color.BLUE);
		rightPanel.add(pd);
		rightPanel.add(percentageText);
		rightPanel.add(p);
		rightPanel.add(thresholdText);
		rightPanel.add(td);
		rightPanel.add(thresholdDiscountText);
		rightPanel.setBounds(600, 450, 330, 130);
		window.add(rightPanel);
		
		
		rightBtn.add(resetBtn);
		rightBtn.add(setBtn);
		rightBtn.setBounds(630, 580, 280, 50);
		window.add(rightBtn);
		
		window.setTitle("Sale On!!!");
		window.setSize(1000, 700);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}
	
	public int getRow() {
		int r = 0;
		for(r = 0; r < table.getRowCount(); r++) {
			if(table.getValueAt(r, 0) == null || table.getValueAt(r, 0).equals(""))
				break;
		}
		return r;
	}
	
	public void print() {
		int r = getRow();
		for (int i = 0; i < r; i++){
			for(int j = 2; j < table.getColumnCount(); j++) {
				if(table.getValueAt(i, j) != "")
					System.out.println(table.getTableHeader().getColumnModel().getColumn(j).getHeaderValue() + " : " + table.getValueAt(i, j).toString());
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Grand Total : " + grandText.getText().toString());
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newBtn){
			id.setText("");
			title.setText("");
			qty.setValue(new Integer(0));
			unitPrice.setText("");
			grandText.setText("");
			qtyStock.setText("");
			percentageText.setText("");
			thresholdDiscountText.setText("");
			thresholdText.setText("");
			
			for (int i = 0; i < table.getRowCount(); i++){
				for(int j = 0; j < table.getColumnCount(); j++) {
					table.setValueAt("", i, j);
				}
			}
			
		}
		
		else if(e.getSource() == addBtn){
			
			if(Double.parseDouble(qty.getValue().toString()) != 0 && ( Double.parseDouble(qtyStock.getText().toString()) > Double.parseDouble(qty.getValue().toString()))) {
				String i = id.getText();
				String t = title.getText();
				double q = Double.parseDouble(qty.getValue().toString());
				double p = Double.parseDouble(unitPrice.getText().toString());
				
				int r = getRow();
				
				table.setValueAt(r+1, r, 0);
				table.setValueAt(i, r, 1);
				table.setValueAt(t, r, 2);
				table.setValueAt(q, r, 3);
				table.setValueAt(p, r, 4);
				table.setValueAt(p * q, r, 5);
				
				double total = 0;
				for(int j = 0; j <= r; j++) {
					total += (double) table.getValueAt(j, 5);
				}
				
				id.setText("");
				title.setText("");
				unitPrice.setText("");
				qty.setValue(0);
				qtyStock.setText("");
				grandText.setText(total + "");
				
			}
			
			else {
				id.setText("Check Quantity");
				title.setText("");
				qty.setValue(0);
				unitPrice.setText("");
				qtyStock.setText("");
			}
			
		}
		
		else if(e.getSource() == printBtn) {
			
			int r = getRow();
			Product p1 = null;
			Product p = null;
			for(int i = 0; i < r; i++) {
				table.getValueAt(i, 1);
				table.getValueAt(i, 2);
				table.getValueAt(i, 3);
				table.getValueAt(i, 4);
				
				p = new Product(table.getValueAt(i, 1).toString(),table.getValueAt(i, 2).toString(),table.getValueAt(i, 3).toString(),table.getValueAt(i, 4).toString());
				p1 = (Product) database.quantityUpdate(p);
				database.saveToFile();
				
				

				}
			
			if(grandText.getText() != "") {
				File file = new File("Sales History//sales history.txt");
				try {
					date = new Date();
					FileWriter fw = new FileWriter(file,true);
					fw.write(date.getDate() + "\n" + date.getTime() + "\n" + grandText.getText() + "\n");
					fw.close();
				} catch(Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
			
			print();
		}
		
		else if(e.getSource() == clearBtn) {
			id.setText("");
			title.setText("");
			unitPrice.setText("");
			qty.setValue(0);
			qtyStock.setText("");

		}
		
		else if(e.getSource() == searchBtn) {
			if(id.getText().length() > 0) {
				ProductDatabase pd = new ProductDatabase("Product\\product.txt");
				Product s = pd.find(id.getText().toString());
				if(s != null) {
					id.setText(s.getId());
					title.setText(s.getTitle().toString());
					unitPrice.setText(s.getPrice().toString());
					qtyStock.setText(s.getQuantity().toString());
				}
				
				else{
					id.setText("Product not found");
				}
			}
			
			else if(title.getText().length() > 0) {
				ProductDatabase pd = new ProductDatabase("Product\\product.txt");
				Product s = pd.find(title.getText().toString());
				if(s != null) {
					id.setText(s.getId().toString());
					title.setText(s.getTitle().toString());
					unitPrice.setText(s.getPrice().toString());
					qtyStock.setText(s.getQuantity().toString());
				}
				
				else {
					title.setText("Product not found");
				}
			}
			
			else {
				id.setText("Enter Id or Title to Search");
			}
		}
		
		else if(e.getSource() == cancelBtn) {
			window.dispose();
			LoginWindow login = new LoginWindow();
			login.showWindow();
		}
		
		else if(e.getSource() == setBtn) {
		
			if(grandText.getText().length() > 0) {
				if(percentageText.getText().length() > 0 && thresholdDiscountText.getText().length() == 0 && thresholdText.getText().length() == 0) {
					PercentageDiscount pd = new PercentageDiscount(Double.parseDouble(percentageText.getText()));
					double grandTotal = pd.getTotal(Double.parseDouble(grandText.getText().toString()));
					grandText.setText(grandTotal + "");
				}
				
				else if(percentageText.getText().length() == 0 && thresholdText.getText().length() > 0 && thresholdDiscountText.getText().length() > 0) {
					ThresholdDiscount td = new ThresholdDiscount(Double.parseDouble(thresholdText.getText()), Double.parseDouble(thresholdDiscountText.getText()));
					double grandTotal = td.getTotal(Double.parseDouble(grandText.getText().toString()));
					grandText.setText(grandTotal + "");
				}
			}
			
			else {
				grandText.setText("Error!!!");
			}
		}
		
		else if(e.getSource() == list) {
			ProductList c = new ProductList();
			c.showWindow();
		}
		
		else if(e.getSource() == resetBtn) {
			percentageText.setText("");
			thresholdDiscountText.setText("");
			thresholdText.setText("");
		}
	}

}
