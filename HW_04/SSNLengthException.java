/* SSNLengthException.java - Defines an exception class to be thrown when a 
 * 							 SSN is attempted to be set equal to a sequence of
 * 							 fewer or more than exactly 9 characters.
 * 
 * Author:  Brendan Kirby
 * Module:  04
 * Project: 3
 * 
 * Description
 * 
 * 		Constants
 * 			DEFAULT_MESSAGE (String) - contains the default message for this 
 * 									   exception object when thrown.
 * 		Instance Variables
 * 			None
 * 		Methods
 * 			default constructor - calls super with DEFAULT_MESSAGE as its 
 * 								  sole parameter.
 * 			full constructor - takes message as a parameter, calls super with
 * 							   the argument given.
 */ 

public class SSNLengthException extends Exception {
	
	private static final String DEFAULT_MESSAGE = "Error - SSN length did not equal 9 - Try again . . .";

	public SSNLengthException() {
	
		super(DEFAULT_MESSAGE);
	}
	
	public SSNLengthException(String message) {
	
		super(message);
	}		

}
