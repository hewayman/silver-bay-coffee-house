/*
 *  This class includes the setters and getters for the customer's name and phone number.
 */

public class Customer {
	private String customerName;
	private String customerPhone;
	
	// Gets the customer's name
	public String getCustomerName() {
		return customerName;
	}
	
	// Sets the customer's name
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	// Gets the customer's phone number
	public String getCustomerPhone() {
		return customerPhone;
	}
	
	// Sets the customer's phone number
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
}
