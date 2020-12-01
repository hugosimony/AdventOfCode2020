package fr.hugosimony.aoc2020.day1;

public class ProblemsDay1 {
	
	/*
	 * Solutions of first day's problems of Advent of Code 2020 !
	 */
	
	public static int Problem1() {
		
		/*
		 * Problem :
		 * You need to find the two entries that sum to 2020 and then multiply those two numbers together.
		 * Imput : A list of numbers (as a String).
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		String[] numbersString = InputsDay1.problem1_2.split("\n");
		int[] numbers = new int[numbersString.length];
		for(int i = 0; i < numbersString.length; i++)
			numbers[i] = Integer.parseInt(numbersString[i]);
		int multiplication = 0;

		//*********************************************************
		// Solve
		
		for(int i = 0; i < numbers.length && multiplication == 0; i++) {
			for(int j = i+1; j < numbers.length && multiplication == 0; j++) {
				if(numbers[i] + numbers[j] == 2020)
					multiplication = numbers[i] * numbers[j];
			}
		}
		
		//*********************************************************
		// Return solution
		return multiplication;
	}
	
	public static int Problem2() {
		
		/*
		 * Problem :
		 * You need to find the three entries that sum to 2020 and then multiply those three numbers together.
		 * Imput : A list of numbers (as a String).
		 * Output : The result of the problem.
		 */
		
		//*********************************************************
		// Setup
		
		String[] numbersString = InputsDay1.problem1_2.split("\n");
		int[] numbers = new int[numbersString.length];
		for(int i = 0; i < numbersString.length; i++)
			numbers[i] = Integer.parseInt(numbersString[i]);
		int multiplication = 0;

		//*********************************************************
		// Solve
		
		for(int i = 0; i < numbers.length && multiplication == 0; i++) {
			for(int j = i+1; j < numbers.length && multiplication == 0; j++) {
				for(int k = j+1; k < numbers.length && multiplication == 0; k++) {
					if(numbers[i] + numbers[j] + numbers[k] == 2020)
						multiplication = numbers[i] * numbers[j] * numbers[k];
				}
			}
		}
		
		//*********************************************************
		// Return solution
		return multiplication;
	}
	
}
