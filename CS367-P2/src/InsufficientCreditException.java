public class InsufficientCreditException extends Exception {
	
	private static String message = null;
	
	/**		constructor			**/
	public InsufficientCreditException( String message){
		super(message);
		this.message = message;
	}
	public InsufficientCreditException(){
		super();
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
