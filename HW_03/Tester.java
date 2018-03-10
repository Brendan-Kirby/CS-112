/* Tester.java - tracks information about coin entered into a piggybank
 * Author: Brendan Kirby
 * Module: 4
 * Project: 1
 * Problem Statement: This class tests the functionality of exception handling using custom exceptions defined
 * 					  in CoinNameException and CoinValueException classes.
 * 
 * Algorithm:
 * 
 * WHILE notFinished
 * 
 *		ASSIGN needsContinueInput = true
 * 		
 * 		WHILE nameNotValid
 * 
 * 			TRY
 * 				READ nameResponse
 * 			CATCH
 * 				errorCounter++
 * 				THROW CoinNameException
 * 
 * 			IF errorCounter >= 2 THEN
 * 				EXIT
 * 			END IF
 * 
 * 		END WHILE
 * 
 * 
 * 		ASSIGN errorCounter = 0
 * 
 * 
 * 		WHILE valueNotValid	
 * 
 * 			TRY
 * 				READ valueResponse
 * 			CATCH
 * 				errorCounter++
 * 				THROW CoinValueException
 * 
 * 			IF errorCounter >= 2 THEN
 * 				EXIT
 * 			END IF
 * 
 * 		END WHILE
 * 
 * 
 * 		ASSIGN errorCounter = 0
 * 
 * 
 * 		WHILE needsContinueInput
 * 
 * 			READ continueResponse
 * 			
 * 			SWITCH continueResponse
 * 				
 * 				CASE 'Y':
 * 				CASE 'y':
 * 					ASSIGN	notFinished = true
 *					ASSIGN	nameNotValid = true
 *					ASSIGN	valueNotValid = true
 *					ASSIGN	needsContinueInput = false
 * 					BREAK
 * 				CASE 'N':
 * 				CASE 'n":
 * 					ASSIGN notFinished = false
 * 					ASSIGN needsContinueInput = false
 * 					BREAK
 * 				DEFAULT:
 * 					ASSIGN needsContinueInput = true
 * 					BREAK
 * 			END SWITCH
 * 
 * 		END WHILE
 * 
 * END WHILE
*/

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		//declaration & initialization
		String coinNamePrompt = "Enter the name of a coin : ";
		String coinValuePrompt = "Enter the value of that coin in cents : ";
		String continuePrompt = "Do you have another coin to enter? <y/n> : ";
		String continuePromptError = "Invalid input, try again. Valid inputs are \"y\" for yes, and \"n\" for no.";
		String nameResponse = "x";
		String continueResponse = "x";
		String lineFormat = "%1s" + "%8d" + "%2s" + "%8d" + "%2s" + "%6d" + "%2s" + "%9d" + "%2s" + "%13d" + "%2s" + "%5s" + "%7.2f" + "%3s";
		char charResponse = 'x';
		int valueResponse = 0;
		int valueSum = 0;
		int numPennies = 0;
		int numNickels = 0;
		int numDimes = 0;
		int numQuarters = 0;
		int numHalfDollars = 0;
		int errorCounter = 0;
		double total = 0.00;
		Scanner key = new Scanner(System.in);
		boolean nameNotValid = true;
		boolean valueNotValid = true;
		boolean notFinished = true;
		boolean needsContinueInput = true;
		
		//processing
		while (notFinished) {
			
			needsContinueInput = true;	
				
			while (nameNotValid) { //get coin name from the user, increment appropriate counter
				try {
					
					//input for coin name
					System.out.print(coinNamePrompt);
					nameResponse = key.next();
					
					if (nameResponse.equalsIgnoreCase("Penny")) {
					
						numPennies++;
						nameNotValid = false;
					}
					else if	(nameResponse.equalsIgnoreCase("Nickel")) {
					
						numNickels++;
						nameNotValid = false;	
					}
					else if (nameResponse.equalsIgnoreCase("Dime")) {
					
						numDimes++;
						nameNotValid = false;	
					}	
					else if (nameResponse.equalsIgnoreCase("Quarter")) {
					
						numQuarters++;
						nameNotValid = false;
					}
					else if (nameResponse.equalsIgnoreCase("Half-Dollar")) {
					
						numHalfDollars++;
						nameNotValid = false;
					}		
					else { //coin name entered was not a valid coin name
						
						throw new CoinNameException();
					}				
				}
				catch (CoinNameException e) {
					
					errorCounter++;
					nameNotValid = true;
				}
				
				//tracking input errors by the user
				if (errorCounter >= 2) {
					
					System.out.println("Maximum number of errors exceeded, exiting . . .\n");
					System.exit(0);
				}		
			}
			
			//resets error tracking to 0 for the next process
			errorCounter = 0;
			
			while (valueNotValid) { //get coin value from the user, check that it matches the coin name and 
									//increment the running total by the value entered if it does
				try {
					
					//input for coin value
					System.out.print(coinValuePrompt);
					valueResponse = key.nextInt();
					
					switch (valueResponse) {
						
						
						case 1: //matches value of penny
							if (nameResponse.equalsIgnoreCase("Penny")) {
				
							valueSum += 1;
							valueNotValid = false;
							}
							else { //coin was not a penny
								
								throw new CoinValueException();
							}	
							break;
						 	
						case 5: //matches value of nickel	
							if (nameResponse.equalsIgnoreCase("Nickel")) {
				
							valueSum += 5;
							valueNotValid = false;
							}
							else { //coin was not a nickel
							
								throw new CoinValueException();
							}	
							break;	
							
						case 10: //matches value of dime
							if (nameResponse.equalsIgnoreCase("Dime")) {
				
							valueSum += 10;
							valueNotValid = false;
							}
							else { //coin was not a dime
							
								throw new CoinValueException();
							}	
							break;
							
						case 25: //matches value of quarter
							if (nameResponse.equalsIgnoreCase("Quarter")) {
				
							valueSum += 25;
							valueNotValid = false;
							}
							else { //coin was not a quarter
							
								throw new CoinValueException();
							}	
							break;
						
						case 50: //matches value of half-dollar	
							if (nameResponse.equalsIgnoreCase("Half-Dollar")) {
				
							valueSum += 50;
							valueNotValid = false;
							}
							else { //coin was not a half-dollar
							
								throw new CoinValueException();
							}	
							break;
						default: //value entered is not a valid case for any of the possible coins
							valueNotValid = true;
							throw new CoinValueException();
					}
				}			
				catch (CoinValueException e) {
					
					errorCounter++;
					valueNotValid = true;
				}	
				
				if (errorCounter >= 2) {
				
					System.out.println("Maximum number of errors exceeded, exiting . . .\n");
					System.exit(0);
				}						
			}
			
			//resets error tracking to 0 for the next iteration of the two preceding input loops
			errorCounter = 0;
			
			while (needsContinueInput) { //check to see if the user has another coin to enter into the system
			
				System.out.print(continuePrompt);
				continueResponse = key.next();
				System.out.print("\n\n");
				
				switch (continueResponse.charAt(0)) {
				
					case 'Y': //user has another coin to enter
					case 'y':
						notFinished = true;
						nameNotValid = true;
						valueNotValid = true;
						needsContinueInput = false;
						break;
					case 'N': //user is done entering coins, ready to print table	
					case 'n':
						notFinished = false;
						needsContinueInput = false;
						break;
					default: //user entered invalid answer to the continue prompt
						System.out.println(continuePromptError);
						needsContinueInput = true;
						break; 
				}	
			}		
		}
		
		total = valueSum / 100.00;
		
		//output
		System.out.print("|-------------------------------------------------------------------|\n");
		System.out.print("| Pennies | Nickels | Dimes | Quarters | Half-Dollars | Total Value |\n");
		System.out.print("|---------|---------|-------|----------|--------------|-------------|\n");
		System.out.printf(lineFormat, "|", numPennies, "|", numNickels, "|", numDimes, "|", numQuarters, "|", numHalfDollars, "|", "$",total, "|\n");
		System.out.print("|-------------------------------------------------------------------|");
				
	}
}
