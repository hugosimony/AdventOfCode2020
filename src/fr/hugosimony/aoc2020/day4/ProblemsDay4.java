package fr.hugosimony.aoc2020.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.hugosimony.aoc2020.Main;

public class ProblemsDay4 {

	/*
	 * Solutions of fourth day's problems of Advent of Code 2020 !
	 */
	
	public static int Problem1() {
		
		/*
		 * Problem :
		 * Find the number of valid passports.
		 * The possible fields are byr, iyr, eyr, hgt, hcl, ecl, pid and cid.
		 * A valid passport have all required fields with cid as optional.
		 * Imput : The list of the passports.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day4/input.txt").toString()));
			String line = reader.readLine();
			String buffer = "";
			while (line != null) {
				if(line.equals("")) {
					lines.add(buffer);
					buffer = "";
				}
				else
					buffer += " " + line;
				line = reader.readLine();
			}
			lines.add(buffer);
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
	   	String[] fields; boolean cid;
		int result = 0;
		
		//*********************************************************
		// Solve
		
		for(int i = 0; i < lines.size(); i++) {
			fields = lines.get(i).replaceFirst(" ", "").split(" ");
			if(fields.length > 6) {
				if(fields.length == 8)
					result++;
				else {
					cid = false;
					for(int j = 0; j < 7 && !cid; j++) 
						cid = fields[j].split(":")[0].equals("cid");
					result += cid ? 0 : 1;
				}
			}
		}
		
		//*********************************************************
		// Return solution
		return result;
		
	}
	
	// Functions for problem 2
	
	private static boolean isValidByr(String byr) {
		
		/*
		 * Returns true if the birth year is between 1920 and 2002, false otherwise.
		 */
		
		int year = Integer.parseInt(byr);
		return byr.length() == 4 && 1920 <= year && year <= 2002;
	}
	
	private static boolean isValidIyr(String iyr) {
		
		/*
		 * Returns true if the innoguration year is between 2010 and 2020, false otherwise.
		 */
		
		int year = Integer.parseInt(iyr);
		return iyr.length() == 4 && 2010 <= year && year <= 2020;
	}
	
	private static boolean isValidEyr(String eyr) {
		
		/*
		 * Returns true if the expiration year is between 2020 and 2030, false otherwise.
		 */
		
		int year = Integer.parseInt(eyr);
		return eyr.length() == 4 && 2020 <= year && year <= 2030;
	}
	
	private static boolean isValidHeight(String hgt) {
		
		/*
		 * Returns true if the height is between 150cm and 193cm (= between 59in and 76in), false otherwise.
		 */
		
		int height = 0;
		if(hgt.contains("cm")) {
			height = Integer.parseInt(hgt.split("cm")[0]);
			return height >= 150 && height <= 193;
		}
		else if(hgt.contains("in")){
			height = Integer.parseInt(hgt.split("in")[0]);
			return height >= 59 && height <= 76;
		}
		else
			return false;
	}
	
	private static boolean isHexa(String hexa) {
		
		/*
		 * Returns true if the string is a # followed by exactly six characters 0-9 or a-f, false otherwise.
		 */

		boolean hex = hexa.charAt(0) == '#' && hexa.length() == 7;
		int i = 1; int c;
		while(i < hexa.length() && hex) {
			c = (int) hexa.charAt(i);
			hex = (c >= 48 && c <= 57) || (c >= 97 && c <= 102);
			i++;
		}
		return hex;
	}
	
	public static int Problem2() {
		
		/*
		 * Problem :
		 * Find the number of valid passports.
		 * The possible fields are byr, iyr, eyr, hgt, hcl, ecl, pid and cid.
		 * A valid passport have all required fields with cid as optional.
		 * Furthermore, the fields have more rules to respect.
		 * (more informations here : https://adventofcode.com/2020/day/4#part2)
		 * Imput : The list of the passports.
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Paths.get(Main.filesPath + "day4/input.txt").toString()));
			String line = reader.readLine();
			String buffer = "";
			while (line != null) {
				if(line.equals("")) {
					lines.add(buffer);
					buffer = "";
				}
				else
					buffer += " " + line;
				line = reader.readLine();
			}
			lines.add(buffer);
			reader.close();
		} catch(IOException e) {
			System.out.println("Not able to open this file.");
		}
		List<String> eyeColors = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
	    	String[] fields; String[] fieldParts;
		boolean[] validity = {false, false, false, false, false, false, false};
		int result = 0;
		
		//*********************************************************
		// Solve
		
		for(int i = 0; i < lines.size(); i++) {
			fields = lines.get(i).replaceFirst(" ", "").split(" ");
			if(fields.length > 6) {
				for(int j = 0; j < 7; j++)
					validity[j] = false;
				for(int j = 0; j < fields.length; j++) {
					fieldParts = fields[j].split(":");
					if(fieldParts[0].equals("byr"))
						validity[0] = isValidByr(fieldParts[1]);
					else if(fieldParts[0].equals("iyr")) 
						validity[1] = isValidIyr(fieldParts[1]);
					else if(fieldParts[0].equals("eyr"))
						validity[2] = isValidEyr(fieldParts[1]);
					else if(fieldParts[0].equals("hgt"))
						validity[3] = isValidHeight(fieldParts[1]);
					else if(fieldParts[0].equals("hcl"))
						validity[4] = isHexa(fieldParts[1]);
					else if(fieldParts[0].equals("ecl"))
						validity[5] = eyeColors.contains(fieldParts[1]);
					else if(fieldParts[0].equals("pid")) {
						validity[6] = fieldParts[1].length() == 9; // Checking if each char is a digit is not needed
					}
				}
				result += validity[0] && validity[1] && validity[2] && validity[3] && validity[4] && validity[5] && validity[6] ? 1 : 0;
			}
		}
		
		//*********************************************************
		// Return solution
		return result;
		
	}
	
}
