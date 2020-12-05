package fr.hugosimony.aoc2020.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay5 {

	/*
	 * Solutions of fifth day's problems of Advent of Code 2020 !
	 */
	
	public static int Problem1() {
		
		/*
		 * Problem :
		 * Find the highest seat ID on a boarding pass.
		 * Every seat also has a unique seat ID: multiply the row by 8, then add the column.
		 * To get the row and the column, you should follow the following process : https://adventofcode.com/2020/day/5
		 * Imput : The list of the boarding passes.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day5/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		int rowMin = 0; int rowMax = 127;
		int colMin = 0; int colMax = 7;
		int result = 0;
		
		//*********************************************************
		// Solve
		
		for(int i = 0; i < lines.size(); i++) {
			rowMin = 0; rowMax = 127;
			colMin = 0; colMax = 7;
			for(int j = 0; j < lines.get(i).length(); j++) {
				if(lines.get(i).charAt(j) == 'F')
					rowMax = (rowMin+rowMax)/2;
				else if(lines.get(i).charAt(j) == 'B')
					rowMin = (rowMin+rowMax+1)/2;
				else if(lines.get(i).charAt(j) == 'R')
					colMin = (colMin+colMax+1)/2;
				else
					colMax = (colMin+colMax)/2;
			}
			if(result < rowMin * 8 + colMin)
				result = rowMin * 8 + colMin;
		}
		
		//*********************************************************
		// Return solution
		return result;
		
	}
	
	public static int Problem2() {
		
		/*
		 * Problem :
		 * Find your seat ID.
		 * The plane is full so your seat is the only one not on the list (except on the very front and the very end of the plane).
		 * Imput : The list of the boarding passes.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day5/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		int [][]seats = new int[128][8];
		for(int i = 0; i < 128; i++) {
			for(int j = 0; j < 8; j++) {
				seats[i][j] = 0;
			}
		}
		int rowMin = 0; int rowMax = 127;
		int colMin = 0; int colMax = 7;
		int result = 0;
		
		//*********************************************************
		// Solve
		
		for(int i = 0; i < lines.size(); i++) {
			rowMin = 0; rowMax = 127;
			colMin = 0; colMax = 7;
			for(int j = 0; j < lines.get(i).length(); j++) {
				if(lines.get(i).charAt(j) == 'F')
					rowMax = (rowMin+rowMax)/2;
				else if(lines.get(i).charAt(j) == 'B')
					rowMin = (rowMin+rowMax+1)/2;
				else if(lines.get(i).charAt(j) == 'R')
					colMin = (colMin+colMax+1)/2;
				else
					colMax = (colMin+colMax)/2;
			}
			seats[rowMin][colMin] = 1;
		}
		
		for(int i = 2; i < 128; i++) { 		// Starts at 2 because our seat is not on the very front of the plane.
			for(int j = 0; j < 8; j++) {
				if(seats[i][j] == 0) {
					result = i * 8 + j;
					i = 129; break;
				}
			}
		}
		
		//*********************************************************
		// Return solution
		return result;
		
	}
	
}
