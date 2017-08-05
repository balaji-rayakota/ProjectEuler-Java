package com.balaji.projecteuler.solution;

/**
 * Find the sum of all the numbers that can be written as the sum of fifth
 * powers of their digits.
 * 
 * @author Balaji Rayakota.
 */
public class Problem_30_DigitFifthPowers {
	/**
	 * Solution = 443839.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		int sum = 0;
		for (int i = 2; i < 999999; i++) {
			if (i == digitFifthPowerSum(i)) {
				sum += i;
				System.out.println(i);
			}
		}

		System.out.println(sum);
	}

	/**
	 * Calculates the sum of digits raised to fifth power.
	 * 
	 * @param num
	 *           The number whose fifth power digit sum has to be calculated (must
	 *           be at least 2).
	 * @return A positive integer.
	 */
	public static int digitFifthPowerSum(final int num) {
		if (num < 1) {
			throw new IllegalArgumentException("Supplied number should be at least 2. num = " + num);
		}

		int copy = num;
		int sum = 0;
		while (copy != 0) {
			final int digit = copy % 10;
			sum += Math.pow(digit, 5);
			copy /= 10;
		}

		return sum;
	}
}
