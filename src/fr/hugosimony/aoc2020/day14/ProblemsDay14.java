package fr.hugosimony.aoc2020.day14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map.Entry;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay14 {

	/*
	 * Solutions of fourteenth day's problems of Advent of Code 2020 !
	 */
	
	// Functions for problem 1
	
	public static String mergeBinaryStrings(String mask, String value) {
		
		/*
		 * Returns a String where each char is 
		 * - 1 if the char of mask is '1'
		 * - 0 if the char of mask is '0'
		 * - the char of value if the char of mask is 'X'
		 * mask and value must have the same length.
		 */
		
		String result = "";
		for(int i = 0; i < mask.length(); i++) {
			if(mask.charAt(i) == '1')
				result += "1";
			else if(mask.charAt(i) == '0')
				result += "0";
			else
				result += value.charAt(i);
		}
		return result;
	}
	
	public static long getBinValueFromString(String str) {
		
		/*
		 * Returns the value as a long of the string that represents a binary number.
		 */
		
		long value = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '1')
				value += Math.pow(2, str.length()-i-1);
		}
		return value;
	}

	public static long Problem1() {
		
		/*
		 * Problem :
		 * Find the sum of all values left in memory after the initialization program completes.
		 * More informations on https://adventofcode.com/2020/day/14
		 * Imput : The initialization program.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup and solve
		
		String parts[]; String mask = "";
		int key; long value; String temp;
		HashMap<Integer, Long> map = new HashMap<Integer, Long>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day14/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				parts = line.split(" = ");
				if(parts[0].equals("mask")) {
					mask = parts[1];
				}
				else {
					key = Integer.parseInt(parts[0].replace("mem[", "").replace("]", ""));
					temp = Long.toBinaryString(Integer.parseInt(parts[1]));
					for(int i = temp.length(); i < 36; i++)
						temp = "0" + temp;
					value = getBinValueFromString
							(mergeBinaryStrings
							(mask, temp));
					map.put(key, value);
				}
				
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		
		long sum = 0;
		for(Entry<Integer, Long> m : map.entrySet())
			sum+=m.getValue();
		
		//*********************************************************
		// Return solution
		return sum;
	}
	
}
