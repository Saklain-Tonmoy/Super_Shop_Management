package codes;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesHistoryDatabase {

	private String path;
	private ArrayList<SalesHistory> salesHistory;
	
	public SalesHistoryDatabase (String path){
		this.path = path;
		salesHistory = new ArrayList<SalesHistory>();
		initialize();
	}
	
	public void initialize(){
		try {
			File f = new File(path);
			Scanner s = new Scanner(f);
			
			while(s.hasNextLine()){
				SalesHistory temp = new SalesHistory(s.nextLine(), s.nextLine(), Double.parseDouble(s.nextLine()));
				salesHistory.add(temp);
			}
			
			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int size(){
		return salesHistory.size();
	}
	
	public String toString(){
		String s = "";
		
		for(int i = 0; i < size(); i++){
			s += salesHistory.get(i);
			s += "\n";
		}
		
		return s;
	}
	
	public SalesHistory salesHistoryObject(int i){
		
		SalesHistory temp = (SalesHistory) salesHistory.get(i);
		return temp;
	}
	
	public void add(SalesHistory s){
		salesHistory.add(s);
	}
	
	
	public void saveToFile(){
		try {
			FileWriter fw = new FileWriter(path, false);
			
			for(int i = 0; i < size(); i++){
				SalesHistory temp = (SalesHistory) salesHistory.get(i);
				fw.write(temp.getDate()+ "\n" + temp.getTime() + "\n" + temp.getTotalPrice()+ "\n");
			}
			
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}