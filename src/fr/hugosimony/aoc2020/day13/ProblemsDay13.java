package fr.hugosimony.aoc2020.day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay13 {
	
	/*
	 * Solutions of thirteenth day's problems of Advent of Code 2020 !
	 */

	public static int Problem1() {
		
		/*
		 * Problem :
		 * Find the ID of the earliest bus you can take to the airport multiplied by the number of minutes you'll need to wait for that bus.
		 * More informations on https://adventofcode.com/2020/day/13
		 * Imput : The id of the bus and the different lines of bus.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		int id = 0;
		ArrayList<Integer> buses = new ArrayList<Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day13/input.txt").toString()));
			id = Integer.parseInt(reader.readLine());
			for(String s : reader.readLine().split(",")) {
				if(!s.equals("x"))
					buses.add(Integer.parseInt(s));
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		int minDistance = id; int index = 0; int count;
		
		//*********************************************************
		// Solve
		
		for(int i = 0; i < buses.size(); i++) {
			count = 0;
			while(count < id)
				count += buses.get(i);
			if(count - id < minDistance) {
				minDistance = count - id;
				index = i;
			}
		}
		
		//*********************************************************
		// Return solution
		return minDistance * buses.get(index);
	}
	
	public static long Problem2() {

		/*
		 * Problem :
		 * Find the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list.
		 * More informations on https://adventofcode.com/2020/day/13#part2
		 * Imput : The id of the bus (useless) and the different lines of bus.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<Integer> allBuses = new ArrayList<Integer>();
		ArrayList<Integer> buses = new ArrayList<Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day13/input.txt").toString()));
			reader.readLine();
			for(String s : reader.readLine().split(",")) {
				if(!s.equals("x")) {
					allBuses.add(Integer.parseInt(s));
					buses.add(Integer.parseInt(s));
				}
				else
					allBuses.add(0);
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		boolean done = false; int offset = buses.get(0); 
		long i = 0;
		
		//*********************************************************
		// Solve
		
		for(; !done; i+=offset) {
			done = true;
			int j = 0;
			while(done && j < buses.size()) {
				if(i!=j)
					done = (long) (i + (long) allBuses.indexOf(buses.get(j))) % (long) buses.get(j) == 0;
				j++;
			}
		}
		
		//*********************************************************
		// Return solution
		return i-offset;
	}
	
}
