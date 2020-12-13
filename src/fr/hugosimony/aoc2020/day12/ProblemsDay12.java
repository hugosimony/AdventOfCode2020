package fr.hugosimony.aoc2020.day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay12 {

	/*
	 * Solutions of twelfth day's problems of Advent of Code 2020 !
	 */
	
	// Function for problem 1
	
	public static int getDirection(int current, int degrees, int rotation) {
		
		/*
		 * Returns the good direction after the rotation (left or right) of the boat in degrees)
		 * Directions : 0 = East / 1 = South / 2 = West / 3 = North
		 * Rotation : 0 = Right / 1 = Left
		 */
		
		int newDirection = rotation == 0 ? current + degrees/90 : current - degrees/90;
		if(rotation == 0 && newDirection > 3) newDirection -= 4;
		else if(rotation == 1 && newDirection < 0) newDirection += 4;
		return newDirection;
	}
	
	public static int Problem1() {
		
		/*
		 * Problem :
		 * Find the the Manhattan distance between that location and the ship's starting position.
		 * More informations on https://adventofcode.com/2020/day/12
		 * Imput : The list of the instructions.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day12/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		int EW = 0; int NS = 0; int direction = 0;
		
		//*********************************************************
		// Solve
		
		for(int i = 0; i < lines.size(); i++) {
			String instruction = lines.get(i).charAt(0) + "";
			int value = Integer.parseInt(lines.get(i).replace(instruction, ""));
			if(instruction.equals("R"))
				direction = getDirection(direction, value, 0);
			else if(instruction.equals("L"))
				direction = getDirection(direction, value, 1);
			else if(instruction.equals("N"))
				NS += value;
			else if(instruction.equals("S"))
				NS -= value;
			else if(instruction.equals("E"))
				EW += value;
			else if(instruction.equals("W"))
				EW -= value;
			else if(instruction.equals("F")) {
				if(direction == 0) EW += value;
				else if(direction == 1) NS -= value;
				else if(direction == 2) EW -= value;
				else if(direction == 3) NS += value;
			}
		}
		
		//*********************************************************
		// Return solution
		return Math.abs(EW) + Math.abs(NS);
	}
	
	public static int Problem2() {
		
		/*
		 * Problem :
		 * Find the the Manhattan distance between that location and the ship's starting position.
		 * More informations on https://adventofcode.com/2020/day/12#part2
		 * Imput : The list of the instructions.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day12/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		int EWW = 10; int NSW = 1; int EW = 0; int NS = 0; int temp;
		
		//*********************************************************
		// Solve
		
		for(int i = 0; i < lines.size(); i++) {
			String instruction = lines.get(i).charAt(0) + "";
			int value = Integer.parseInt(lines.get(i).replace(instruction, ""));
			if(instruction.equals("R") || instruction.equals("L")) {
				if(instruction.equals("L"))
					value = 360 - value;
				if(value == 180) {
					EWW*=-1;
					NSW*=-1;
				}
				else if(value == 90){
					temp = EWW;
					EWW = NSW;
					NSW = temp*-1;
				}
				else if(value == 270){
					temp = EWW;
					EWW = NSW*-1;
					NSW = temp;
				}
			}
			else if(instruction.equals("N"))
				NSW += value;
			else if(instruction.equals("S"))
				NSW -= value;
			else if(instruction.equals("E"))
				EWW += value;
			else if(instruction.equals("W"))
				EWW -= value;
			else if(instruction.equals("F")) {
				EW += EWW*value;
				NS += NSW*value;
			}
		}
		
		//*********************************************************
		// Return solution
		return Math.abs(EW) + Math.abs(NS);
	}
	
}
