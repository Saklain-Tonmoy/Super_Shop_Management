package codes;

import javax.swing.*;
import javax.swing.table.TableCellEditor;

import java.awt.*;
import java.awt.event.*;


public class EmployeeListForManager implements ActionListener {
	private JFrame window;
	
	private JPanel upperPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;

	private JButton back;
	private JButton refresh;
	
	private JTable table;
	
	public EmployeeDatabase pd = new EmployeeDatabase("Employee Database\\employee database.txt");
	
	public EmployeeListForManager(){
		
		window = new JFrame();
		window.setLayout(null);
		
		upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(1,2));
		
		middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(1,1));
		
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new GridLayout(1,2,20,20));
		
		table = new JTable(100,5);
		
		back = new JButton(new ImageIcon("images\\back.png"));
		refresh = new JButton(new ImageIcon("images\\refresh4.png"));
		
		
	}
		
		public void showWindow(){
			
			employee();
			layoutSetting();
			
			window.setTitle("Employee List");
			window.setSize(800, 600);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setLocationRelativeTo(null);
			window.setVisible(true);
	
			
		}
		
		public void layoutSetting(){
			
			upperPanel.add(new JLabel(new ImageIcon("images//employee list.png")));
			JLabel message = new JLabel("Employee List");
			Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 30);
			message.setFont(font);
			message.setForeground(Color.BLUE);
			upperPanel.add(message);
			
			table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Serial");
			table.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Id");
			table.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Title");
			table.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Position");
			table.getTableHeader().getColumnModel().getColumn(4).setHeaderValue("Salary");
			
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

		public void employee(){
			for(int i = 0; i < pd.size(); i++){
				
				Employee e = (Employee) pd.getEmployee(i);
				
				table.setValueAt(i+1, i, 0);
				table.setValueAt(e.getId(), i, 1);
				table.setValueAt(e.getName(), i, 2);
				table.setValueAt(e.getPosition(), i, 3);
				table.setValueAt(e.getSalary(), i, 4);	
			
		}
				
			
			
	}
		
		
	

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==back){
			window.dispose();
			EmployeeEditByManager em = new EmployeeEditByManager();
			em.showWindow();
		}
		
		else if(e.getSource()==refresh){
			
			employee();
			
		}
			
	}
	
}
	


