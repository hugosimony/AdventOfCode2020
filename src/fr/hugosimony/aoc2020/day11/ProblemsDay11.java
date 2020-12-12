package fr.hugosimony.aoc2020.day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay11 {

	/*
	 * Solutions of eleventh day's problems of Advent of Code 2020 !
	 */
	
	public static int Problem1() {
		
		/*
		 * Problem :
		 * Find the number of occupied seats when everyone arrived.
		 * More informations on https://adventofcode.com/2020/day/11
		 * Imput : The list of the adaptaters.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day11/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		ArrayList<String> linesCopy = new ArrayList<String>();
		String temp; boolean loop = true;
		int count;
		
		//*********************************************************
		// Solve
		
		while(loop) {
			linesCopy.clear();
			for(int s = 0; s < lines.size(); s++)
				linesCopy.add(lines.get(s));
			loop = false;
			for(int i = 0; i < lines.size(); i++){
				for(int j = 0; j < lines.get(i).length(); j++) {
					if(lines.get(i).charAt(j) != '.') {
						count = 0;
						for(int x = -1; x <= 1; x++) {
							if(x+i >= 0 && x+i < lines.size()) {
								for(int y = -1; y <= 1; y++) {
									if((y != 0 || x != 0)){
										if(y+j >= 0 && y+j < lines.get(0).length()) {
											count += lines.get(i+x).charAt(j+y) == '#' ? 1 : 0;
										}
									}
								}
							}
						}
						if(count == 0 && lines.get(i).charAt(j) == 'L') {
							loop = true;
							temp = "";
							for(int c = 0; c < lines.get(i).length(); c++)
								temp += c == j ? '#' : linesCopy.get(i).charAt(c);
							linesCopy.set(i, temp);
						}
						else if(count >= 4 && lines.get(i).charAt(j) == '#') {
							loop = true;
							temp = "";
							for(int c = 0; c < lines.get(i).length(); c++) 
								temp += c == j ? 'L' : linesCopy.get(i).charAt(c);
							linesCopy.set(i, temp);
						}
					}
				}
			}
			for(int s = 0; s < linesCopy.size(); s++)
				lines.set(s, linesCopy.get(s));
		}
		count = 0;
		for(int i = 0; i < lines.size(); i++){
			for(int j = 0; j < lines.get(i).length(); j++) {
				if(lines.get(i).charAt(j) == '#')
					count++;
			}
		}
		
		//*********************************************************
		// Return solution
		return count;
	}
	
	// Function for problem 2
	
	public static int getOccupied(int check, ArrayList<String> lines, int x, int y) {
		int i = x; int j = y;
		boolean done = false;
		int occupied = 0;
		if(check == 0) {
			// Up
			i--;
			while(!done && i >= 0) {
				if(lines.get(i).charAt(j) != '.') {
					done = true;
					occupied = lines.get(i).charAt(j) == '#' ? 1 : 0;
				}
				i--;
			}
		}
		else if(check == 1) {
			// Down
			i++;
			while(!done && i < lines.size()) {
				if(lines.get(i).charAt(j) != '.') {
					done = true;
					occupied = lines.get(i).charAt(j) == '#' ? 1 : 0;
				}
				i++;
			}
		}
		else if(check == 2) {
			// Left
			j--;
			while(!done && j >= 0) {
				if(lines.get(i).charAt(j) != '.') {
					done = true;
					occupied = lines.get(i).charAt(j) == '#' ? 1 : 0;
				}
				j--;
			}
		}
		else if(check == 3) {
			// Right
			j++;
			while(!done && j < lines.get(i).length()) {
				if(lines.get(i).charAt(j) != '.') {
					done = true;
					occupied = lines.get(i).charAt(j) == '#' ? 1 : 0;
				}
				j++;
			}
		}
		else if(check == 4) {
			// Diag Left Up
			i--;
			j--;
			while(!done && i >= 0 && j >= 0) {
				if(lines.get(i).charAt(j) != '.') {
					done = true;
					occupied = lines.get(i).charAt(j) == '#' ? 1 : 0;
				}
				i--;
				j--;
			}
		}
		else if(check == 5) {
			// Diag Left Down
			i++;
			j--;
			while(!done && i < lines.size() && j >= 0) {
				if(lines.get(i).charAt(j) != '.') {
					done = true;
					occupied = lines.get(i).charAt(j) == '#' ? 1 : 0;
				}
				i++;
				j--;
			}
		}
		else if(check == 6) {
			// Diag Right Up
			i--;
			j++;
			while(!done && i >= 0 && j < lines.get(i).length()) {
				if(lines.get(i).charAt(j) != '.') {
					done = true;
					occupied = lines.get(i).charAt(j) == '#' ? 1 : 0;
				}
				i--;
				j++;
			}
		}
		else if(check == 7) {
			// Diag Right down
			i++;
			j++;
			while(!done && i < lines.size() && j < lines.get(i).length()) {
				if(lines.get(i).charAt(j) != '.') {
					done = true;
					occupied = lines.get(i).charAt(j) == '#' ? 1 : 0;
				}
				i++;
				j++;
			}
		}
		return occupied;
	}
	
	public static int Problem2() {
		
		/*
		 * Problem :
		 * Find the number of occupied seats when everyone arrived.
		 * More informations on https://adventofcode.com/2020/day/11#part2
		 * Imput : The list of the adaptaters.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day11/input.txt").toString()));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		ArrayList<String> linesCopy = new ArrayList<String>();
		String temp; boolean loop = true;
		int count;
		
		//*********************************************************
		// Solve
		
		while(loop) {
			linesCopy.clear();
			for(int s = 0; s < lines.size(); s++)
				linesCopy.add(lines.get(s));
			loop = false;
			for(int i = 0; i < lines.size(); i++){
				for(int j = 0; j < lines.get(i).length(); j++) {
					if(lines.get(i).charAt(j) != '.') {
						count = 0;
						for(int x = 0; x < 8; x++)
							count += getOccupied(x, lines, i, j);
						if(count == 0 && lines.get(i).charAt(j) == 'L') {
							loop = true;
							temp = "";
							for(int c = 0; c < lines.get(i).length(); c++)
								temp += c == j ? '#' : linesCopy.get(i).charAt(c);
							linesCopy.set(i, temp);
						}
						else if(count >= 5 && lines.get(i).charAt(j) == '#') {
							loop = true;
							temp = "";
							for(int c = 0; c < lines.get(i).length(); c++)
								temp += c == j ? 'L' : linesCopy.get(i).charAt(c);
							linesCopy.set(i, temp);
						}
					}
				}
			}
			for(int s = 0; s < linesCopy.size(); s++)
				lines.set(s, linesCopy.get(s));
		}
		count = 0;
		for(int i = 0; i < lines.size(); i++){
			for(int j = 0; j < lines.get(i).length(); j++) {
				if(lines.get(i).charAt(j) == '#')
					count++;
			}
		}
		
		//*********************************************************
		// Return solution
		return count;
	}
	
}
