///////////////////////////////////////////////////////////////////////////////

//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P2)
// Files:            (DLinkedList.java, InsufficientCreditException.java, ListADT.java, Listnode.java, User.java, Products.java)
// Semester:         CS367 Spring 2015
//
// Author:           (Chenyuan Zhang)
// Email:            (czhang356@wisc.edu)
// CS Login:         (chenyuan)
// Lecturer's Name:  (Jim)
// Lab Section:      no
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                   If pair programming is allowed:
//                   1. Read PAIR-PROGRAMMING policy (in cs302 policy) 
//                   2. choose a partner wisely
//                   3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER 
//                      a. one partner creates the team
//                      b. the other partner must join the team
//                   4. complete this section for each program file.
//
// Pair Partner:     (Hongyi Wang)
// Email:            (hongyi.wang@wisc.edi)
// CS Login:         (hongyi)
// Lecturer's Name:  (Jim)
// Lab Section:      no
//
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AmazonStore {

	// Store record of users and products
	private static ListADT<Product> products = new DLinkedList<Product>();
	private static ListADT<User> users = new DLinkedList<User>();
	private static User currentUser = null;// current user logged in
	private static ListADT<String> category = new DLinkedList<String>();

	// scanner for console input
	public static final Scanner stdin = new Scanner(System.in);

	// main method
	public static void main(String args[]) throws FileNotFoundException {

		// Populate the two lists using the input files: Products.txt User1.txt
		// User2.txt ... UserN.txt
		if (args.length < 2) {
			System.out
					.println("Usage: java AmazonStore [PRODUCT_FILE] [USER1_FILE] [USER2_FILE] ...");
			System.exit(0);
		}

		// load store products
		loadProducts(args[0]);

		// load users one file at a time
		for (int i = 1; i < args.length; i++)
			loadUser(args[i]);

		// User Input for login
		boolean done = false;
		while (!done) {
			System.out.print("Enter username : ");
			String username = stdin.nextLine();
			System.out.print("Enter password : ");
			String passwd = stdin.nextLine();

			if (login(username, passwd) != null) {
				// generate random items in stock based on this user's wish list
				ListADT<Product> inStock = currentUser.generateStock();
				// show user menu
				userMenu(inStock);
			} else
				System.out.println("Incorrect username or password");

			System.out
					.println("Enter 'exit' to exit program or anything else to go back to login");
			if (stdin.nextLine().equals("exit"))
				done = true;
		}

	}

	/**
	 * Tries to login for the given credentials. Updates the currentUser if
	 * successful login
	 * 
	 * @param username
	 *            name of user
	 * @param passwd
	 *            password of user
	 * @returns the currentUser
	 */
	public static User login(String username, String passwd) {
		// search the user list
		for (int i = 0; i < users.size(); i++) {
			// return the user if there is a match
			if (users.get(i).checkLogin(username, passwd) == true) {
				// update the current user
				currentUser = users.get(i);
				return users.get(i);
			}
		}
		return null;
	}

	/**
	 * Reads the specified file to create and load products into the store.
	 * Every line in the file has the format: <NAME>#<CATEGORY>#<PRICE>#<RATING>
	 * Create new products based on the attributes specified in each line and
	 * insert them into the products list Order of products list should be the
	 * same as the products in the file For any problem in reading the file
	 * print: 'Error: Cannot access file'
	 * 
	 * @param fileName
	 *            name of the file to read
	 */
	public static void loadProducts(String fileName)
			throws FileNotFoundException {
		// create file
		File fileProducts = new File(fileName);
		// create scanner for the product file
		Scanner scanProducts = new Scanner(fileProducts);
		// read these files
		while (scanProducts.hasNextLine()) {
			String[] productInfo = scanProducts.nextLine().split("#");
			// create product objects
			Product myproduct = new Product(productInfo[0], productInfo[1],
					Integer.parseInt(productInfo[2]),
					Float.parseFloat(productInfo[3]));
			// System.out.println(myproduct.getName());
			// add them to product list
			products.add(myproduct);
		}
	}

	/**
	 * Reads the specified file to create and load a user into the store. The
	 * first line in the file has the format:<NAME>#<PASSWORD>#<CREDIT> Every
	 * other line after that is a name of a product in the user's wishlist,
	 * format:<NAME> For any problem in reading the file print: 'Error: Cannot
	 * access file'
	 * 
	 * @param fileName
	 *            name of the file to read
	 */
	public static void loadUser(String fileName) throws FileNotFoundException {
		File fileUser = new File(fileName);
		Scanner scanUser = new Scanner(fileUser);
		// read user info
		String[] userInfo = scanUser.nextLine().split("#");
		// create user object
		User newUser = new User(userInfo[0], userInfo[1],
				Integer.parseInt(userInfo[2]));
		// add the user to the user list
		users.add(newUser);
		// read user wish list
		while (scanUser.hasNextLine()) {
			String buf = scanUser.nextLine();

			
			for (int i = 0; i < products.size(); i++) {
				// add them to the wish list

				if (buf.equals(products.get(i).getName()))
					newUser.addToWishList(products.get(i));
			}

		}
	}

	/**
	 * See sample outputs Prints the entire store inventory formatted by
	 * category The input text file for products is already grouped by category,
	 * use the same order as given in the text file format: <CATEGORY1> <NAME>
	 * [Price:$<PRICE> Rating:<RATING> stars] ... <NAME> [Price:$<PRICE>
	 * Rating:<RATING> stars]
	 * 
	 * <CATEGORY2> <NAME> [Price:$<PRICE> Rating:<RATING> stars] ... <NAME>
	 * [Price:$<PRICE> Rating:<RATING> stars]
	 */
	public static void printByCategory() {
		
		// get all products categories
		for (int i = 0; i < products.size(); i++)
			{boolean ctrl=true;
			for(int j=0;j<category.size();j++)
				
			{if(category.get(j).equals(products.get(i).getCategory()))
				ctrl=false;
			}
			if(ctrl==true)
			{category.add(products.get(i).getCategory());}
			}
		
		// print out products info according to categories
		for (int i = 0; i < category.size(); i++) {
			int productCategory = 1;// a variable to insure print out
			if (productCategory == 1)
				System.out.println(category.get(i).toString());
			
			for (int m = 0; m < products.size(); m++) {
				// category only once
				if (products.get(m).getCategory().equals(category.get(i))) {
					displayProductsInfo(products.get(m));
					productCategory = 0;// update so that we dont print out the
										// same category
				}
			}
			System.out.println("");
			
		}

	}





	/**
	 * Interacts with the user by processing commands
	 * 
	 * @param inStock
	 *            list of products that are in stock
	 */
	public static void userMenu(ListADT<Product> inStock) {

		boolean done = false;
		while (!done) {
			System.out.print("Enter option : ");
			String input = stdin.nextLine();

			// only do something if the user enters at least one character
			if (input.length() > 0) {
				String[] commands = input.split(":");// split on colon, because
														// names have spaces in
														// them
				if (commands[0].length() > 1) {
					System.out.println("Invalid Command");
					continue;
				}
				switch (commands[0].charAt(0)) {
				case 'v':
					commandV(commands, inStock);
					break;

				case 's':
					commandS(commands);
					break;

				case 'a':
					commandA(commands);
					break;

				case 'r':
					commandR(commands);
					break;

				case 'b':
					commandB(inStock);
					break;

				case 'c':
					commandC();
					break;

				case 'l':
					done = true;
					currentUser=null;
					System.out.println("Logged Out");

					break;

				default: // a command with no argument
					System.out.println("Invalid Command");
					break;
				}
			}
		}
	}

	/**
	 * display the price, rating, name of the product
	 */
	private static void displayProductsInfo(Product product) {
		System.out.println(product.getName() + " [Price:$" + product.getPrice()
				+ " Rating:" + product.getRating() + " stars]");

	}

	static void commandV(String[] para, ListADT<Product> inStock) {// when
																	// command
																	// is all

		if (para[1].equals("all")) {
			printByCategory();
			return;
		}
		// when command is wishlist
		if (para[1].equals("wishlist")) {
			currentUser.printWishList(System.out);
			return;
		}
		// when command is instock
		if (para[1].equals("instock")) {

			for (int i = 0; i < inStock.size(); i++)
				System.out.println(inStock.get(i));
			return;
		}

		// when command is other stuff set the output Invalid Command
		System.out.println("Invalid Command");

	}

	static void commandS(String[] para) {
		// search the product list
		for (int i = 0; i < products.size(); i++) {
			// if there is a match, print out the product info
			if (products.get(i).getName().contains(para[1]))
				displayProductsInfo(products.get(i));

		}
	}

	static void commandA(String[] para) {
		// search the product list
		for (int i = 0; i < products.size(); i++) {
			// add this product to the user's wish list
			if (para[1].equals(products.get(i).getName())) {
				currentUser.addToWishList(products.get(i));
				System.out.println("Added to wishlist");
				return;
			}
		}
		// display error message if there is not a match
		System.out.println("Product not found");
	}

	static void commandR(String[] para) {
		
		if( currentUser.removeFromWishList(para[1])==null)
		{
			System.out.println("Product not found");
		}
		else{
			System.out.println("Removed from wishlist");
		}
	}

	static void commandB(ListADT<Product> inStock) {
		for (int i = 0; i < inStock.size(); i++) {
			try {
				currentUser.buy(inStock.get(i).getName());
				System.out.println("Bought " + inStock.get(i).getName());
			} catch (InsufficientCreditException ex) {
				System.out.println("Insufficient funds for "
						+ inStock.get(i).getName());
			}

		}
	}

	static void commandC()

	{
		System.out.println("$" + currentUser.getCredit());
	}

	


}
