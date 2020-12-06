package fr.hugosimony.aoc2020.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay6 {

	/*
	 * Solutions of sixth day's problems of Advent of Code 2020 !
	 */
	
	public static int Problem1() {
		
		/*
		 * Problem :
		 * Find the sum of number of questions to which anyone answered "yes" for each group.
		 * Imput : The list of the answers.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day4/input.txt").toString()));
			String line = reader.readLine();
			String buffer = "";
			while (line != null) {
				if(line.equals("")) {
					lines.add(buffer);
					buffer = "";
				}
				else
					buffer += line;
				line = reader.readLine();
			}
			lines.add(buffer);
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		ArrayList<Integer> used = new ArrayList<Integer>();
		int c; int count;
		int result = 0;
		
		//*********************************************************
		// Solve
		
		for(int i = 0; i < lines.size(); i++) {
			used.clear();
			count = 0;
			for(int j = 0; j < lines.get(i).length(); j++) {
				c = (int) lines.get(i).charAt(j);
				if(c >= 97 && c <= 122 && !used.contains(c))
					count++;
			}
			result += count;
		}
		
		//*********************************************************
		// Return solution
		return result;
		
	}
	
}
