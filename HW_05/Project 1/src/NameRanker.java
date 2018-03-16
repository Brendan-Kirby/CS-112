/* NameRanker.java - Allows a user to search a ranked list of baby names and
					 discover the popularity of the name they enter.

Author: Brendan Kirby
Module: 05
Project: 1

Algorithm: 

	Read file containing ranked boy names, store into String array boysToCheck
	Read file containing ranked girl names, store into String array girlsToCheck

	WHILE name entered is invalid

		Read user input for the name they want to search

		IF name is not empty or soley spaces THEN
			Name entered is not invalid
			
			Check equality of name against each array slot for both boys and girls

			IF the name matches both lists THEN		
				Print the rank & number of births for each sex for the matching name
			ELSE IF the name matches only the boys list THEN	
				Print the rank & number of births for boys for the matching name
			ELSE IF the name matches only the girls list THEN
				Print the rank & number of births for girls for the matching name
			ELSE 	
				Print a message telling the user the name they entered was not ranked
			END IF-ELSE IF-ELSE
		ELSE
			Name entered is invalid
		END IF-ELSE
	END WHILE

*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class NameRanker {

	public static void main(String[] args) {
		
		boolean valid = false;
		boolean boysMatch = false;
		boolean girlsMatch = false;
		int boysMatchRank = 0;
		int girlsMatchRank = 0;
		String response = "";
		String prompt = "Enter a name to find its rank: ";
		String boysAbsolutePath = "C:\\Users\\brend\\Desktop\\CS 112 Workspace\\HW_05\\Project 1\\src\\" + "BoyNames2016.txt";
		String girlsAbsolutePath = "C:\\Users\\brend\\Desktop\\CS 112 Workspace\\HW_05\\Project 1\\src\\" + "GirlNames2016.txt";
		NameAndBirths[] boysToCheck = new NameAndBirths[1000];
		NameAndBirths[] girlsToCheck = new NameAndBirths[1000];
		Scanner reader = new Scanner(System.in);
		
		for (int i = 0; i < 1000; i++) { //initializing arrays
			
			boysToCheck[i] = new NameAndBirths();
			girlsToCheck[i] = new NameAndBirths();
		}
			
		try { //reading data from census files into arrays
			
			Scanner boysFile = new Scanner(new FileInputStream(boysAbsolutePath));

			for (int i = 0; i < 1000; i++) {

				boysToCheck[i].setName(boysFile.next());
				boysToCheck[i].setNumBirths(boysFile.nextInt());
			}
			
			boysFile.close();			
			
			Scanner girlsFile = new Scanner(new FileInputStream(girlsAbsolutePath));
			
			for (int i = 0; i < 1000; i++) {
				
				girlsToCheck[i].setName(girlsFile.next());
				girlsToCheck[i].setNumBirths(girlsFile.nextInt());
			}			

			girlsFile.close();

		}
		catch (FileNotFoundException e) {
			
			System.out.println("Couldn't open file\n\n");
			System.exit(0);
		}
		
		while (!valid) { //repeating input for invalid names
			
			try {

				System.out.print(prompt);
				response = reader.next();
				System.out.print("\n");
				valid = true;
				
				for (int i = 0; i < 1000; i++) { //checking equality between input and name lists

					if (boysToCheck[i].getName().equalsIgnoreCase(response)) { //checking boys
							
						boysMatch = true;
						boysMatchRank = i;
					}

					if (girlsToCheck[i].getName().equalsIgnoreCase(response)) { //checking girls

						girlsMatch = true;
						girlsMatchRank = i;
					}
				}

				if (boysMatch && girlsMatch) { //name had matches in both lists

					System.out.print(boysToCheck[boysMatchRank].getName() +
									" is ranked " + 
									(boysMatchRank + 1) + 
									" among boys with " +
									boysToCheck[girlsMatchRank].getNumBirths() + 
									" new births." +
									"\n");
					System.out.print(girlsToCheck[girlsMatchRank].getName() +
									" is ranked " + 
									(girlsMatchRank + 1) + 
									" among girls with " +
									girlsToCheck[girlsMatchRank].getNumBirths() + 
									" new births." +
									"\n\n");					
				}
				else if (boysMatch) { //name only matched the boys list

					System.out.print(boysToCheck[boysMatchRank].getName() +
									" is ranked " + 
									(boysMatchRank + 1) + 
									" among boys with " +
									boysToCheck[girlsMatchRank].getNumBirths() + 
									" new births." +
									"\n\n");					
				}
				else if (girlsMatch) { //name only matched the girls list

					System.out.print(girlsToCheck[girlsMatchRank].getName() + 
									" is ranked " + 
									(girlsMatchRank + 1) + 
									" among girls with " +
									girlsToCheck[girlsMatchRank].getNumBirths() + 
									" new births." +
									"\n\n");						
				}
				else { //name did not match either list

					System.out.println("The name you entered was not ranked.\n");
				}				
				
			}
			catch (Exception e) { //name was invalid, sends user back to name input to try again
				
				System.out.println("Invalid name - Try again . . .");
				valid = false;
				boysMatch = false;
				girlsMatch = false;
			}
		}
		
		System.exit(0);
	}
}
