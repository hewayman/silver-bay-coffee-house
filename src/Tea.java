/*
 *  This class inherits the getPrice() method from the abstract Beverage class and returns the tea price.
 */

public class Tea extends Beverage {
	private double teaPrice = 2.75;
	
	// Returns the tea price
	@Override
	public double getPrice() {
		return teaPrice;
	}
}
