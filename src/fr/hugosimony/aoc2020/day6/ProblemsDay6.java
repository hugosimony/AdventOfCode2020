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
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day6/input.txt").toString()));
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
				if(c >= 97 && c <= 122 && !used.contains(c)) {
					used.add(c);
					count++;
				}
			}
			result += count;
		}
		
		//*********************************************************
		// Return solution
		return result;
		
	}
	
	public static int Problem2() {
		
		/*
		 * Problem :
		 * Find the sum of number of questions to which everyone answered "yes" for each group.
		 * Imput : The list of the answers.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day6/input.txt").toString()));
			String line = reader.readLine();
			String buffer = "";
			while (line != null) {
				if(line.equals("")) {
					lines.add(buffer);
					buffer = "";
				}
				else
					buffer += " " + line;
				line = reader.readLine();
			}
			lines.add(buffer);
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		String[] answers;
		int c; int count; int countTemp;
		int result = 0;
		
		//*********************************************************
		// Solve
		
		for(int i = 0; i < lines.size(); i++) {
			answers = lines.get(i).replaceFirst(" ", "").split(" ");
			count = 0;
			for(int j = 0; j < answers[0].length(); j++) {
				countTemp = 0;
				c = (int) answers[0].charAt(j);
				for(int k = 1; k < answers.length; k++) {
					if(c >= 97 && c <= 122 && answers[k].contains(answers[0].charAt(j) + ""))
						countTemp++;
				}
				count += countTemp == answers.length - 1 ? 1 : 0;
			}
			result += count;
		}
		
		//*********************************************************
		// Return solution
		return result;
		
	}
	
}
