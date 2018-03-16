/* Employee.java - Defines an employee class which holds basic information  
 * 			       relevant to employees of a company.
 * 
 * Author:  Brendan Kirby
 * Module:  04
 * Project: 3
 * 
 * Description
 * 
 * 		Constants
 * 			DEFAULT_SALARY (double) - The default salary for new employee objects.
 * 			DEFAULT_SSN (int) - The default SSN for new employee objects.
 * 			DEFAULT_BIRTHDAY (Date) - The default birth date for new employee objects.
 * 			DEFAULT_DEATHDAY (Date) - The default death date for new employee objects.
 * 		Instance Variables
 * 			New
 * 				salary (double) - The salary of this employee object.
 * 				SSN (int) - The social security number of this employee object.
 * 			Inherited
 * 				name (String) - The name associated with the person represented by
 * 								this employee object.
 * 				birthDate (Date) - The date the person represented by this employee
 * 								   object was born.
 * 				deathDate (Date) - The date the person represented by this employee
 * 								   object died (null if still alive).
 * 		Methods
 * 			constructors
 * 				default constructor - calls super with "Default", DEFAULT_BIRTHDAY,
 * 									  and DEFAULT_DEATHDAY as arguments, then sets
 * 									  SSN to DEFAULT_SSN and salary to DEFAULT_SALARY.
 * 				full constructor - takes all instance variables as parameters.
 * 			setters and getters
 * 				for each instance variable
 * 			toString() - returns a string with the values of all instance
 * 						 variables for the calling calculator object.
 * 			equals(Object) - returns true if the instance variables of the calling
 * 							 employee object hold identical data to those of the
 * 							 argument employee object.
 * 			 
 */

public class Employee extends Person {

	//default constants
	private static final double DEFAULT_SALARY = 0.00;
	private static final int DEFAULT_SSN = 100000000;
	private static final Date DEFAULT_BIRTHDAY = new Date(1, 1, 1000);
	private static final Date DEFAULT_DEATHDAY = new Date(12, 31, 9999);

	//instance variables
	private double salary;
	private int SSN;

	//default constructor
	public Employee() {
	
		super("Default", DEFAULT_BIRTHDAY, DEFAULT_DEATHDAY);
		
		try {
			
			setSSN(DEFAULT_SSN);
			setSalary(DEFAULT_SALARY);
		}
		catch (SSNLengthException e) {
			
			System.out.println(e.getMessage());
		}
		catch (SSNCharacterException e) {
			
			System.out.println(e.getMessage());
		}
		catch (InvalidSalaryException e) {
			
			System.out.println(e.getMessage());
		}				
				
	}
	
	//full constructor
	public Employee(String name, Date birthDate, Date deathDate, int ssn, double salary) {
	
		super(name, birthDate, deathDate);
		
		try {
			
			setSSN(SSN);
			setSalary(salary);
		}
		catch (SSNLengthException e) {
			
			System.out.println(e.getMessage());
		}
		catch (SSNCharacterException e) {
			
			System.out.println(e.getMessage());
		}
		catch (InvalidSalaryException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	//setters
	public void setSSN(int SSN) throws SSNLengthException, SSNCharacterException {
	
		String temp = "" + SSN;
		boolean invalidChar = false;

		if (temp.length() != 9) {

			throw new SSNLengthException();
		}
		
		for (int i = 0; i < temp.length(); i++) {
		
			switch (Integer.parseInt(temp.substring(i,i+1))) {
				
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
					break;
				default:
					throw new SSNCharacterException();
			}		
		}	
	
		this.SSN = SSN;
	}
			
	
	
	public void setSalary(double salary) throws InvalidSalaryException {
	
		String temp = "" + salary;
	
		if (salary < 0.00) {
		
			throw new InvalidSalaryException();
		}
		
		for (int i = 0; i < temp.length(); i++) {
		
			switch (temp.charAt(i)) {
				
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '.':
					break;
				default:
					throw new InvalidSalaryException("Error - " + temp + " is not all numeric - Try again . . .");
			}		
		}
		
		this.salary = salary;			
	}	
	
	//getters
	public int getSSN() {
	
		return this.SSN;
	}	
	
	public double getSalary() {
	
		return this.salary;
	}	
	
	//toString
	public String toString() { 
		
		return  super.toString() + 
				"\nSSN: " + this.SSN +
				"\nSalary: " + this.salary;
	}	
	
	//equals
	public boolean equals(Object anotherObject) {

		
		if (anotherObject == null || !(anotherObject instanceof Employee)) {
			
			return false;
		}	
		
		Employee anotherEmployee = new Employee();
		anotherObject = anotherEmployee;
					
		return (super.equals(anotherEmployee) 		       &&
				this.salary == anotherEmployee.getSalary() &&
				this.SSN == anotherEmployee.getSSN());
	}					
}
