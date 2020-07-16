/*
 *  This class sets the order subtotal, calculates the sales tax, and calculates the order total.
 */

public class Price {
	private double taxRate = 0.09;
	private double taxAmount = 0;
	private double orderTotal = 0;
	private double subtotal = 0;	
	
	// Sets the subtotal for the bill
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	// Calculates and returns the sales tax
	public double getTax() { 
		taxAmount = subtotal * taxRate;
		return taxAmount;
	}
	// Calculates and returns the order total
	public double getOrderTotal() {
		orderTotal = subtotal + taxAmount;
		return orderTotal;
	}
}