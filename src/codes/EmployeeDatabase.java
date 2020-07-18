package codes;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDatabase {

	private String path;
	private ArrayList<Employee> employee;
	
	public EmployeeDatabase(String path){
		this.path = path;
		employee = new ArrayList<Employee>();
		initialize();
	}
	
	public void initialize(){
		try {
			File f = new File(path);
			Scanner s = new Scanner(f);
			
			while(s.hasNextLine()){
				Employee temp = new Employee(s.nextLine(), s.nextLine(),s.nextLine(), Double.parseDouble(s.nextLine()));
				employee.add(temp);
			}
			
			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int size(){
		return employee.size();
	}
	
	public String toString(){
		String s = "";
		
		for(int i = 0; i < size(); i++){
			s += employee.get(i);
			s += "\n";
		}
		
		return s;
	}
	
	public Employee find(String keyword){
		Employee e = null;
		
		for(int i = 0; i < size(); i++){
			Employee temp = (Employee) employee.get(i);
			
			if(temp.getId().equals(keyword) || temp.getName().equals(keyword)){
				e = temp;
			}
		}
		
		return e;
	}
	
	public Employee findProductToAdd(String id, String title) {
		Employee s = null;
		
		for(int i = 0; i < size(); i++) {
			Employee temp = (Employee) employee.get(i);
			if(temp.getId().toString().equals(id) || temp.getName().toString().equals(title)) {
				s = temp;
			}
		}
		
		return s;
	}
	
	public void update(Employee e) {
		Employee e1 = find(e.getId());
		int i = employee.indexOf(e1);
		employee.remove(i);
		employee.add(i,e);
	}
	
	public void add(Employee e){
		employee.add(e);
	}
	
	
	public void remove(String keyword){
		
		for(int i = 0; i < size(); i++){
			
			
			Employee temp = (Employee) employee.get(i);
			if(temp.getId().equals(keyword) || temp.getName().equals(keyword)){
				employee.remove(i);
				
			}
			
		}
		
	}
	
	public Employee getEmployee(int i ) {
		return employee.get(i);
	}
	
	public void saveToFile(){
		try {
			FileWriter fw = new FileWriter(path, false);
			
			for(int i = 0; i < size(); i++){
				Employee temp = (Employee) employee.get(i);
				fw.write(temp.getId() + "\n" + temp.getName() + "\n"+temp.getPosition()+"\n"+temp.getSalary()+"\n");
			}
			
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}