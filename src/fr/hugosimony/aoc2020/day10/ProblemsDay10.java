package fr.hugosimony.aoc2020.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay10 {

	/*
	 * Solutions of tenth day's problems of Advent of Code 2020 !
	 */
	
	public static int Problem1() {
		
		/*
		 * Problem :
		 * Find the number of 1-jolt differences multiplied by the number of 3-jolt differences.
		 * More informations on https://adventofcode.com/2020/day/10
		 * Imput : The list of the adaptaters.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<Integer> ints = new ArrayList<Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day10/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				ints.add(Integer.parseInt(line));
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		int max = ints.get(0);
		for(int i = 1; i < ints.size(); i++) max = max < ints.get(i) ? ints.get(i) : max;
		int i = 0; int ones = 0; int threes = 0;
		
		//*********************************************************
		// Solve
		
		if(ints.contains(1)) {ones++; i = ints.indexOf(1);}
		else {threes++; i = ints.indexOf(3);}
		
		while(ints.get(i) != max) {
			if(ints.contains(ints.get(i) + 1)) {ones++; i = ints.indexOf(ints.get(i) + 1);}
			else {threes++; i = ints.indexOf(ints.get(i) + 3);}
		}
		
		//*********************************************************
		// Return solution
		return ones * (threes+1); // +1 because of the difference between max adaptater and device
	}
	
	// Recursive function for problem 2.
	
	public static long getNumberOfPossibilities(int start, int max, ArrayList<Integer> ints) {
		long possibilities = 0;
		while(start != max) {
			if(ints.contains(start + 1))
				possibilities += getNumberOfPossibilities(ints.indexOf(start + 1), max, ints);
			if(ints.contains(start + 3))
				possibilities += getNumberOfPossibilities(ints.indexOf(start + 3), max, ints);
		}
		return possibilities;
	}
	
	public static long Problem2() {
		
		/*
		 * Problem :
		 * Find the total number of distinct ways you can arrange the adapters to connect the charging outlet to your device.
		 * More informations on https://adventofcode.com/2020/day/10#part2
		 * Imput : The list of the adaptaters.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<Integer> ints = new ArrayList<Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day10/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				ints.add(Integer.parseInt(line));
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		int max = ints.get(0);
		for(int i = 1; i < ints.size(); i++) max = max < ints.get(i) ? ints.get(i) : max;
		
		//*********************************************************
		// Return solution
		return getNumberOfPossibilities(0, max, ints); // +1 because of the difference between max adaptater and device
	}
}
