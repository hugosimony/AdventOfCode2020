package fr.hugosimony.aoc2020.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay9 {

	/*
	 * Solutions of ninth day's problems of Advent of Code 2020 !
	 */
	
	public static long Problem1() {
		
		/*
		 * Problem :
		 * Find the first number in the list (after the preamble) which is not the sum of two of the 25 numbers before it.
		 * Imput : The list of the numbers.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<Long> longs = new ArrayList<Long>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day9/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				longs.add(Long.parseLong(line));
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		int i; boolean contains = true;
		
		//*********************************************************
		// Solve
		
		for(i = 25; i < longs.size() && contains; i++) {
			contains = false;
			for(int j = i - 25; j < i - 1 && !contains; j++) {
				for(int k = j + 1; k < i && !contains; k++) {
					contains = longs.get(j) != longs.get(k) && longs.get(j) + longs.get(k) == longs.get(i);
				}
			}
		}
		
		//*********************************************************
		// Return solution
		return longs.get(i-1);
	}
	
	public static long Problem2() {
		
		/*
		 * Problem :
		 * Find the encryption weakness in your XMAS-encrypted list of numbers.
		 * More informations on https://adventofcode.com/2020/day/9#part2
		 * Imput : The list of the numbers.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<Long> longs = new ArrayList<Long>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day9/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				longs.add(Long.parseLong(line));
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		int i; int j = 0; long sum; long x = Problem1();
		boolean done = false; long min; long max;
		
		//*********************************************************
		// Solve
		
		for(i = 0; i < longs.size() && !done; i++) {
			sum = longs.get(i);
			for(j = i+1; j < longs.size() && !done; j++) {
				sum += longs.get(j);
				if(sum == x)
					done = true;
			}
		}
		
		min = longs.get(i-1);
		max = longs.get(i-1);
		for(int k = i; k < j; k++) {
			if(min > longs.get(k))
				min = longs.get(k);
			else if(max < longs.get(k))
				max = longs.get(k);
		}
		
		
		//*********************************************************
		// Return solution
		return min + max;
	}
	
}
