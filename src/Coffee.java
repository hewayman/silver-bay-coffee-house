/*
 *  This class inherits the getPrice() method from the abstract Beverage class and returns the coffee price.
 */

public class Coffee extends Beverage {
	private double coffeePrice = 3.25;
	
	// Returns the coffee price
	@Override
	public double getPrice() {
		return coffeePrice;
	}
}
