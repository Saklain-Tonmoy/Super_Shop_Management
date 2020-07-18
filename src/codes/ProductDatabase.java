package codes;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductDatabase {
	
	// this variable is used here for storing the FilePath.
	private String path;
	
	// to Search, Modify, Delete, Add we are using ArrayList<Product>.
	private ArrayList<Product> product;
	
	
	
	//constructor of ProductDatabase Class
	//and also calling initialize() method to Initialize ArrayList<Product>
	public ProductDatabase(String path){
		this.path = path;
		product = new ArrayList<Product>();
		initialize();
	}
	
	
	
	// Initializing the ArrayList<Product> 
	// reading a file and creating an object of Product Class.
	// then adding it to ArrayList<Product>
	public void initialize(){
		try {
			File f = new File(path);
			Scanner s = new Scanner(f);
			
			while(s.hasNextLine()){
				Product temp = new Product(s.nextLine(), s.nextLine(),s.nextLine(), s.nextLine());
				product.add(temp);
			}
			
			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	//returning the size of ArrayList<Product>
	public int size(){
		return product.size();
	}
	
	
	
	//creating a String of all products information
	public String toString(){
		String s = "";
		
		for(int i = 0; i < size(); i++){
			s += product.get(i);
			s += "\n";
		}
		
		return s;
	}
	
	
	//Searching a product in the Database using Id and returning the object
	public Product find(String keyword){
		Product s = null;
		
		for(int i = 0; i < size(); i++){
			Product temp = (Product) product.get(i);
			
			if(temp.getId().equals(keyword) || temp.getTitle().equals(keyword)){
				s = temp;
			}
		}
		
		return s;
	}
	
	
	
	// Searching a product using Id, title and also returning the object
	public Product findProductToAdd(String id, String title) {
		Product s = null;
		
		for(int i = 0; i < size(); i++) {
			Product temp = (Product) product.get(i);
			if(temp.getId().toString().equals(id) || temp.getTitle().toString().equals(title)) {
				s = temp;
			}
		}
		
		return s;
	}
	
	
	// calculating the quantity remaining of a product after sale
	// and also 
	public Product quantityUpdate(Product p) {
		
		Product p1 = find(p.getId());
		double ans = Double.parseDouble(p1.getQuantity().toString()) - Double.parseDouble(p.getQuantity().toString());
		int i = product.indexOf(p1);
		p.setQuantity(ans + "");
		product.remove(i);
		product.add(i, p);
		
		saveToFile();
		
		return p;
	}
	
	
	// this method is returning a product from the ArrayList<Product> 
	// it's parameter is the location of the object depending on i
	public Product productObject(int i){
		
		Product temp = (Product) product.get(i);
		return temp;
	}
	
	
	// updating the product info
	// and again putting the value in the same location of ArrayList<Product>
	public void update(Product p) {
		try {
			Product p1 = find(p.getId());
			int i = product.indexOf(p1);
			product.remove(i);
			product.add(i,p);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	
	// adding a product to the ArrayList<Product> 
	public void add(Product s){
		product.add(s);
	}
	
	
	// deleting a product from the ArrayList<Product>
	public void remove(String keyword){
		
		for(int i = 0; i < size(); i++){
			
			Product temp = (Product) product.get(i);
			if(temp.getId().equals(keyword) || temp.getTitle().equals(keyword)){
				product.remove(i);
				
			}
			
		}
		
	}
	
	
	// Finally, all the updated information about product is written in file.
	public void saveToFile(){
		try {
			FileWriter fw = new FileWriter(path, false);
			
			for(int i = 0; i < size(); i++){
				Product temp = (Product) product.get(i);
				fw.write(temp.getId() + "\n" + temp.getTitle() + "\n"+temp.getQuantity()+"\n"+temp.getPrice()+"\n");
			}
			
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}