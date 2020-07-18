package codes;

import javax.swing.*;
import javax.swing.table.TableCellEditor;

import java.awt.*;
import java.awt.event.*;


public class AdminProductList implements ActionListener {
	private JFrame window;
	
	private JPanel upperPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	
	private JButton back;
	private JButton refresh;
	
	private JTable table;
	
	public ProductDatabase pd = new ProductDatabase("Product\\product.txt");
	
	public AdminProductList(){
		
		window = new JFrame();
		window.setLayout(null);
		
		upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(1,2));
		
		middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(1,1));
		
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new GridLayout(1,2,20,20));
		
		table = new JTable(100,4);
		
		back = new JButton(new ImageIcon("images\\back.png"));
		refresh = new JButton(new ImageIcon("images\\refresh4.png"));
		
		
	}
		
	public void showWindow(){
			
			products();
			layoutSetting();
			
			window.setTitle("Product List");
			window.setSize(800, 600);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setLocationRelativeTo(null);
			window.setVisible(true);
			
	}
		
	public void layoutSetting(){
			
			upperPanel.add(new JLabel(new ImageIcon("images\\productlist.png")));
			upperPanel.add(new JLabel());
			
			table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Id");
			table.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Title");
			table.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Quantity");
			table.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Price");
			
			JScrollPane pane = new JScrollPane(table);
			table.setAutoResizeMode(table.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			
			middlePanel.add(pane);
			
			lowerPanel.add(back);
			lowerPanel.add(refresh);
			
			upperPanel.setBounds(100, 0, 600, 150);
			window.add(upperPanel);
			
			middlePanel.setBounds(0, 160, 800, 350);
			window.add(middlePanel);
			
			lowerPanel.setBounds(350, 520 , 100 , 40);
			window.add(lowerPanel);
			
			
			
			back.addActionListener(this);
			refresh.addActionListener(this);
	}

	public void products(){
		for(int i= 0;i<pd.size();i++){
				Product temp = pd.productObject(i);
				table.setValueAt(temp.getId(), i, 0);
				table.setValueAt(temp.getTitle(), i, 1);
				table.setValueAt(temp.getQuantity(), i, 2);
				table.setValueAt(temp.getPrice(), i, 3);
				
			
		}
	}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==back){
			window.dispose();
			AdminProductWindow a = new AdminProductWindow();
			a.showWindow();
		}
		
		else if(e.getSource()==refresh){
			
			products();
			
		}
			
	}
	
}
	


