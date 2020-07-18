package codes;

import javax.swing.*;
import javax.swing.table.TableCellEditor;

import java.awt.*;
import java.awt.event.*;


public class ManagerList implements ActionListener {
	private JFrame window;
	
	private JPanel upperPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;

	private JButton back;
	private JButton refresh;
	
	private JTable table;
	
	public EmployeeDatabase pd = new EmployeeDatabase("admin manager list\\admin manager list.txt");
	
	public ManagerList(){
		
		window = new JFrame();
		window.setLayout(null);
		
		upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(1,1));
		
		middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(1,1));
		
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new GridLayout(1,2,20,20));
		
		table = new JTable(100,5);
		
		back = new JButton(new ImageIcon("images\\back.png"));
		refresh = new JButton(new ImageIcon("images\\refresh4.png"));
		
		
	}
		
		public void showWindow(){
			layoutSetting();
			
			for(int i = 0; i < pd.size(); i++){
				
				Employee e = (Employee) pd.getEmployee(i);
				
				table.setValueAt(i+1, i, 0);
				table.setValueAt(e.getId(), i, 1);
				table.setValueAt(e.getName(), i, 2);
				table.setValueAt(e.getPosition(), i, 3);
				table.setValueAt(e.getSalary(), i, 4);	
			
			}
			
			window.setTitle("manager list");
			window.setSize(800, 600);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setLocationRelativeTo(null);
			window.setVisible(true);
			
		}
		
		public void layoutSetting(){
			
			upperPanel.add(new JLabel(new ImageIcon("images//manager list.png")));
			JLabel message = new JLabel("Manager List");
			Font font = new Font("Serif", Font.BOLD + Font.ITALIC,30);
			message.setFont(font);
			message.setForeground(Color.BLUE);
			upperPanel.add(message);
			
			table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("#");
			table.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("id");
			table.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("title");
			table.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("position");
			table.getTableHeader().getColumnModel().getColumn(4).setHeaderValue("salary");
			
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

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==back){
			window.dispose();
			ManagerEditor me = new ManagerEditor();
			me.showWindow();
		}
		
		else if(e.getSource()==refresh){
			for(int i = 0; i < pd.size(); i++){
				
				Employee e1 = (Employee) pd.getEmployee(i);
				
				table.setValueAt(i+1, i, 0);
				table.setValueAt(e1.getId(), i, 1);
				table.setValueAt(e1.getName(), i, 2);
				table.setValueAt(e1.getPosition(), i, 3);
				table.setValueAt(e1.getSalary(), i, 4);	
			
			}
			
		}
			
	}
}
	


