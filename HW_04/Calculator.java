/* Calculator.java - Defines a calculator class which can perform basic  
 * 			         arithmetic functions.
 * 
 * Author:  Brendan Kirby
 * Module:  04
 * Project: 2
 * 
 * Description
 * 
 * 		Constants
 * 			None
 * 		Instance Variables
 * 			previousResult (double) - result of all previous calculations up to
 * 									  this point, initialized to 0.0.
 * 			currentEntry (double) - the current number entered into the calculator,
 * 									accompanying the operator.
 * 			activated (boolean) - activation state of this calculator, whether it
 * 								  is on or off.
 * 		Methods
 * 			constructors
 * 				default constructor - sets previousResult to 0.0, currentEntry to 0.0,
 * 								  and activated to true.
 * 				full constructor - takes all instance variables as parameters.
 * 			setters and getters
 * 				for each instance variable
 * 			toString() - returns a string with the values of all instance
 * 								variables for the calling calculator object.
 * 			equals(Object) - returns true if the instance variables of the calling
 * 							  calculator object hold identical data to those of the
 * 							  argument calculator object.
 * 			add(double) - sets previousResult to currentEntry, then adds the 
 * 						  argument to previousResult and returns the new 
 * 						  value as currentEntry.
 * 			subtract(double) - sets previousResult to currentEntry, then subtracts
 *  						   the argument to previousResult and returns the new 
 * 						  	   value as currentEntry.
 * 			multiply(double) - sets previousResult to currentEntry, then multiplies
 *  						   the argument by previousResult and returns the new 
 * 						       value as currentEntry.
 * 			divide(double) - sets previousResult to currentEntry, then divides 
 * 					   	  	 previousResult by the argument and returns the new 
 * 						  	 value as currentEntry.  
 */  


import java.util.Scanner;

public class Calculator {
	
	//instance variables
	private double previousResult, currentEntry;
	private boolean activated;
	
	//default constructor
	public Calculator() {
		
		setPreviousResult(0.0);
		setCurrentEntry(0.0);
		setActivated(true);
	}

	//full constructor
	public Calculator(double previousResult, double currentEntry, boolean activated) {
		
		setPreviousResult(previousResult);
		setCurrentEntry(currentEntry);
		setActivated(activated);
	}		
	
	//setters
	public void setPreviousResult(double previousResult) {
		
		this.previousResult = previousResult;
	}
	
	public void setCurrentEntry(double currentEntry) {
	
		this.currentEntry = currentEntry;
	}	
	
	public void setActivated(boolean activated) {
		
		this.activated = activated;
	}	
	
	//getters
	public double getPreviousResult() {
		
		return this.previousResult;
	}
	
	public double getCurrentEntry() {
		
		return this.currentEntry;
	}
	
	public boolean isActivated() {
	
		return this.activated;
	}	
		
	//toString
	@Override
	public String toString() {
		
		return "Previous Result: " + this.previousResult +
				"\nCurrent Entry: " + this.currentEntry +
				"\nActivated: " + this.activated;
	}
	
	//equals
	@Override
	public boolean equals(Object anotherObject) {
		
		if (anotherObject == null || !(anotherObject instanceof Calculator)) {
			
			return false;
		}
		
		Calculator anotherCalculator = new Calculator();
		anotherCalculator = (Calculator) anotherObject;
		
		return (this.previousResult == anotherCalculator.getPreviousResult() &&
			    this.currentEntry == anotherCalculator.getCurrentEntry()     &&
			    this.activated == anotherCalculator.isActivated());
	}				
	
	//arithmetic methods
	public void add(double toAdd) {
		
		setPreviousResult(this.currentEntry);
		setCurrentEntry(this.previousResult + toAdd);
	}
	
	public void subtract(double toSubtract) {
		
		setPreviousResult(this.currentEntry);
		setCurrentEntry(this.previousResult - toSubtract);
	}
	
	public void multiply(double toMultiply) {
		
		setPreviousResult(this.currentEntry);
		setCurrentEntry(this.previousResult * toMultiply);
	}	
	
	public void divide(double toDivide) throws DivideByZeroException {
		
		if (toDivide > 0 || toDivide < 0) {
		
			setPreviousResult(this.currentEntry);
			setCurrentEntry(this.previousResult / toDivide);
		}	
		else {
			
			throw new DivideByZeroException();	
		}
	}				
}	
