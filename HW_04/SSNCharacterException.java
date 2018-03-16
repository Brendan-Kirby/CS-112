/* SSNCharacterException.java - Defines an exception class to be thrown when a 
 * 								SSN is attempted to be set to a value containing
 * 								data other than only integers.
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

public class SSNCharacterException extends Exception {
	
	private static final String DEFAULT_MESSAGE = "Error - SSN must only contain integers - Try again . . .";	

	public SSNCharacterException() {
	
		super(DEFAULT_MESSAGE);
	}	
	
	public SSNCharacterException(String message) {
	
		super(message);
	}	

}
