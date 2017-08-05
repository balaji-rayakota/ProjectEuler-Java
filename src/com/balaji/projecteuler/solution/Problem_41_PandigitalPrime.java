package com.balaji.projecteuler.solution;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is
 * also prime.<br>
 * What is the largest n-digit pandigital prime that exists?
 * 
 * @author Balaji Rayakota
 */
public class Problem_41_PandigitalPrime {
	/**
	 * Solution = 7652413.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		// Note: cannot be 9-digit, 8-digit, 6-digit, or 5-digit pandigital because
		// they'll always be divisible by 3, as sum of digit is divisible by
		// 3.
		final int[] digits = { 1, 2, 3, 4, 5, 6, 7 };
		final boolean[] primes = Problem_35_CircularPrimes.createPrimeSieve(10000000);
		int maxPrime = 0;
		do {
			final int number = Problem_35_CircularPrimes.getNumber(digits);
			if (primes[number]) {
				System.out.println(number);
				if (maxPrime < number) {
					maxPrime = number;
				}
			}
		} while (Problem_32_PandigitalProducts.nextLexicographicPermutation(digits));

		System.out.println("max prime = " + maxPrime);
	}
}
