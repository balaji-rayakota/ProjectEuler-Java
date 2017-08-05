package com.balaji.projecteuler.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.<br>
 * Find the sum of all numbers which are equal to the sum of the factorial of
 * their digits.<br>
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * 
 * @author Balaji Rayakota
 */
public class Problem_34_DigitFactorials {
	private static Map<Integer, Integer> digitFactorial = getDigitFactorials();

	/**
	 * Solution = .
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		int sum = 0;
		for (int i = 3; i <= 10000000; i++) {
			if (isDigitFactorial(i)) {
				System.out.println(i);
				sum += i;
			}
		}

		System.out.println("Sum of digit factorials = " + sum);
	}

	/**
	 * Calculates if supplied number is a digit factorial.
	 * 
	 * @param number
	 *           The integer that must be checked (must be at least 3);
	 * @return True iff number is a digit factorial.
	 */
	public static boolean isDigitFactorial(final int number) {
		if (number < 3) {
			throw new IllegalArgumentException("Number must be at least 2. number = " + number);
		}

		int copy = number;
		int digitFactorialSum = 0;
		while (copy != 0) {
			digitFactorialSum += digitFactorial.get(copy % 10);
			copy /= 10;
		}

		return (number == digitFactorialSum);
	}

	/**
	 * Creates a Map of digits and their factorials.
	 * 
	 * @return A non-null Map of digits and their factorials.
	 */
	public static Map<Integer, Integer> getDigitFactorials() {
		final Map<Integer, Integer> factorials = new HashMap<>();

		factorials.put(0, 1);
		factorials.put(1, 1);
		factorials.put(2, 2);
		factorials.put(3, 6);
		factorials.put(4, 24);
		factorials.put(5, 120);
		factorials.put(6, 720);
		factorials.put(7, 5040);
		factorials.put(8, 40320);
		factorials.put(9, 362880);

		return factorials;
	}
}
