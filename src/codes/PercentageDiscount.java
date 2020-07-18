package codes;

public class PercentageDiscount implements IDiscount {
	
	private double percentage;
	
	public PercentageDiscount() {
		this.percentage = 50;
	}
	
	public PercentageDiscount(double percentage) {
		this.percentage = percentage;
	}
	
	public double getPercentage() {
		return percentage;
	}
	
	public void setPercenttage(double percentage) {
		this.percentage = percentage;
	}
	
	public double getTotal(double total) {
		return total - (total * (percentage/100));
	}

}
