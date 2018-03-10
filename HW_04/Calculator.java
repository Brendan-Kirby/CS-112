import java.util.Scanner;

public class Calculator {

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
		
		return false;
	}				
	
	//clone
	@Override
	public Calculator clone() {
	
		return new Calculator();
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
		
		if (toDivide == 0) {
		
			throw new DivideByZeroException();
		}	
		else {
			setPreviousResult(this.currentEntry);
			setCurrentEntry(this.previousResult / toDivide);
		}
	}				
}	
