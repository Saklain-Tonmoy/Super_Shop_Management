package codes;

public class ThresholdDiscount implements IDiscount {
	
	private double threshold;
	private double discount;
	
	public ThresholdDiscount() {
		this.threshold = 500;
		this.discount = 100;
	}
	
	public ThresholdDiscount(double threshold, double discount) {
		this.threshold = threshold;
		this.discount = discount;
	}
	
	public double getThreshold() {
		return threshold;
	}
	
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getTotal(double total) {
		if(this.threshold <= total) {
			return total - this.discount;
		}
		
		else{
			return total;
		}
	}

}
