/* DivideByZeroException.java - Defines an exception class to be thrown when a 
 * 								denominator of zero is entered in a division
 * 								expression.
 * 
 * Author:  Brendan Kirby
 * Module:  04
 * Project: 2
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

public class DivideByZeroException extends Exception { 

	private static final String DEFAULT_MESSAGE = "Error - Attempted division by zero";

	public DivideByZeroException() {
	
		super(DEFAULT_MESSAGE);
	}
	
	public DivideByZeroException(String message) {
	
		super(message);
	}
}
