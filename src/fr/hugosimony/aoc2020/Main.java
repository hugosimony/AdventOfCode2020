package fr.hugosimony.aoc2020;

import fr.hugosimony.aoc2020.day1.ProblemsDay1;
import fr.hugosimony.aoc2020.day2.ProblemsDay2;
import fr.hugosimony.aoc2020.day3.ProblemsDay3;

public class Main {
	
	public static final String filesPath = "src/fr/hugosimony/aoc2020/";
	
	public static void main(String[] args) {
		
		/*
		 * Prints the solutions of all problems by day.
		 */
		
		System.out.println("------------------ Day 1 ------------------");
		System.out.println("Problem 1 : Solution = " + ProblemsDay1.Problem1());
		System.out.println("Problem 2 : Solution = " + ProblemsDay1.Problem2());
		System.out.println("------------------ Day 2 ------------------");
		System.out.println("Problem 1 : Solution = " + ProblemsDay2.Problem1());
		System.out.println("Problem 1 : Solution = " + ProblemsDay2.Problem2());
		System.out.println("------------------ Day 3 ------------------");
		System.out.println("Problem 1 : Solution = " + ProblemsDay3.Problem1());
		System.out.println("Problem 1 : Solution = " + ProblemsDay3.Problem2());
		
	}
	
}
