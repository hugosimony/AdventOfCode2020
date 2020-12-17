package fr.hugosimony.aoc2020.day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay15 {
	
	/*
	 * Solutions of fourteenth day's problems of Advent of Code 2020 !
	 */

	public static long Problem1() {
		
		/*
		 * Problem :
		 * Find the 2020th number spoken of the Elves's memory game.
		 * More informations on https://adventofcode.com/2020/day/15
		 * Imput : The initialization program.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day14/input.txt").toString()));
			String[] inputs = reader.readLine().split(",");
			for(int i = 0; i < inputs.length; i++)
				map.put(Integer.parseInt(inputs[i]), i+1);
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		
		//*********************************************************
		// Solve
		
		
		
		//*********************************************************
		// Return solution
		return 0;
	}

}
