/* 
 * Hannah Wayman
 * 5/13/2020
 * This program creates an order screen that allows a customer to choose between coffee, tea, or a latte. 
 * It also provides the customer with milk and syrup choices. 
 * After the order is submitted, it calculates the subtotal, tax, and total bill.
 */

import javafx.application.Application;
import javafx.scene.control.*;
import java.util.Date;
import java.text.DateFormat;
import javafx.scene.text.Font;
import javafx.geometry.HPos;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import java.util.regex.Matcher;
import javafx.stage.Modality;
import javafx.geometry.Orientation;
import java.util.regex.Pattern;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import java.text.SimpleDateFormat;
import javafx.stage.Stage;
import java.util.concurrent.TimeUnit;

public class OrderScreenFX extends Application {
	Stage stage;
	Scene orderScene, flavorScene, confirmationScene;
	
	private TextField tfName = new TextField();
	private TextField tfPhone = new TextField();
	private RadioButton rbDecafRoast = new RadioButton("Decaf roast");
	private RadioButton rbLightRoast = new RadioButton("Light roast");
	private RadioButton rbMediumRoast = new RadioButton("Medium roast");
	private RadioButton rbDarkRoast = new RadioButton("Dark roast");
	private RadioButton rbEarlGrey = new RadioButton("Earl Grey");
	private RadioButton rbEnglishTea = new RadioButton("English Breakfast Tea");
	private RadioButton rbGreenTea = new RadioButton("Green Tea");
	private RadioButton rbLatte = new RadioButton("Latte");
	private RadioButton rbCappuccino = new RadioButton("Cappuccino");
	private Button btnStart = new Button("Start Order");
	private ToggleGroup orderGroup = new ToggleGroup();
	private RadioButton rbAlmond = new RadioButton("Almond");
	private RadioButton rbCoconut = new RadioButton("Coconut");
	private RadioButton rbOat = new RadioButton("Oat");
	private RadioButton rbTwoPercent = new RadioButton("2%");
	private RadioButton rbWhole = new RadioButton("Whole");
	private RadioButton rbNonfat = new RadioButton("Nonfat");
	private RadioButton rbCream = new RadioButton("Cream");
	private RadioButton rbNoMilk = new RadioButton("None");
	private ToggleGroup milkGroup = new ToggleGroup();
	private RadioButton rbMocha = new RadioButton("Mocha");
	private RadioButton rbVanilla = new RadioButton("Vanilla");
	private RadioButton rbCaramel = new RadioButton("Caramel");
	private RadioButton rbSFVanilla = new RadioButton("Sugar-free Vanilla");
	private RadioButton rbSFCaramel = new RadioButton("Sugar-free Caramel");
	private RadioButton rbNoSyrup = new RadioButton("None");
	private ToggleGroup syrupGroup = new ToggleGroup();
	private Button btnBack = new Button("Back");
	private Button btnSubmit = new Button("Submit Order");
	private boolean validName;
	private boolean validPhone;
	private String drinkChoice;
	private double drinkPrice;
	private double milkPrice;
	private double syrupPrice;
	private double subtotalPrice;
	private String subtotal;
	private String tax;
	private String total;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		
		/* Start Scene1 - OrderScene - contains customer information and drink options */
		
		// Creates a grid pane for the customer information labels and text fields
			GridPane customerGridPane = new GridPane();
			customerGridPane.setStyle("-fx-background-color: white; -fx-font: 12 \"Lato\";");
			customerGridPane.add(new Label("Enter your name: "), 0, 0);
			customerGridPane.add(tfName, 1, 0);
			tfName.setPrefColumnCount(30);
			customerGridPane.add(new Label("Enter your phone number: "), 0, 1);
			customerGridPane.add(tfPhone, 1, 1);
			tfPhone.setPrefColumnCount(9);
			customerGridPane.setHgap(60);
			customerGridPane.setVgap(5);
			
			// Creates a VBox to hold the grid pane for the customer contact information
			VBox topVBox = new VBox(5);
			topVBox.setStyle("-fx-background-color: white; -fx-font: 12 \"Lato\";");
			topVBox.getChildren().addAll(new Label("Begin your order by entering your name and contact information:"),
					customerGridPane);
			
			// Create a new separator for the customer's information and drink options
			Separator separator = new Separator(Orientation.HORIZONTAL);
			separator.setMaxWidth(700);
		
			// Creates an ImageView for the coffee image
			ImageView coffeeImage = new ImageView("Image/coffee.jpg");
			coffeeImage.setFitWidth(200);
			coffeeImage.setFitHeight(100);
			coffeeImage.setPreserveRatio(true);
			
			// Create ImageView for the tea image
			ImageView teaImage = new ImageView("Image/tea.jpg");
			teaImage.setFitWidth(200);
			teaImage.setFitHeight(100);
			teaImage.setPreserveRatio(true);
			
			// Create ImageView for the latte image
			ImageView latteImage = new ImageView("Image/latte.jpg");
			latteImage.setFitWidth(200);
			latteImage.setFitHeight(100);
			latteImage.setPreserveRatio(true);
			
			// Creates a grid pane for the coffee, tea, and latte images and radio buttons
			GridPane centerGridPane = new GridPane();
			centerGridPane.setStyle("-fx-background-color: white; -fx-font: 12 \"Lato\";");
			Coffee coffee = new Coffee();
			centerGridPane.add(coffeeImage, 0, 0);
			centerGridPane.add(new Label("Coffee: $" + coffee.getPrice()), 0, 1);
			centerGridPane.add(rbDecafRoast, 0, 2);
			centerGridPane.add(rbLightRoast, 0, 3);
			centerGridPane.add(rbMediumRoast, 0, 4);
			centerGridPane.add(rbDarkRoast, 0, 5);
			Tea tea = new Tea();
			centerGridPane.add(teaImage, 1, 0);
			centerGridPane.add(new Label("Tea: $" + tea.getPrice()), 1, 1);
			centerGridPane.add(rbEarlGrey, 1, 2);
			centerGridPane.add(rbEnglishTea, 1, 3);
			centerGridPane.add(rbGreenTea, 1, 4);
			Latte latte = new Latte();
			centerGridPane.add(latteImage, 2, 0);
			centerGridPane.add(new Label("Other: $" + latte.getPrice()), 2, 1);
			centerGridPane.add(rbLatte, 2, 2);
			centerGridPane.add(rbCappuccino, 2, 3);
			centerGridPane.setAlignment(Pos.CENTER);
			centerGridPane.setHgap(60);
			centerGridPane.setVgap(10);
			centerGridPane.setPadding(new Insets(20, 10, 20, 10));
			
			// Creates a VBox for the drink options
			VBox centerVBox = new VBox();
			centerVBox.setStyle("-fx-background-color: white; -fx-font: 12 \"Lato\";");
			centerVBox.getChildren().addAll(new Label("Next, choose a drink option: "),
					centerGridPane);

			// Groups the drink radio buttons
			rbDecafRoast.setToggleGroup(orderGroup);
			rbLightRoast.setToggleGroup(orderGroup);
			rbMediumRoast.setToggleGroup(orderGroup);
			rbDarkRoast.setToggleGroup(orderGroup);
			rbEarlGrey.setToggleGroup(orderGroup);
			rbEnglishTea.setToggleGroup(orderGroup);
			rbGreenTea.setToggleGroup(orderGroup);
			rbLatte.setToggleGroup(orderGroup);
			rbCappuccino.setToggleGroup(orderGroup);
			rbDecafRoast.setSelected(true);
					
			// Creates an HBox and places the Start button in the center
			HBox hBox = new HBox(5);
			hBox.setStyle("-fx-background-color: white;");
			btnStart.setFont(new Font("Lato", 13)); // Set font of button
			hBox.getChildren().add(btnStart);
			hBox.setAlignment(Pos.CENTER);
			
			// Creates an image view for the logo
			ImageView imageView = new ImageView("image/logo3.png");
			imageView.setFitWidth(400);
			imageView.setPreserveRatio(true);
			
			// Creates a VBox and adds the logo, customer information VBox, drink option VBox, and start button
			VBox orderVBox = new VBox(20);
			orderVBox.setStyle("-fx-background-color: transparent;");
			orderVBox.getChildren().addAll(imageView, topVBox, separator, centerVBox, hBox);
			orderVBox.setAlignment(Pos.CENTER);
			orderVBox.setPadding(new Insets(0, 40, 40, 40));
			
			Customer customer = new Customer();
			Price price = new Price();
			
			btnStart.setOnAction(e -> {
				
				// Gets customer information from text boxes
				String customerName = tfName.getText().trim(); // Get text from the name text box and trims it
				
				// Creates a pattern and matcher to check for a valid name
				Pattern patternName = Pattern.compile("^[a-zA-z ]*$");
				Matcher matcherName = patternName.matcher(customerName);
				
				if(customerName.length() == 0 || !matcherName.matches()) // Is length over zero and valid
			      	noName();
					else {
						if(customerName.length() > 0 && matcherName.matches()) {
							customer.setCustomerName(customerName); // Sets customerName if valid
							validName = true;
						}
					}
		
				String customerPhone = tfPhone.getText().trim(); // Gets text from the phone text box and trims it

				// Create a pattern and matcher to check for a valid phone number
				Pattern patternPhone = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
				Matcher matcherPhone = patternPhone.matcher(customerPhone);
				
				if(customerPhone.length() == 0 || !matcherPhone.matches()) // Is length over zero and valid
			      	noPhone();
					else {
						if(customerPhone.length() > 0 && matcherPhone.matches()) {
							customer.setCustomerPhone(customerPhone); //  Sets customerPhone if valid
							validPhone = true;
						}
					}
				
				System.out.println("Customer Name: " + customer.getCustomerName());
				System.out.println("Customer Phone: " + customer.getCustomerPhone());
				
				// Sets the drinkChoice(description) and price for each of the drink option radio buttons
				if (rbDecafRoast.isSelected()) {
					Coffee b = new Coffee();
					b.setDescription("Decaf Coffee");
					drinkChoice = b.getDescription();
					drinkPrice = b.getPrice();
				}
				if (rbLightRoast.isSelected()) {
					Coffee b = new Coffee();
					b.setDescription("Light Roast Coffee");
					drinkChoice = b.getDescription();
					drinkPrice = b.getPrice();
				}
				if (rbMediumRoast.isSelected()) {
					Coffee b = new Coffee();
					b.setDescription("Medium Roast Coffee");
					drinkChoice = b.getDescription();
					drinkPrice = b.getPrice();
				}
				if (rbDarkRoast.isSelected()) {
					Coffee b = new Coffee();
					b.setDescription("Dark Roast Coffee");
					drinkChoice = b.getDescription();
					drinkPrice = b.getPrice();
				}
				if (rbEarlGrey.isSelected()) {
					Tea t = new Tea();
					t.setDescription("Earl Grey Tea");
					drinkChoice = t.getDescription();
					drinkPrice = t.getPrice();
				}
				if (rbEnglishTea.isSelected()) {
					Tea t = new Tea();
					t.setDescription("English Breakfast Tea");
					drinkChoice = t.getDescription();
					drinkPrice = t.getPrice();
				}
				if (rbGreenTea.isSelected()) {
					Tea t = new Tea();
					t.setDescription("Green Tea");
					drinkChoice = t.getDescription();
					drinkPrice = t.getPrice();
				}
				if (rbLatte.isSelected() ) {
					Latte l = new Latte();
					l.setDescription("Latte");
					drinkChoice = l.getDescription();
					drinkPrice = l.getPrice();
				}
				if (rbCappuccino.isSelected() ) {
					Latte l = new Latte();
					l.setDescription("Cappuccino");
					drinkChoice = l.getDescription();
					drinkPrice = l.getPrice();
				}
				
				// If there is a valid name and phone number, set the next scene
				if (validName == true && validPhone == true) {
					stage.setScene(flavorScene);
				}
				
				System.out.println(drinkChoice);
				System.out.println(drinkPrice);
				
			});
			
		/* End Scene1 - orderScene */
		
		/* Start Scene2 - flavorScene - contains the milk and syrup options */
			
			Milk milk = new Milk();
			Syrup syrup = new Syrup();
			
			// Creates a grid pane for the milk labels and radio buttons
	        GridPane leftControl  = new GridPane();			
	        leftControl.setStyle("-fx-background-color: white; -fx-font: 12 \"Lato\";");
	        Label milkLabel = new Label("Milk Options");
	        milkLabel.setFont(new Font("Lato", 15));
			leftControl.add(milkLabel, 0, 0);
	        leftControl.add(new Label("Dairy: "), 0, 1);
	        leftControl.add(rbTwoPercent, 0, 2);
	        leftControl.add(rbWhole, 0, 3);
	        leftControl.add(rbNonfat, 0, 4);
	        leftControl.add(rbCream, 0, 5);
	        leftControl.add(new Label("Nondairy: $" + milk.getNonDairyPrice()), 1, 1);
	        leftControl.add(rbAlmond, 1, 2);
	        leftControl.add(rbOat, 1, 3);
	        leftControl.add(rbCoconut, 1, 4);
	        leftControl.add(rbNoMilk, 1, 5);
	        leftControl.setHgap(60);
	        leftControl.setVgap(10);
	        leftControl.setPadding(new Insets(20, 10, 20, 40));
	        
	        // Groups the milk radio buttons
	        rbTwoPercent.setToggleGroup(milkGroup);
	        rbWhole.setToggleGroup(milkGroup);
	        rbNonfat.setToggleGroup(milkGroup);
	        rbCream.setToggleGroup(milkGroup);
	        rbAlmond.setToggleGroup(milkGroup);
	        rbOat.setToggleGroup(milkGroup);
	        rbCoconut.setToggleGroup(milkGroup);
	        rbNoMilk.setToggleGroup(milkGroup);
	        rbTwoPercent.setSelected(true);
	        	        
	        // Creates a grid pane for the syrup labels and radio buttons
	        GridPane rightControl = new GridPane();
	        Label syrupLabel = new Label("Syrup Options");
	        syrupLabel.setFont(new Font("Lato", 15));
	        rightControl.add(syrupLabel, 0, 0);
	        rightControl.add(new Label("Regular: $" + syrup.getSyrupPrice()), 0, 1);
	        rightControl.add(rbMocha, 0, 2);
	        rightControl.add(rbVanilla, 0, 3);
	        rightControl.add(rbCaramel, 0, 4);
	        rightControl.add(new Label("Sugar-Free: $" + syrup.getSyrupPrice()), 1, 1);
	        rightControl.add(rbSFVanilla, 1, 2);
	        rightControl.add(rbSFCaramel, 1, 3);
	        rightControl.add(rbNoSyrup, 1, 4);
	        rightControl.setHgap(20);
	        rightControl.setVgap(10);
	        rightControl.setPadding(new Insets(20, 10, 20, 10));
	        
	        // Groups the syrup radio buttons
	        rbMocha.setToggleGroup(syrupGroup);
	        rbVanilla.setToggleGroup(syrupGroup);
	        rbCaramel.setToggleGroup(syrupGroup);
	        rbSFVanilla.setToggleGroup(syrupGroup);
	        rbSFCaramel.setToggleGroup(syrupGroup);
	        rbNoSyrup.setToggleGroup(syrupGroup);
	        rbMocha.setSelected(true);
	        
	        // Creates a separator for the milk and syrup options
	        Separator milkSep = new Separator(Orientation.VERTICAL);
	        milkSep.setMaxHeight(175);
	        
	        // Creates an HBox for the milk and syrup options
	        HBox optionsHB = new HBox();
	        optionsHB.getChildren().addAll(leftControl, milkSep, rightControl);
	        optionsHB.setAlignment(Pos.CENTER);
	        
	        // Creates an ImageView for the coffee shop image
	        ImageView milkImage = new ImageView("Image/milk.jpg");
	        milkImage.setFitWidth(600);
	        milkImage.setFitHeight(275);
	        milkImage.setPreserveRatio(true);

			// Creates an HBox for the Submit and Back buttons 
			HBox flavorHBox = new HBox(5);
			flavorHBox.setStyle("-fx-background-color: white;");
			btnSubmit.setFont(new Font("Lato", 13));
			btnBack.setFont(new Font("Lato", 13));
			flavorHBox.getChildren().addAll(btnSubmit, btnBack);
			flavorHBox.setAlignment(Pos.CENTER);
			
			// Creates an ImageView for the logo
			ImageView imageView2 = new ImageView("image/logo3.png");
			imageView2.setFitWidth(400);
			imageView2.setPreserveRatio(true);
			
			// Creates a VBox for the logo, milk image, milk options, and syrup options
			VBox flavorVBox = new VBox(20);
			flavorVBox.setStyle("-fx-background-color: white; -fx-font: 12 \"Lato\";");
			flavorVBox.getChildren().addAll(imageView2, milkImage, optionsHB, flavorHBox);
			flavorVBox.setAlignment(Pos.CENTER);
			flavorVBox.setPadding(new Insets(0, 40, 40, 40));
			flavorScene = new Scene(flavorVBox, 700, 675);
			
			btnBack.setOnAction(e -> {
				stage.setScene(orderScene); // Go back to the previous screen
			});
		
			GridPane customerGP = new GridPane(); // Grid pane for the customer information
			GridPane orderGP = new GridPane(); // Grid pane for the order details
			GridPane totalGP = new GridPane(); // Grid pane the for order total
			GridPane thanksGP = new GridPane(); // Grid pane for the thank you message
			
			// Creates a new separator for the thank you message and order details
			Separator thanksSep = new Separator(Orientation.HORIZONTAL);
			thanksSep.setMaxWidth(400);

			btnSubmit.setOnAction(e -> { // Set actions for milk and syrup radio buttons
				// Milk radio buttons
				if (rbTwoPercent.isSelected()) {
					milk.setTwoPercent(true);
				}
				if (rbWhole.isSelected()) {
					milk.setWhole(true);
				}
				if (rbNonfat.isSelected()) {
					milk.setNonfat(true);
				}
				if (rbCream.isSelected()) {
					milk.setCream(true);
				}
				if (rbAlmond.isSelected()) {
					milk.setAlmond(true);
				}
				if (rbOat.isSelected()) {
					milk.setOat(true);
				}
				if (rbCoconut.isSelected()) {
					milk.setCoconut(true);
				}
				if (rbNoMilk.isSelected()) {
					milk.setNoMilk(true);
				}
				// Syrup radio buttons
				if (rbMocha.isSelected()) {
					syrup.setMocha(true);
				}
				if (rbVanilla.isSelected()) {
					syrup.setVanilla(true);
				}
				if (rbCaramel.isSelected()) {
					syrup.setCaramel(true);
				}			
				if (rbSFVanilla.isSelected()) {
					syrup.setSFVanilla(true);
				}
				if (rbSFCaramel.isSelected()) {
					syrup.setSFCaramel(true);
				}
				if (rbNoSyrup.isSelected()) {
					syrup.setNoSyrup(true);
				}
				
				milkPrice = milk.getMilkPrice();
				syrupPrice = syrup.getSyrupTotal();
				
				// Gets the milk and syrup types and prices and prints them to the console
				System.out.println("Milk $: " + milk.getMilkPrice() + " "+ milk.getMilkType());
				System.out.println("Syrup $: " + syrup.getSyrupPrice() + " " + syrup.getSyrupType());
				
				// Set the next scene
				stage.setScene(confirmationScene);
				
			/* End Scene2 - flavorScene */
				
			/* Start Scene3 - endScene */	
				
				// Creates a new date format for the current time + the 10 minute wait
				String pattern = "hh:mm a";
		        DateFormat dateFormat = new SimpleDateFormat(pattern);
				Date time = new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)); // Add 10 minutes to the current time

				// Adds labels to the thank you message grid pane
				Label thanksLabel = new Label("Thank you, " + customer.getCustomerName() + "!");
				thanksLabel.setFont(new Font("Lato", 16));
				thanksGP.add(thanksLabel, 0, 0);
				Label timeLabel = new Label("Your order will be ready at " + dateFormat.format(time)); // Let the customer know when the order will be ready
				timeLabel.setFont(new Font("Lato", 16));
				thanksGP.add(timeLabel, 0, 1);
				thanksGP.setVgap(2);
				thanksGP.setAlignment(Pos.CENTER);
				GridPane.setHalignment(thanksLabel, HPos.CENTER);
			    
				// Adds the customer information details to the grid pane
				Label customerLabel = new Label("Your Information ");
				customerLabel.setFont(new Font("Lato", 16));
				customerGP.add(customerLabel, 0, 0);
				Label nameLabel = new Label("Name: " + customer.getCustomerName());
				nameLabel.setFont(new Font("Lato", 12));
				customerGP.add(nameLabel, 0, 1);
				Label phoneLabel = new Label("Phone: " + customer.getCustomerPhone());
				phoneLabel.setFont(new Font("Lato", 12));
				customerGP.add(phoneLabel, 0, 2);
				customerGP.setHgap(60);
				customerGP.setVgap(2);
				customerGP.setPrefWidth(200);
				
				// Creates labels and adds the order details to the grid pane
				Label orderLabel = new Label("Order Details ");
				orderLabel.setFont(new Font("Lato", 16));
				orderGP.add(orderLabel, 0, 0);
				Label drinkLbl = new Label(drinkChoice);
				drinkLbl.setFont(new Font("Lato", 12));
				orderGP.add(drinkLbl, 0, 1);
				Label milkLbl = new Label(milk.getMilkType());
				milkLbl.setFont(new Font("Lato", 12));
				orderGP.add(milkLbl, 0, 2);
				Label syrupLbl = new Label(syrup.getSyrupType());
				syrupLbl.setFont(new Font("Lato", 12));
				orderGP.add(syrupLbl, 0, 3);
				orderGP.setHgap(60);
				orderGP.setVgap(2);
				orderGP.setPrefWidth(200);
				orderGP.setPadding(new Insets(0, 0, 0, 50));
				
				// Calculates and formats the subtotal, tax, and order total
				subtotalPrice = drinkPrice + milkPrice + syrupPrice;
				subtotal = String.format ("%.2f", subtotalPrice); // Convert drink price to a string
				price.setSubtotal(subtotalPrice);
				tax = String.format("%.2f", price.getTax()); // Convert tax to a string
				total = String.format ("%.2f", price.getOrderTotal()); // Convert the total bill to a string
				
				// Adds labels for the drink subtotal, tax, and total to the grid pane
				Label subtotalLbl = new Label("Subtotal: $" + subtotal);
				subtotalLbl.setFont(new Font("Lato", 12));
				totalGP.add(subtotalLbl, 0, 4);
				Label taxLbl = new Label("Tax: $" + tax);
				taxLbl.setFont(new Font("Lato", 12));
				totalGP.add(taxLbl, 0, 6);
				Label totalLbl = new Label("Total: $" + total);
				totalLbl.setFont(new Font("Lato", 12));
				totalGP.add(totalLbl, 0, 7);
				totalGP.setHgap(60);
				totalGP.setVgap(2);
				totalGP.setPrefWidth(200);
				totalGP.setPadding(new Insets(0, 0, 0, 50));
			});
			
			// Creates a separator for the order details and order total
	        Separator separator2 = new Separator(Orientation.HORIZONTAL);
	        separator2.setMaxWidth(150);
	        separator2.setPadding(new Insets(10, 0, 0, 48));
			
	        // Creates a VBox for order summary details
			VBox summaryVBox = new VBox();
			summaryVBox.getChildren().addAll(orderGP, separator2, totalGP);			
			
			// Creates a separator for the customer's information and order details
	        Separator separator3 = new Separator(Orientation.VERTICAL);
	        separator3.setMaxHeight(175);
	        
	        // Creates an HBox for the customer's information, separator, and order details
	        HBox orderHB = new HBox();
	        orderHB.getChildren().addAll(customerGP, separator3, summaryVBox);
	        orderHB.setAlignment(Pos.CENTER);
			
			// Creates an image view for the logo
			ImageView imageView3 = new ImageView("image/logo3.png");
			imageView3.setFitWidth(400);
			imageView3.setPreserveRatio(true);
			
			// Creates an ImageView for the coffee house image
			ImageView houseImage = new ImageView("Image/shop2.jpg");
			houseImage.setFitWidth(500);
			houseImage.setPreserveRatio(true);
	        
			// Creates a VBox for the logo, coffee house image, thank you  message, and order confirmation details
			VBox confirmationVBox = new VBox(20);
			confirmationVBox.setStyle("-fx-background-color: white;");
			confirmationVBox.getChildren().addAll(imageView3, houseImage, thanksGP, thanksSep, orderHB);
			confirmationVBox.setPadding(new Insets(0, 40, 40, 40));
			confirmationVBox.setAlignment(Pos.CENTER);
			confirmationScene = new Scene(confirmationVBox, 700, 675);
			
		/* End Scene3 - endScene */
					
		// Creates a new scene and place it in the stage
		orderScene = new Scene(orderVBox, 700, 675);
		stage.setTitle("Silver Bay Coffee House");
		stage.setScene(orderScene);
		stage.show();
		}
	
	public void noName() { // Displays an error message when no name is entered
		Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		
		Button button = new Button("Ok");
		VBox vbox = new VBox(new Label("Please enter a valid name."), button); // Prompts user for a valid name
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(15));

		dialogStage.setScene(new Scene(vbox));
		dialogStage.show();
		tfName.requestFocus(); // Requests that this node gets the input focus when the name is invalid
		
		button.setOnAction(e -> {
			dialogStage.close(); // Closes the error message
		});
	}
	
	public void noPhone() { // Displays error message when no phone is entered
		Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		
		Button button = new Button("Ok");
		VBox vbox = new VBox(new Label("Please enter a valid phone number (XXX-XXX-XXXX)."), button); // Prompts user for a valid phone number
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(15));

		dialogStage.setScene(new Scene(vbox));
		dialogStage.show();
		tfPhone.requestFocus(); // Requests that this node gets the input focus when the phone number is invalid
		
		button.setOnAction(e -> {
			dialogStage.close(); // Closes the error message
		});
	}

	public static void main(String[] args) {
		launch(args);	
	}
}
