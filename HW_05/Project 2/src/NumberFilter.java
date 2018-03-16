/* NumberFilter.java - Allows the user to input a file to be filtered for duplicate
					   integers, and generate a new file with only the unique
					   integers found in the input file.

Author: Brendan Kirby
Module: 05
Project: 2

Algorithm: 

	Read name of the input file from user
	Read name of the output file from user

	Read each integer in the input file into an array

	Insertion sort the array such that the lowest values are at the top

	Filter the array by checking inequality between each cell, copying only
	unique values into a new validInts array of equal length to the array holding 
	the input file data, increment the number of unique values

	Create a new array of size equal to the number of unique values, populate
	with each integer stored in validInts, in order since they were already sorted

	Write each integer in the new array to a file with the name specified by the
	user at the beginning of the program

	Print the number of integers read from the input file, the number of integers
	written to the output file, and the number of duplicate integers found

	Exit program
*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class NumberFilter {
	
	public static int[] sort(int[] toSort) {
		
		int smallest = 0;
		
		for (int i = 1; i < toSort.length; i++) {
			
			for (int j = i; j > 0; j--) {
				
				if (toSort[j] < toSort[j - 1]) {
					
					smallest = toSort[j];
					toSort[j] = toSort[j - 1];
					toSort[j - 1] = smallest;
				}
			}
		}
		
		return toSort;
	}

	public static int[] filter(int[] toFilter) {

		int[] validInts = new int[toFilter.length];
		int[] filtered;
		int numUnique = 0;
		
		sort(toFilter);
		
		for (int i = 0; i < toFilter.length - 1; i++) {
			
			if (toFilter[i] != toFilter[i + 1]) {
				
				validInts[numUnique] = toFilter[i];
				numUnique++;
			}
		}
		
		if (toFilter[toFilter.length - 1] != validInts[numUnique - 1]) {
			
			validInts[numUnique] = toFilter[toFilter.length - 1];
			numUnique++;
		}
		
		filtered = new int[numUnique];
		
		for (int i = 0; i < filtered.length; i++) {
			
			filtered[i] = validInts[i];
		}
		
		return filtered;
	}
	
	public static void main(String[] args) {

		int arraySize = 0;
		String readName;
		String writeName;
		String readPath;
		String writePath;
		int[] readInts;
		int[] writeInts;
		Scanner reader = null;
		PrintWriter writer = null;
		
		try {
			
			reader = new Scanner(System.in);
			
			System.out.print("Enter the name of the file you want to filter : ");
			readName = reader.next();
			System.out.print("What do you want the output file to be named? : ");
			writeName = reader.next();
			reader.close();
			
			readPath = "C:\\Users\\brend\\Desktop\\CS 112 Workspace\\HW_05\\Project 2\\src\\" + readName;
			writePath = "C:\\Users\\brend\\Desktop\\CS 112 Workspace\\HW_05\\Project 2\\src\\" + writeName;
			
			reader = new Scanner(new FileInputStream(readPath));
			
			System.out.println("\nReading " + readName + " contents . . .");
			
			while (reader.hasNextInt()) {
				
				reader.nextInt();
				arraySize++;
			}
			
			reader.close();
			
			readInts = new int[arraySize];
			
			reader = new Scanner(new FileInputStream(readPath));
			
			for (int i = 0; i < readInts.length; i++) {
				
				readInts[i] = reader.nextInt();
			}
			
			reader.close();	
			
			System.out.println("\n\nFiltering duplicates out of " + readName + " . . .\n");
			writeInts = filter(sort(readInts));
			
			System.out.println("\nWriting filtered list to " + writeName + " . . .\n\n");	
			writer = new PrintWriter(new FileOutputStream(writePath));
			
			for (int i = 0; i < writeInts.length; i++) {
				
				writer.println(writeInts[i]);
			}
			
			writer.close();
			
			System.out.println("Finished writing filtered list to " +
							   writeName + 
							   ", found " + 
							   arraySize + 
							   " integers \nin the input file and filtered out " +
							   writeInts.length + " unique values leaving " + 
							   (arraySize - writeInts.length) + " duplicates.");
			
		}
		catch (FileNotFoundException e) {
			
			System.out.println("File couldn't be opened");
		}
		
		System.out.print("\n\n");
	}
}
