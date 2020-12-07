package fr.hugosimony.aoc2020.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay1 {
	
	/*
	 * Solutions of first day's problems of Advent of Code 2020 !
	 */
	
	public static int Problem1() {
		
		/*
		 * Problem :
		 * You need to find the two entries that sum to 2020 and then multiply those two numbers together.
		 * Imput : A list of numbers.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day1/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				numbersList.add(Integer.parseInt(line));
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		int[] numbers = numbersList.stream().mapToInt(i -> i).toArray();
		int multiplication = 0;

		//*********************************************************
		// Solve
		
		for(int i = 0; i < numbers.length && multiplication == 0; i++) {
			for(int j = i+1; j < numbers.length && multiplication == 0; j++) {
				if(numbers[i] + numbers[j] == 2020)
					multiplication = numbers[i] * numbers[j];
			}
		}
		
		//*********************************************************
		// Return solution
		return multiplication;
	}
	
	public static int Problem2() {
		
		/*
		 * Problem :
		 * You need to find the three entries that sum to 2020 and then multiply those three numbers together.
		 * Imput : A list of numbers (as a String).
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day1/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				numbersList.add(Integer.parseInt(line));
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		int[] numbers = numbersList.stream().mapToInt(i -> i).toArray();
		int multiplication = 0;

		//*********************************************************
		// Solve
		
		for(int i = 0; i < numbers.length && multiplication == 0; i++) {
			for(int j = i+1; j < numbers.length && multiplication == 0; j++) {
				for(int k = j+1; k < numbers.length && multiplication == 0; k++) {
					if(numbers[i] + numbers[j] + numbers[k] == 2020)
						multiplication = numbers[i] * numbers[j] * numbers[k];
				}
			}
		}
		
		//*********************************************************
		// Return solution
		return multiplication;
	}
}
