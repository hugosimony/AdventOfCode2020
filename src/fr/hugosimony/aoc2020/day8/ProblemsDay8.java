package fr.hugosimony.aoc2020.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay8 {

	/*
	 * Solutions of eighth day's problems of Advent of Code 2020 !
	 */
	
	public static int Problem1() {
		
		/*
		 * Problem :
		 * Find the value of the accumulator just before a loop in the program.
		 * Imput : The list of instructions of the program.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day8/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i = 0; String[] parts;
		int acc = 0;
		
		//*********************************************************
		// Solve
		
		while(!indexes.contains(i) && i < lines.size()) {
			indexes.add(i);
			parts = lines.get(i).split(" ");
			if(parts[0].equals("acc"))
				acc += Integer.parseInt(parts[1]);
			else if(parts[0].equals("jmp"))
				i += Integer.parseInt(parts[1]) - 1; // -1 is to compensate for the i++ just after.
			i++;
		}
		
		//*********************************************************
		// Return solution
		return acc; 
	}
	
	public static int Problem2() {
		
		/*
		 * Problem :
		 * Find the value of the accumulator just before a loop in the fixed program.
		 * More informations on https://adventofcode.com/2020/day/8#part2
		 * Imput : The list of instructions of the program.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day8/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i = 0; String[] parts; String memory;
		int acc = 0;
		
		//*********************************************************
		// Solve
		
		for(int j = 0; j < lines.size(); j++) {
			acc = 0; i = 0;
			indexes.clear();
			parts = lines.get(j).split(" ");
			if(parts[0].equals("nop") || parts[0].equals("jmp")) {
				memory = lines.get(j);
				lines.set(j, (parts[0].equals("nop") ? "jmp " : "nop ") + parts[1]);
				while(!indexes.contains(i) && i < lines.size()) {
					indexes.add(i);
					parts = lines.get(i).split(" ");
					if(parts[0].equals("acc"))
						acc += Integer.parseInt(parts[1]);
					else if(parts[0].equals("jmp"))
						i += Integer.parseInt(parts[1]) - 1; // -1 is to compensate for the i++ just after.
					i++;
				}
				lines.set(j, memory);
				if(i == lines.size())
					j = lines.size();
			}
			
		}
		
		//*********************************************************
		// Return solution
		return acc; 
	}
	
}
