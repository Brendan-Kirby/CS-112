/* EmployeeDataEntry.java - Defines a class which can perform data entry for  
 * 			        	    employee objects and present them in a table when
 * 							finished.
 * 
 * Author:  Brendan Kirby
 * Module:  04
 * Project: 3
 * 
 * Algorithm:
 * 
 * 	WHILE there are more employees to enter
 * 
 * 		Print employee number
 * 		
 * 		Prompt user to enter employee name
 * 		Read employee name from user
 * 			- If employee's first name is equal to 'q' or 'Q',
 * 			  then there are no more employees to enter and the
 * 			  program breaks out of the while loop.
 * 
 * 		Prompt user to enter employee birth date
 * 		Read employee birth date from user
 * 			- If this throws an exception, print the exception
 * 			  message to console and repeat the input attempt.
 * 
 * 		Prompt user to enter employee social security number
 * 		Read employee SSN from user
 * 			- If this throws an exception, print the exception
 * 			  message to console and repeat the input attempt.
 * 
 * 		Prompt user to enter employee salary
 * 		Read employee salary from user
 * 			- If this throws an exception, print the exception
 * 			  message to console and repeat the input attempt. 
 * 
 * 		Increment employee number
 * 
 *  END WHILE
 * 
 *  Calculate average salary 
 * 
 *  Print average salary
 * 
 *  Compare each employee's salary to the average, assign "Under", "Over", or
 *  "Equal" as appropriate
 * 
 *  Print table of employee data and their salary relationship to the average 
 * 
 *  Exit Program 
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class EmployeeDataEntry {

	public static void main(String[] args) {
		
		//declaration & initialization / instantiation
		Employee[] employees = new Employee[100];
		String[] dateCreation = new String[3];
		Scanner reader = new Scanner(System.in);
		boolean moreToEnter = true;
		boolean invalidSSN, invalidSalary, invalidBirthdate;
		int empNum = 0;
		double totalSalary = 0.00;
		double averageSalary = 0.00;
		String firstName = "";
		String lastName = "";
		String relativeSalary = "";
		String empHeader = "Entering info for employee #" + (empNum + 1);
		String promptName = "Enter employee name (or Q to finish): ";
		String promptBirthdate = "Enter employee birth date [month day year]: ";
		String promptSSN = "Enter employee 9-digit SSN: ";
		String promptSalary = "Enter employee salary: $";
		String exitMessage = "Exiting data entry, generating table . . .";
		String lineFormat = "%3d" + "%-2s" + "%-17s" + "%9d" + "%-2s" + "%-20s" + "%,10.2f" + "%2s" + "%7s";
		
		//initializing employee array
		for (int i = 0; i < employees.length; i++) {
			
			employees[i] = new Employee();
		}

		//gets employee data while there are more employees to enter for
		while (moreToEnter) {
			
			invalidSSN = true;
			invalidSalary = true;
			invalidBirthdate = true;
			empHeader = "Entering info for employee #" + (empNum + 1);
			System.out.println(empHeader);
			
			//prompting for and reading in the first and last name of this employee,
			//if first name is exactly equal to either "Q" or "q", exits data entry loop
			System.out.print(promptName);
			firstName = reader.next();
			
			if (firstName.equals("Q") ||
				firstName.equals("q")) {
				
				moreToEnter = false;
				System.out.print("\n\n");
				System.out.println(exitMessage);
				System.out.print("\n\n");
				break;
			}			
			
			lastName = reader.next();
			employees[empNum].setName(firstName + " " + lastName);

			//prompting for and reading in the birth date of this employee
			while (invalidBirthdate) {
				
				try {
					
					System.out.print(promptBirthdate);
						
					for (int i = 0; i < dateCreation.length; i++) {
					
						dateCreation[i] = reader.next();
					}	
			
					employees[empNum].setBirthDate(new Date(dateCreation[0],
														    Integer.parseInt(dateCreation[1]),
															Integer.parseInt(dateCreation[2])));
					invalidBirthdate = false;
				}
				catch (NumberFormatException e) {
					
					invalidBirthdate = true;
					e = new NumberFormatException("Error - Incorrect birth date format - Try again . . .");
					System.out.println(e.getMessage());
				}
			}
				
			//prompting for and reading in the social security number of this employee
			while (invalidSSN) {
				
				try {
					
					System.out.print(promptSSN);
					employees[empNum].setSSN(reader.nextInt());
					invalidSSN = false;
				}	
				catch (SSNLengthException e) {
					
					System.out.println(e.getMessage());
					invalidSSN = true;
				}
				catch (SSNCharacterException e) {
					
					System.out.println(e.getMessage());
					invalidSSN = true;
				}
				catch (InputMismatchException e) {
				
					e = new InputMismatchException("Error - SSN must only contain integers - Try again . . .");
					System.out.println(e.getMessage());
					invalidSSN = true;
					reader.next();	
				}		
			}	

			//prompting for and reading in the salary of this employee
			while (invalidSalary) {
				
				try {
					
					System.out.print(promptSalary);
					employees[empNum].setSalary(reader.nextDouble());
					invalidSalary = false;
				}
				catch (InvalidSalaryException e) {
				
					System.out.println(e.getMessage());
					invalidSalary = true;
				}
				catch (InputMismatchException e) {
					
					e = new InputMismatchException("Error - Salary must only contain numbers - Try again . . .");
					System.out.println(e.getMessage());
					invalidSalary = true;
					reader.next();						
				}	
				
			}	
			
			//incrementing the employee number associated with this session of data entry
			empNum++;	
			
			System.out.print("\n\n");			
							
		}
		
		//calculating the total salary of all employees entered during data entry
		for (int i = 0; i < empNum; i++) {
		
			totalSalary += employees[i].getSalary();
		}
		
		//calculating the average salary of all employees entered during data entry
		averageSalary = (totalSalary / empNum);
		

		System.out.printf("%-51s"+"%,9.2f","The average salary for all employees entered is : $", averageSalary);
		System.out.print("\n\n\n");
		
		//prints the header of the information table
		System.out.print("No.   Employee-Name      SSN         Birth-date        Salary    to Avg.\n");
		System.out.print("---  ---------------  ---------  ------------------  ----------  -------\n");			
		
		//prints the information obtained during data entry for each employee
		for (int i = 0; i < empNum; i++) {
			
			//decides if each employee's salary is above, below, or exactly the average
			if (employees[i].getSalary() > averageSalary) {
			
				relativeSalary = "Over";
			}
			else if (employees[i].getSalary() < averageSalary){
				
				relativeSalary = "Under";
			}
			else {
			
				relativeSalary = "Equal";
			}			
			
			//prints table of employee information to console
			System.out.printf(lineFormat, (i + 1), 
											 "  ",
						   employees[i].getName(), 
						    employees[i].getSSN(), 
											 "  ", 
		   employees[i].getBirthDate().toString(),
						 employees[i].getSalary(), 
											 "  ", 
							relativeSalary + "\n");
		}
		
		System.out.print("\n\n");
		
		//printing the same employee data as the above table using toString 
		for (int i = 0; i < empNum; i++) {
		
			employees[i].toString();
			System.out.print("\n");
		}	
		
		System.out.print("\n\n");
		
		System.exit(0);
	}
}
