/*
 * This abstract class includes the getter and setter for the beverage descriptions (latte, dark roast, green tea, etc.).
 * It also includes the abstract getPrice() method, which gets the drink price from the Coffee, Tea, and Latte classes as needed.
 */

public abstract class Beverage {
	private String description;
	
	// Returns the beverage description 
	public String getDescription() {
		return description;	
	}
	// Setter method for beverage description 
	public void setDescription(String description) {
		this.description = description;
	}
	// Gets the drink price from each of the drink classes  
	public abstract double getPrice();
}
