/* UnknownOperatorException.java - Defines an exception class to be thrown when an 
 * 								   invalid operator is entered.
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

public class UnknownOperatorException extends Exception {
	
	private static final String DEFAULT_MESSAGE = "Error - Unknown Operator"; 

	public UnknownOperatorException() {
	
		super(DEFAULT_MESSAGE);
	}
	
	public UnknownOperatorException(String message) {
	
		super(message);
	}
}
