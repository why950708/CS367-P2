///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (AmazonStore.java)
// File:             (Product.java)
// Semester:         CS367 Spring 2015
//
// Author:           (Hongyi Wang)
// CS Login:         (hongyi)
// Lecturer's Name:  (Jim)
// Lab Section:      (your lab section number)
//
/**
 * Stores the name, category, price and rating of a product
 */
public class Product {
	
	private String name;
	private String category;
	private int price;
	private float rating;
	
	/**
     * Constructs a Product with a name, category, price and rating. 
     * 
     * @param name name of product
     * @param category category of product
     * @param price price of product in $ 
     * @param rating rating of product out of 5
     */
	public Product(String name, String category, int price, float rating){
		this.name=name;
		this.category=category;
		this.price=price;
		this.rating=rating;
	}
	
	/** 
     * Returns the name of the product
     * @return the name
     */
	public String getName(){
		String buf=name;
		return buf;
	}
	
	/** 
     * Returns the category of the product
     * @return the category
     */
	public String getCategory(){
		String buf=category;
		return buf;
	}
	
	/** 
     * Returns the price of the product
     * @return the price
     */
	public int getPrice(){
		int buf=price;
		return buf;
	}
	
	/** 
     * Returns the rating of the product
     * @return the rating
     */
	public float getRating(){
		float buf=rating;
		return buf;
	}
	
	/** 
     * Returns the Product's information in the following format: <NAME> [Price:$<PRICE> Rating:<RATING> stars]
     */
	public String toString(){
		return name+ "[Price:$"+price+" Rating:"+rating+"stars]";
	}

}
