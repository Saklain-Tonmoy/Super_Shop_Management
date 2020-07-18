package codes;

import javax.swing.*;
import javax.swing.table.TableCellEditor;

import java.awt.*;
import java.awt.event.*;


public class ProductList implements ActionListener {
	private JFrame window;
	
	private JPanel upperPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;

	private JButton refresh;
	
	private JTable table;
	
	public ProductDatabase pd = new ProductDatabase("Product\\product.txt");
	
	public ProductList(){
		
		window = new JFrame();
		window.setLayout(null);
		
		upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(1,2));
		
		middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(1,1));
		
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new GridLayout(1,2,20,20));
		
		table = new JTable(100,4);
		
		refresh = new JButton(new ImageIcon("images\\refresh4.png"));
		
		
	}
		
		public void showWindow(){
			
			products();
			layoutSetting();
			
			window.setTitle("Product List");
			window.setSize(800, 600);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window.setLocationRelativeTo(null);
			window.setVisible(true);
			
		}
		
		public void layoutSetting(){
			
			upperPanel.add(new JLabel(new ImageIcon("images\\productlist.png")));
			upperPanel.add(new JLabel());
			
			table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("id");
			table.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("title");
			table.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("quantity");
			table.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("price");
			
			JScrollPane pane = new JScrollPane(table);
			table.setAutoResizeMode(table.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			
			middlePanel.add(pane);
			
			lowerPanel.add(refresh);
			
			upperPanel.setBounds(100, 0, 600, 150);
			window.add(upperPanel);
			
			middlePanel.setBounds(0, 160, 800, 350);
			window.add(middlePanel);
			
			lowerPanel.setBounds(350, 520 , 100 , 40);
			window.add(lowerPanel);
			
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

		if(e.getSource()==refresh){
			
			products();
			
		}
			
	}
	
}
	


