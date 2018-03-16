/* CalcDriver.java - Defines a class which provides the input framework to a
 * 					 calculator object it needs in order to do arithmetic
 * 					 operations for the user.
 * 
 * Author:  Brendan Kirby
 * Module:  04
 * Project: 2
 * 
 * Algorithm:
 * 
 * Print activation message
 * 
 * WHILE calculator is on
 * 		
 * 		Print the current result of all previous calculations
 * 		Prompt the user to enter an operator followed by a number
 * 		Read response
 * 			- Can throw UnknownOperatorException and NumberFormatException
 * 				+ If caught, set canProceed to false.
 * 		
 * 		Perform the operation the operator indicated
 * 			'+' will call the calculator's add(double) method with the read number
 * 				as its argument.
 * 			'-' will call the calculator's subtract(double) method with the read number
 * 				as its argument.
 * 			'*' will call the calculator's multiply(double) method with the read number
 * 				as its argument.
 * 			'/' will call the calculator's divide(double) method with the read number
 * 				as its argument.
 * 			'r' or 'R' will reset both the previous result and current entry to 0.0
 * 			'p' or 'P' will turn the calculator off and end the program
 * 
 * 			- Can throw DivideByZeroException and StringIndexOutOfBoundsException
 * 				+ If caught, set canProceed to false.  	
 * 
 * 		IF canProceed is true and the operator was not 'r', 'R', 'p', or 'P' THEN
 * 			Print the result of the executed calculation with the previous result,
 * 			operator, and current entry.
 * END WHILE		
 * 
 * Exit program
 */ 

import java.util.Scanner;

public class CalcDriver {

	public static void main(String[] args) {
	
		//declaration and initialization / instantiation
		Calculator calc = new Calculator();
		char operatorResponse = ' ';
		double numberResponse = 0.0;
		boolean canProceed = true;
		boolean divisionFlag = false;
		Scanner reader = new Scanner(System.in);
		String response = "";
		String postCalc = "";
		String activationMessage = "Your calculator is now on.";
		String prompt = "[Enter R to reset or P to shut down]\nEnter an operator (+, -, *, or /) followed by a number: ";
		String badChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
						  "abcdefghijklmnopqrstuvwxyz";
				
		System.out.println(activationMessage + "\n\n");	
		
		//prompting for and performing calculations based on checked user input
		while (calc.isActivated()) {
			
			canProceed = true;
			System.out.println("Current result : " + calc.getCurrentEntry());	
			System.out.print(prompt);
			response = reader.nextLine();	
			operatorResponse = response.charAt(0);	
			
			//catches DivideByZeroException, StringIndexOutOfBoundsException
			try {
				//catches NumberFormatException
				try {
					//catches UnknownOperatorException
					try {
						
						operatorResponse = response.charAt(0);
						
						//throws UnknownOperatorException if invalid operator is entered
						if (operatorResponse != '+' &&
							operatorResponse != '-' &&
							operatorResponse != '*' &&
							operatorResponse != '/' &&
							operatorResponse != 'r' &&
							operatorResponse != 'R' &&
							operatorResponse != 'p' &&
							operatorResponse != 'P') {	
							
							throw new UnknownOperatorException();
						}		
					}
					catch (UnknownOperatorException e) {
						
						canProceed = false;
						System.out.println(e.getMessage());
					}		
					
					//throws NumberFormatException if any letters beside p and
					//r are found in response string
					for (int i = 1; i < response.length(); i++) {
					
						for (int j = 0; j < badChars.length(); j++) {
							
							if (response.charAt(i) == badChars.charAt(i)) {
									
								throw new NumberFormatException();	
							}
						}			
					}	
					
					//will only try to assign numberResponse if the response was long enough
					//to contain a number to assign
					if (response.length() > 1) {
						
						numberResponse = Double.parseDouble(response.substring(1, response.length()));
					}	
				}
				catch (NumberFormatException e) {
					
					canProceed = false;
					e = new NumberFormatException("Error - Unable to parse number after operator");
					System.out.println(e.getMessage());
				}		
				
				//will only attempt calculations if operator is known and the
				//number following the operator was correctly recognized
				if (canProceed) {
					switch (operatorResponse) {
					
						case '+':
							calc.add(numberResponse);
							break;
						case '-':
							calc.subtract(numberResponse);
							break;
						case '*':
							calc.multiply(numberResponse);
							break;
						case '/':
							calc.divide(numberResponse);
							break;
						case 'R':
						case 'r':
							calc.setPreviousResult(0.0);
							calc.setCurrentEntry(0.0);
							System.out.println("Resetting . . .");
							break;
						case 'P':
						case 'p':
							System.out.println("Shutting down . . .");
							calc.setActivated(false);
							break;
						default:
							canProceed = false;
							break;
					}
				}			
				
			}	
			catch (DivideByZeroException e) {
				
				canProceed = false;
				System.out.println(e.getMessage());
			}
			catch (StringIndexOutOfBoundsException e) {
					
				canProceed = false;
				e = new StringIndexOutOfBoundsException("Error - input too large");
				System.out.println(e.getMessage());	
			}	
			
			//only prints calculation result if operator warranted a calculation
			if (!((operatorResponse == 'r' || operatorResponse == 'R')  ||
				  (operatorResponse == 'p' || operatorResponse == 'P')) &&
				  canProceed) {
				
				postCalc = calc.getPreviousResult() + " " + 
						   operatorResponse + " " + 
						   numberResponse + " = " + 
						   calc.getCurrentEntry();
				
				System.out.println(postCalc);	  
			}		  		
			
			System.out.print("\n\n");
							
		}
		
		System.exit(0);
	}
}
