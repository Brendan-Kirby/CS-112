/* InvalidSalaryException.java - Defines an exception class to be thrown when a 
 * 						 		 salary is attempted to be set to a negative
 * 								 number.
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

public class InvalidSalaryException extends Exception {
	
	private static final String DEFAULT_MESSAGE = "Error - Salary is not allowed to be negative - Try again . . .";

	public InvalidSalaryException() {
	
		super(DEFAULT_MESSAGE);
	}
	
	public InvalidSalaryException(String message) {
	
		super(message);
	}

}
