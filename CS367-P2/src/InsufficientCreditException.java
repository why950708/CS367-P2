///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (name of main application class)
// File:             (name of this class's file)
// Semester:         CS302 Spring 2015
//
// Author:           (your name and email address)
// CS Login:         (your login name)
// Lecturer's Name:  (name of your lecturer)
// Lab Section:      (your lab section number)
//
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
	
	
}
