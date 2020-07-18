package codes;

public class SalesHistory {
	
	private String date;
	private String time;
	private double totalPrice;
	
	public SalesHistory(String date, String time, double total) {
		this.date = date;
		this.time = time;
		this.totalPrice = total;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String toString(){
		return date + "," + ", " + totalPrice+"";
	}

}
