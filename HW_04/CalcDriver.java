import java.util.Scanner;

public class CalcDriver {

	public static void main(String[] args) {
	
		Calculator calc = new Calculator();
		char operatorResponse = ' ';
		double numberResponse = 0.0;
		Scanner reader = new Scanner(System.in);
		String response = "";
		String postCalc = "";
		String activationMessage = "Your calculator is now on.";
		String prompt = "Enter an operator (+, -, *, or /) followed by a number : ";
				
		System.out.println(activationMessage + "\n\n");	
		
		while (calc.isActivated()) {
			
			System.out.println("Current result : " + calc.getCurrentEntry());	
			System.out.print(prompt);
			response = reader.nextLine();
			
			operatorResponse = response.charAt(0);
			
			if (response.length() > 1) {
				numberResponse = Double.parseDouble(response.substring(1, response.length()));	
			}	
			
			try {
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
						throw new UnknownOperatorException();
				}
				
				postCalc = "Result of " + calc.getPreviousResult() + 
						   " " + operatorResponse + 
						   " " + numberResponse + 
						   "  = " + calc.getCurrentEntry();
				
				if (!(response.equalsIgnoreCase("p") || response.equalsIgnoreCase("r"))) {
						   
					System.out.println(postCalc);
				}	
			}
			catch (UnknownOperatorException e) {
				
			}
			catch (DivideByZeroException e) {
				
			}	
			catch (NumberFormatException e) {
				
			}
			
			System.out.print("\n\n");
							
		}
		
		System.exit(0);
	}
}
