package fr.hugosimony.aoc2020.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay3 {
	
	/*
	 * Solutions of third day's problems of Advent of Code 2020 !
	 */
	
	public static int Problem1() {

		/*
		 * Problem :
		 * Starting at the top-left corner of your map and following a slope of right 3 and down 1, how many trees would you encounter?
		 * Imput : The grid of the trees.
		 * Output : The result of the problem.
		 */

		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day3/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
	    	int i = 0; int j = 0;
		int result = 0;
		
		//*********************************************************
		// Solve
		
		while(i < lines.size()) {
			result += (lines.get(i).charAt(j) + "").equals("#") ? 1 : 0;
			j+=3;
			if(j>=lines.get(i).length())
				j -= lines.get(i).length();
			i++;
		}
		
		//*********************************************************
		// Return solution
		return result;
	}
	
	public static int Problem2() {

		/*
		 * Problem :
		 * Determine the number of trees you would encounter if, for each of the following slopes :
		 * - Right 1, down 1,
		 * - Right 3, down 1,
		 * - Right 5, down 1,
		 * - Right 7, down 1,
		 * - Right 1, down 2,
		 * you start at the top-left corner and traverse the map all the way to the bottom.
		 * Find the number you get if you multiply together the number of trees encountered on each of the listed slopes.
		 * Imput : The grid of the trees.
		 * Output : The result of the problem.
		 */

		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day3/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
	    	int i = 0; int []js = {0,0,0,0,0};
	    	int []counts = {0,0,0,0,0};
	    	int result = 1;
		
		//*********************************************************
		// Solve
	    
		while(i < lines.size()) {
			for(int k = 0; k < 4; k++)
				counts[k] += (lines.get(i).charAt(js[k]) + "").equals("#") ? 1 : 0;
			counts[4] += (lines.get(i).charAt(js[4]) + "").equals("#") && i%2 == 0 ? 1 : 0;
			js[0]++; js[1]+=3; js[2]+=5; js[3]+=7; js[4] += i%2 == 0 ? 1 : 0;
			for(int k = 0; k < 5; k++) {
				if(js[k] >= lines.get(i).length())
					js[k] -= lines.get(i).length();
			}
			i++;
		}
		
		for(int c : counts)
			result *= c;
		
		//*********************************************************
		// Return solution
		return result;
	}
	
}
