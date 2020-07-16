/*
 * This class inherits the getPrice() method from the abstract Beverage class and returns the latte price.
 */

public class Latte extends Beverage {
	private double lattePrice = 4.25;
	
	// Returns the latte price
	@Override
	public double getPrice() {
		return lattePrice;
	}
}
