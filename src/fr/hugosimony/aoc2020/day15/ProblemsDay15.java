package fr.hugosimony.aoc2020.day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay15 {
	
	/*
	 * Solutions of fifteenth day's problems of Advent of Code 2020 !
	 */
	
	// Function for problem 1
	
	public static int getPenultimateIndexOf(ArrayList<Integer> list, int number) {
		
		/*
		 * Returns the penultimate index of number in the list.
		 * If there is not at least two times the number in the list, returns -1.
		 */
		
		boolean last = false;
		for (int i = list.size() - 1; i >= 0; i--) {
			if(list.get(i) == number) {
				if(!last)
					last = true;
				else
					return i;			
			}
				
		}
		return -1;
	}

	public static long Problem1() {
		
		/*
		 * Problem :
		 * Find the 2020th number spoken of the Elves's memory game.
		 * More informations on https://adventofcode.com/2020/day/15
		 * Imput : The first numbers.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int index = 0; int indexOf;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day15/input.txt").toString()));
			String[] inputs = reader.readLine().split(",");
			index = inputs.length+1;
			for(int i = 0; i < inputs.length; i++)
				list.add(Integer.parseInt(inputs[i]));
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		
		//*********************************************************
		// Solve
		
		while(index <= 2020){
			indexOf = getPenultimateIndexOf(list, list.get(list.size()-1));
			if(indexOf != -1 && indexOf != list.size()-1)
				list.add(index - 2 - indexOf);
			else
				list.add(0);
			index++;
		}
		
		//*********************************************************
		// Return solution
		return list.get(list.size()-1);
	}

	public static long Problem2() {
		
		/*
		 * Problem :
		 * Find the 30000000th number spoken of the Elves's memory game.
		 * More informations on https://adventofcode.com/2020/day/15#part2
		 * Imput : The first numbers.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int index = 0; int currentNumber = 0; int tempNumber = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day15/input.txt").toString()));
			String[] inputs = reader.readLine().split(",");
			index = inputs.length;
			for(int i = 0; i < inputs.length - 1; i++)
				map.put(Integer.parseInt(inputs[i]), i+1);
			currentNumber = Integer.parseInt(inputs[inputs.length-1]);
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		
		//*********************************************************
		// Solve
		
		while(index < 30000000){
			if(map.containsKey(currentNumber))
				tempNumber = index - map.get(currentNumber);
			else
				tempNumber = 0;
			map.put(currentNumber, index);
			currentNumber = tempNumber;
			index++;
		}
		
		//*********************************************************
		// Return solution
		return currentNumber;
	}
	
}
