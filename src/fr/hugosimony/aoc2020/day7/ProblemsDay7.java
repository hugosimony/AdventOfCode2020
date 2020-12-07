package fr.hugosimony.aoc2020.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay7 {

	/*
	 * Solutions of seventh day's problems of Advent of Code 2020 !
	 */
	
	public static int Problem1() {
		
		/*
		 * Problem :
		 * Find the number of bags colors that can eventually contain at least one shiny gold bag.
		 * Imput : The list of what the bags contain.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day7/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		ArrayList<String> bags = new ArrayList<String>();
		bags.add("shiny gold");
		String[] contains; String[] containers;
		boolean loop = true;
		
		//*********************************************************
		// Solve
		
		while(loop) {
			loop = false;
			for(int i = 0; i < lines.size(); i++) {
				contains = lines.get(i).split(" contain ");
				contains[0] = contains[0].split(" ")[0] + " " + contains[0].split(" ")[1];
				if(!contains[1].equals("no other bags.") && !bags.contains(contains[0])) {
					containers = contains[1].split(", ");
					for(int j = 0; j < containers.length; j++) {
						containers[j] = containers[j].split(" ")[1] + " " + containers[j].split(" ")[2];
						if(bags.contains(containers[j]) && !bags.contains(contains[0])) {
							loop = true;
							bags.add(contains[0]);
						}
					}
				}
			}
		}
		
		//*********************************************************
		// Return solution
		return bags.size()-1; // All bags without the shiny gold bag.
		
	}
	
	// Recursive function for problem 2
	
	public static int getNumberOfBags(String bag) {
		
		/*
		 * Returns the number of bags that the bag in parameter can contain
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day7/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		int temp; int count = 0;
		String[] contains; String[] containers;
		
		//*********************************************************
		// Solve
		
		for(int i = 0; i < lines.size(); i++) {
			contains = lines.get(i).split(" contain ");
			contains[0] = contains[0].split(" ")[0] + " " + contains[0].split(" ")[1];
			if(contains[0].equals(bag)) {
				if(contains[1].equals("no other bags."))
					return 0;
				else {
					containers = contains[1].split(", ");
					for(int j = 0; j < containers.length; j++) {
						temp = Integer.parseInt(containers[j].split(" ")[0]);
						containers[j] = containers[j].split(" ")[1] + " " + containers[j].split(" ")[2];
						count += temp + temp * getNumberOfBags(containers[j]);
					}
					return count;
				}
			}
		}

		return 0; // If the stop condition has not been reached.
	}
	
	public static int Problem2() {
		
		/*
		 * Problem :
		 * Find the number of bags that one shiny gold bag can contain.
		 * Imput : The list of what the bags contain.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Return solution
		return getNumberOfBags("shiny gold");
		
	}

}
