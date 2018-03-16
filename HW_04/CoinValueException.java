/* CoinValueException.java - Defines an exception class to be thrown when an 
 * 			    			 invalid coin value is entered.
 * 
 * Author:  Brendan Kirby
 * Module:  04
 * Project: 1
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

public class CoinValueException extends Exception {

	//default constant
	private static String DEFAULT_MESSAGE = "\n\nCoin identity did not match coin value, try again.\n\n";

	//default constructor
	public CoinValueException() {
		
		super(DEFAULT_MESSAGE);
		
	}
	
	//full constructor
	public CoinValueException(String valueError) {
	
		super(valueError);	
	
	}
}
