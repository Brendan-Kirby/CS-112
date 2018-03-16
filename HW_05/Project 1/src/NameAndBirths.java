/* NameAndBirths.java - Defines a class NameAndBirths which contains instance
						variables and methods useful for the cataloguing of 
						census data pertinent to newborn children.

Author: Brendan Kirby
Module: 05
Project: 1

Description:

	Instance Variables

		name (String) - The name for which the number of births are being tracked.
		numBirths (int) - The number of times a child was born with the name specified
						  during that year.

	Methods

		Default Constructor
			Sets name to "Default" and numBirths to -1.
		Full Constructor
			Takes all instance variables as arguments.
		Setters and Getters
			For each instance variable.
		toString() - Returns a String with the data contained in each instance variable
					 belonging to the calling object.
		equals() - Returns true if the calling object has the same values as the argument
				   object for each instance variable, and is a member of the same class.
		
*/

public class NameAndBirths {
	
	private final String DEFAULT_NAME = "Default";
	private final int DEFAULT_NUM_BIRTHS = -1;
	
	private String name;
	private int numBirths;
	
	//default constructor
	public NameAndBirths() {
		
		setName(DEFAULT_NAME);
		setNumBirths(DEFAULT_NUM_BIRTHS);
	}
	
	//full constructor
	public NameAndBirths(String name, int numBirths) {
		
		setName(name);
		setNumBirths(numBirths);
	}
	
	//setters
	public void setName(String name) {
		
		this.name = name;
	}
	
	public void setNumBirths(int numBirths) {
		
		this.numBirths = numBirths;
	}
	
	//getters
	public String getName() {
		
		return this.name;
	}
	
	public int getNumBirths() {
		
		return this.numBirths;
	}
	
	//toString
	@Override
	public String toString() {
		
		return "Name: " + this.name +
			   "\nBirths: " + this.numBirths;
	}
	
	//equals
	@Override
	public boolean equals(Object anotherObject) {
		
		if (anotherObject == null || !(anotherObject instanceof NameAndBirths)) {
			
			return false;
		}
		
		NameAndBirths anotherNameAndBirths = new NameAndBirths();
		
		anotherNameAndBirths = (NameAndBirths) anotherObject;
		
		return (this.getName().equals(anotherNameAndBirths.getName()) &&
				this.getNumBirths() == anotherNameAndBirths.getNumBirths());
	}
}
