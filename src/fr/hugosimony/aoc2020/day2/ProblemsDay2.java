package fr.hugosimony.aoc2020.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay2 {

	/*
	 * Solutions of second day's problems of Advent of Code 2020 !
	 */
	
	public static int Problem1() {

		/*
		 * Problem :
		 * You need to find the number of passwords that respect the following condition :
		 * The password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid.
		 * For example, 1-3 a means that the password must contain 'a' at least 1 time and at most 3 times.
		 * Imput : A list of passwords.
		 * Output : The result of the problem.
		 */

		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
	    	try {
	    		BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day2/input.txt").toString()));
	    		String line = reader.readLine();
	    		while (line != null) {
	    			lines.add(line);
	    			line = reader.readLine();
	    		}
	  	    	reader.close();
	    	} catch(IOException e) {
	    		System.out.println("Not able to open this file.");
	    	}
	    	String[] parts; String[] first; String[] numbers;
	    	int min; int max; int count;
		int result = 0;
		
		//*********************************************************
		// Solve
		
		for(int i = 0; i < lines.size(); i++) {
			
			// Setup each password
			parts = lines.get(i).split(": ");
			first = parts[0].split(" ");
			numbers = first[0].split("-");
			min = Integer.parseInt(numbers[0]);
			max = Integer.parseInt(numbers[1]);
			count = 0;
			
			// Solve each password
			for(int j = 0; j < parts[1].length() && count <= max; j++)
				count += (parts[1].charAt(j) + "").equals(first[1]) ? 1 : 0;
			result += count <= max && count >= min ? 1 : 0;
		}
		
		//*********************************************************
		// Return solution
		return result;
	}
	
	public static int Problem2() {

		/*
		 * Problem :
		 * You need to find the number of passwords that respect the following condition :
		 * Each policy describes two positions in the password, where 1 means the first character, 2 means the second character, and so on.
		 * Exactly one of these positions must contain the given letter. 
		 * Other occurrences of the letter are irrelevant for the purposes of policy enforcement.
		 */

		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
	    	try {
	    		BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day2/input.txt").toString()));
	    		String line = reader.readLine();
	    		while (line != null) {
	    			lines.add(line);
	    			line = reader.readLine();
	    		}
	  	    	reader.close();
	    	} catch(IOException e) {
	    		System.out.println("Not able to open this file.");
	    	}
	    	String[] parts; String[] first; String[] numbers;
	    	int index1; int index2; int count;
		int result = 0;
		
		//*********************************************************
		// Solve
		
		for(int i = 0; i < lines.size(); i++) {
			
			// Setup each password
			parts = lines.get(i).split(": ");
			first = parts[0].split(" ");
			numbers = first[0].split("-");
			index1 = Integer.parseInt(numbers[0]) - 1; // Toboggan Corporate Policies have no concept of "index zero".
			index2 = Integer.parseInt(numbers[1]) - 1; // Toboggan Corporate Policies have no concept of "index zero".
			count = 0;
			
			// Solve each password
			count += (parts[1].charAt(index1) + "").equals(first[1]) ? 1 : 0;
			count += (parts[1].charAt(index2) + "").equals(first[1]) ? 1 : 0;
			result += count == 1 ? 1 : 0;
		}
		
		//*********************************************************
		// Return solution
		return result;
	}
	
}
