/* Tester.java - Tests functionality of custom exceptions as defined in
 * 		 CoinNameException and CoinValueException classes with
 * 		 a simulation of a piggy bank.
 * 
 * Author:  Brendan Kirby
 * Module:  04
 * Project: 1
 * 
 * Algorithm:
 * 
 * WHILE not finished
 * 
 * 		Prompt user to enter the name of a coin
 * 		Read response
 * 			- Can throw CoinNameException
 * 				+ If thrown, increment error count and try again
 * 
 * 		Reset error count to zero
 * 
 * 		Prompt user to enter the value of the named coin
 * 		Read response
 * 			- Can throw CoinValueException
 * 				+ If thrown, increment error count and try again
 * 		Increment running total by the value of the coin entered
 * 		
 *		Prompt user to enter whether they have another coin to enter
 * 			- If they do, set not finished to true
 * 			- If they do not, set not finished to false
 * END WHILE
 * 
 * Print table with number of each coin entered, along with the total value of
 * all coins entered
 * 
 * Exit program
 * 
 */
 
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Tester {

	public static void main(String[] args) {
	
		//Declaration & initialization / instantiation
		String coinNamePrompt = "Enter the name of a coin : ";
		String coinValuePrompt = "Enter the value of that coin in cents : ";
		String continuePrompt = "Do you have another coin to enter? <y/n> : ";
		String continuePromptError = "Invalid input, try again. Valid inputs are \"y\" for yes, and \"n\" for no.";
		String nameResponse = "x";
		String continueResponse = "x";
		char charResponse = 'x';
		String lineFormat = "%-2s" + "%7d" + "%-1s" + "%10d" + "%-1s" + "%8d" + "%-1s" + "%11d" + "%-1s" + "%15d" + "%-1s" + "%14.2f" + "%-1s";
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
		
		//Getting user data on coins
		while (notFinished) {
			
			needsContinueInput = true;	
			
			//checking validity of coin name	
			while (nameNotValid) {
				try {
					
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
					else {
						
						throw new CoinNameException();
					}				
				}
				catch (CoinNameException e) {
					
					System.out.println(e.getMessage());
					errorCounter++;
					nameNotValid = true;
				}
				
				if (errorCounter >= 2) {
					
					System.out.println("Too many errors, exiting . . . \n");
					System.exit(0);
				}		
			}
			
			//reset error count
			errorCounter = 0;
			
			//checking validity of coin value entered, according to validated 
			//coin name
			while (valueNotValid) {
				try {
					
					System.out.print(coinValuePrompt);
					valueResponse = key.nextInt();
					
					switch (valueResponse) {
					
						case 1:
							if (nameResponse.equalsIgnoreCase("Penny")) {
				
							valueSum += 1;
							valueNotValid = false;
							}
							else {
							
								throw new CoinValueException();
							}	
							break;	
						case 5:
							if (nameResponse.equalsIgnoreCase("Nickel")) {
				
							valueSum += 5;
							valueNotValid = false;
							}
							else {
							
								throw new CoinValueException();
							}	
							break;	
						case 10:
							if (nameResponse.equalsIgnoreCase("Dime")) {
				
							valueSum += 10;
							valueNotValid = false;
							}
							else {
							
								throw new CoinValueException();
							}	
							break;
						case 25:
							if (nameResponse.equalsIgnoreCase("Quarter")) {
				
							valueSum += 25;
							valueNotValid = false;
							}
							else {
							
								throw new CoinValueException();
							}	
							break;
						case 50:
							if (nameResponse.equalsIgnoreCase("Half-Dollar")) {
				
							valueSum += 50;
							valueNotValid = false;
							}
							else {
							
								throw new CoinValueException();
							}	
							break;
						default:
							valueNotValid = true;
							throw new CoinValueException();
					}
				}			
				catch (CoinValueException e) {
					
					System.out.println(e.getMessage());
					errorCounter++;
					valueNotValid = true;
				}
				catch (InputMismatchException e) {
					
					e = new InputMismatchException("Invalid value - try again");
					System.out.println(e.getMessage());
					errorCounter++;
					valueNotValid = true;
				}
				catch (NoSuchElementException e) {
					
					e = new NoSuchElementException("Invalid value - try again");
					System.out.println(e.getMessage());
					errorCounter++;
					valueNotValid = true;
				}
				catch (IllegalStateException e) {
					
					e = new IllegalStateException("Invalid value - try again");
					System.out.println(e.getMessage());
					errorCounter++;
					valueNotValid = true;
				}				
				
				if (errorCounter >= 2) {
					
					System.out.println("Too many errors, exiting . . . \n");
					System.exit(0);
				}						
			}
			
			//reset error counter
			errorCounter = 0;
			
			//error checking input on whether the user has more coins to enter
			while (needsContinueInput) {
			
				System.out.print(continuePrompt);
				continueResponse = key.next();
				System.out.print("\n\n");
				
				switch (continueResponse.charAt(0)) {
				
					case 'Y':
					case 'y':
						notFinished = true;
						nameNotValid = true;
						valueNotValid = true;
						needsContinueInput = false;
						break;
					case 'N':
					case 'n':
						notFinished = false;
						needsContinueInput = false;
						break;
					default:
						System.out.println(continuePromptError);
						needsContinueInput = true;
						break;
				 
				}	
			}		
		}
		
		//convert total in cents to a value in the more standard dollar notation
		total = valueSum / 100.00;
		
		//formatting and output of table to the console
		lineFormat = "%1s" + "%8d" + "%2s" + "%8d" + "%2s" + "%6d" + "%2s" + "%9d" + "%2s" + "%13d" + "%2s" + "%8s" + "%5.2f" + "%1s";
		
		System.out.print("|---------|---------|-------|----------|--------------|-------------|\n");
		System.out.print("| Pennies | Nickels | Dimes | Quarters | Half-Dollars | Total Value |\n");
		System.out.print("|---------|---------|-------|----------|--------------|-------------|\n");
		System.out.printf(lineFormat, "|", numPennies, "|", numNickels, "|", numDimes, "|", numQuarters, "|", numHalfDollars, "|", "$ ", total, "|\n");
		System.out.print("|---------|---------|-------|----------|--------------|-------------|");
		
		System.out.print("\n\n");
				
	}
}
