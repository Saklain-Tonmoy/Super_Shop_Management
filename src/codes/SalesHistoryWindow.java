package codes;

import javax.swing.*;
import javax.swing.table.TableCellEditor;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;

public class SalesHistoryWindow implements ActionListener {
	
	private JFrame window;
	
	private JPanel upperPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	
	private JButton refresh;
	
	private JTable table;
	
	SalesHistoryDatabase sh = new SalesHistoryDatabase("Sales History\\sales history.txt");
	
	public SalesHistoryWindow(){
		window = new JFrame();
		window.setLayout(null);
		
		upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(1,2));
		
		middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(1,1));
		
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new GridLayout(1,1,10,10));
		
		table = new JTable(1000,4);
		
		refresh = new JButton(new ImageIcon("images\\refresh4.png"));
		
	}
	
	public void showWindow(){
		
		try {
			
			layoutSetting();
			SalesHistory();
			
			window.setTitle("Selling History");
			window.setSize(800, 600);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window.setLocationRelativeTo(null);
			window.setVisible(true);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

		
	}
	
	public void layoutSetting(){
		
		upperPanel.add(new JLabel(new ImageIcon("images\\history.png")));
		
		upperPanel.add(new JLabel());
		
		table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Serial");
		table.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Date");
		table.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Time");
		table.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Total");
		
		
		JScrollPane pane = new JScrollPane(table);
		table.setAutoResizeMode(table.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
		middlePanel.add(pane);
		
		lowerPanel.add(refresh);
		
		upperPanel.setBounds(200, 0, 600, 150);
		window.add(upperPanel);
		
		middlePanel.setBounds(0, 160, 800, 350);
		window.add(middlePanel);
		
		lowerPanel.setBounds(330, 520 , 100 , 45);
		window.add(lowerPanel);
		
		refresh.addActionListener(this);
	}
	
	public void SalesHistory(){
		
		for(int i= 0;i<sh.size();i++){
			
			SalesHistory temp = (SalesHistory) sh.salesHistoryObject(i);
			if(temp != null) {
				table.setValueAt(i+1, i, 0);
				table.setValueAt(temp.getDate().toString(), i, 1);
				table.setValueAt(temp.getTime().toString(), i, 2);
				table.setValueAt(temp.getTotalPrice(), i, 3);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==refresh){
				
				SalesHistory();
				
			}	
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
			

	}

}
