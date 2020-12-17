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
	
}
