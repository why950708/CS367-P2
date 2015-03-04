public class InsufficientCreditException extends Exception {
	
	private static String message = null;
	
	/**		constructor			**/
	public InsufficientCreditException(){
		super();
		message = "User does not have enough credits";
	}
	
	/**		getter methods		**/
	
	public String getMessage(){
		return message;
	}
	
	@Override
	public String toString(){
		return this.getMessage();
	}
	
}
