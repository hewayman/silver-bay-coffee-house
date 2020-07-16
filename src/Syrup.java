/*
 *  This class includes the setters and getters for syrup types and prices. 
 */

public class Syrup {
	private double syrupPrice = 0.55;
	private double noSyrupPrice = 0;
	private String syrupType;
	private double syrupTotal;
	private boolean mocha;
	private boolean vanilla;
	private boolean caramel;
	private boolean sfVanilla;
	private boolean sfCaramel;
	private boolean noSyrup;	
	
	// Returns one of the syrup types based on the user's choice
	public String getSyrupType() { 
		if (mocha == true)
				syrupType = "Mocha";
		if (vanilla == true)
			syrupType = "Vanilla";
		if (caramel == true)
			syrupType = "Caramel";
		if (sfVanilla == true)
			syrupType = "Sugar-Free Vanilla";
		if (sfCaramel == true)
			syrupType = "Sugar-Free Caramel";
		if (noSyrup == true)
			syrupType = "No Syrup";
		return syrupType; 
	}
	
	// Returns the total syrup price based on the user's selection
	public double getSyrupTotal() { 
		return syrupTotal;
	}
	
	// Gets the syrup price
	public double getSyrupPrice() { 
		return syrupPrice;
	}
	
	// Gets the price for no syrup
	public double getNoSyrupPrice() { 
		return noSyrupPrice;
	}
	
	// Sets mocha and syrup price
	public void setMocha(boolean syrupType) { 
		mocha = true;
		syrupTotal = syrupPrice;
	}
	
	// Sets vanilla and syrup price
	public void setVanilla(boolean syrupType) {
		vanilla = true;
		syrupTotal = syrupPrice;
	}
	
	// Sets caramel and syrup price
	public void setCaramel(boolean syrupType) {
		caramel = true;
		syrupTotal = syrupPrice;
	}
	
	// Sets sugar-free vanilla and syrup price
	public void setSFVanilla(boolean syrupType) {
		sfVanilla = true;
		syrupTotal = syrupPrice;
	}
	
	// Sets sugar-free caramel and syrup price
	public void setSFCaramel(boolean syrupType) {
		sfCaramel = true;
		syrupTotal = syrupPrice;
	}
	
	// Sets no syrup and the no syrup price
	public void setNoSyrup(boolean syrupType) {
		noSyrup = true;
		syrupTotal = noSyrupPrice;
	}
}
