/* CoinNameException.java - Defines an exception class to be thrown when an 
 * 							invalid coin name is entered.
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

public class CoinNameException extends Exception {

	//default constant
	private static final String DEFAULT_MESSAGE = "\n\nInvalid coin name, try again. Valid coin names are : \n" +
												  "* Penny\n" +
												  "* Nickel\n" +
												  "* Dime\n" +
												  "* Quarter\n" +
												  "* Half-Dollar\n\n";
	
	//default constructor
	public CoinNameException() {
	
		super(DEFAULT_MESSAGE);
			
	}
	
	//full constructor
	public CoinNameException(String nameError) {
		
		super(nameError);
	}
}
