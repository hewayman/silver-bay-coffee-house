/*
 *  This class includes the setters and getters for the milk types and prices 
 */

public class Milk {
	private double dairyPrice = 0;
	private double nonDairyPrice = 0.55;
	private double noMilkPrice = 0;
	private String milkType;
	private double milkPrice;
	private boolean twoPercent;
    private boolean whole;
    private boolean nonfat;
    private boolean cream;
    private boolean almond;
    private boolean oat;
    private boolean coconut;
    private boolean noMilk;
	
 // Returns one of the milk types based on the user's choice
    public String getMilkType() { 
		if (twoPercent == true)
			milkType = "2% Milk";
		if (whole == true)
			milkType = "Whole Milk";
		if (nonfat == true)
			milkType = "Nonfat Milk";
		if (cream == true)
			milkType = "Cream";
		if (almond == true)
			milkType = "Almond Milk";
		if (oat == true)
			milkType = "Oat Milk";
		if (coconut == true)
			milkType = "Coconut Milk";
		if (noMilk == true)
			milkType = "No Milk";
		return milkType; 
	}
	
 // Returns the price of milk based on the user's choice
	public double getMilkPrice() { 
		return milkPrice;
	}
	
	// Gets the dairy price
	public double getDairyPrice() {
		return dairyPrice;
	}
	
	// Gets the non-dairy price
	public double getNonDairyPrice() { 
		return nonDairyPrice;
	}
	
	// Gets the price if no milk is selected
	public double getNoMilkPrice() { 
		return noMilkPrice;
	}
	
	// Sets 2% milk and the dairy price
	public void setTwoPercent(boolean milkType) { 
		twoPercent = true;
		milkPrice = dairyPrice;
	}
	
	// Sets whole milk and the dairy price
	public void setWhole(boolean milkType) {
		whole = true;
		milkPrice = dairyPrice;
	}

	// Sets nonfat milk and the dairy price
	public void setNonfat(boolean milkType) {
		nonfat = true;
		milkPrice = dairyPrice;
	}

	// Sets cream and the dairy price
	public void setCream(boolean milkType) { 
		cream = true;
		milkPrice = dairyPrice;
	}

	// Sets almond milk and the non-dairy price
	public void setAlmond(boolean milkType) {
		almond = true;
		milkPrice = nonDairyPrice;
	}
	
	// Sets oat milk and the non-dairy price
	public void setOat(boolean milkType) { 
		oat = true;
		milkPrice = nonDairyPrice;
	}

	// Sets coconut milk and the non-dairy price
	public void setCoconut(boolean milkType) { 
		coconut = true;
		milkPrice = nonDairyPrice;
	}

	// Sets no milk and the price for no milk
	public void setNoMilk(boolean milkType) { 
		noMilk = true;
		milkPrice = noMilkPrice;
	}
}
