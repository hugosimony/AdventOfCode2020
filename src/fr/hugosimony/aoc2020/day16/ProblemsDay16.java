package fr.hugosimony.aoc2020.day16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay16 {

	/*
	 * Solutions of sixteenth day's problems of Advent of Code 2020 !
	 */
	
	public static long Problem1() {
		
		/*
		 * Problem :
		 * Find the ticket scanning error rate.
		 * More informations on https://adventofcode.com/2020/day/16
		 * Imput : The first numbers.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup

		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day16/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		ArrayList<Integer> range = new ArrayList<Integer>();
		String[] ranges; int min; int max; int sum = 0;
		int i = 0;
		
		//*********************************************************
		// Solve
		
		for(; i < lines.size() && !lines.get(i).equals(""); i++) {
			ranges = lines.get(i).split(": ")[1].split(" or ");
			min = Integer.parseInt(ranges[0].split("-")[0]);
			max = Integer.parseInt(ranges[0].split("-")[1]);
			while(min <= max) {
				if(!range.contains(min))
					range.add(min);
				min++;
			}
			min = Integer.parseInt(ranges[1].split("-")[0]);
			max = Integer.parseInt(ranges[1].split("-")[1]);
			while(min <= max) {
				if(!range.contains(min))
					range.add(min);
				min++;
			}
		}

		i+=5; // Skipping our ticket
		
		for(; i < lines.size(); i++) {
			ranges = lines.get(i).split(",");
			for(String s : ranges) {
				if(!range.contains(Integer.parseInt(s)))
					sum += Integer.parseInt(s);
			}
		}
		
		//*********************************************************
		// Return solution
		return sum;
	}
	
	// Function for problem 2
	
	public static boolean isThereOnlyOneElementInAllLists(ArrayList<ArrayList<String>> list) {
		
		/*
		 * Returns true if all lists of the list contain only one element.
		 * Retrurn false otherwise.
		 */
		
		for(ArrayList<String> l : list)
			if(l.size()!=1)
				return false;
		return true;
	}
	
	public static long Problem2() {
		
		/*
		 * Problem :
		 * Find the 2020th number spoken of the Elves's memory game.
		 * More informations on https://adventofcode.com/2020/day/15
		 * Imput : The first numbers.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup

		ArrayList<String> lines = new ArrayList<String>();
		int countClasses = 0; boolean doneClasses = false;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day16/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				if(!doneClasses) {
					if(line.equals(""))
						doneClasses = true;
					else
						countClasses++;
				}
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		ArrayList<ArrayList<Integer>> range = new ArrayList<ArrayList<Integer>>();
		ArrayList<String> classs = new ArrayList<String>();
		for(int x = 0; x < countClasses; x++) range.add(new ArrayList<Integer>());
		ArrayList<ArrayList<String>> classes = new ArrayList<ArrayList<String>>();
		for(int x = 0; x < countClasses; x++) classes.add(new ArrayList<String>());
		String[] ranges; int min; int max; int i = 0;
		String[] ticketNumbers; boolean valid = false;
		long result = 1;
		
		//*********************************************************
		// Solve
		
		for(; i < lines.size() && !lines.get(i).equals(""); i++) {
			for(int x = 0; x < countClasses; x++)
				classes.get(x).add(lines.get(i).split(":")[0]);
			classs.add(lines.get(i).split(":")[0]);
			ranges = lines.get(i).split(": ")[1].split(" or ");
			min = Integer.parseInt(ranges[0].split("-")[0]);
			max = Integer.parseInt(ranges[0].split("-")[1]);
			while(min <= max) {
				range.get(i).add(min);
				min++;
			}
			min = Integer.parseInt(ranges[1].split("-")[0]);
			max = Integer.parseInt(ranges[1].split("-")[1]);
			while(min <= max) {
				range.get(i).add(min);
				min++;
			}
		}
		
		i+=2;
		ticketNumbers = lines.get(i).split(",");
		i+=3;
		
		for(; i < lines.size(); i++) {
			ranges = lines.get(i).split(",");
			for(String s : ranges) {
				valid = false;
				for(ArrayList<Integer> range_ : range) {
					if(range_.contains(Integer.parseInt(s))) {
						valid = true;
						break;
					}
				}
				if(!valid)
					break;
			}
			if(valid) {
				for(int r = 0; r < ranges.length; r++) {
					for(int r_ =  0; r_ < range.size(); r_++) {
						if(!range.get(r_).contains(Integer.parseInt(ranges[r])))
							classes.get(r).remove(classs.get(r_));
					}
				}
			}
		}
		
		while(!isThereOnlyOneElementInAllLists(classes)) {
			for (int a = 0; a < classes.size(); a++) {
				ArrayList<String> l = classes.get(a);
				if(l.size()==1) {
					for (int b = 0; b < classes.size(); b++) {
						if(a!=b)
							classes.get(b).remove(l.get(0));
					}
				}
			}
		}
		
		for(int c = 0; c < classes.size(); c++) {
			if(classes.get(c).get(0).contains("departure"))
				result *= Integer.parseInt(ticketNumbers[c]);
		}
		
		//*********************************************************
		// Return solution
		return result;
	}
	
}
