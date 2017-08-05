package com.balaji.projecteuler.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect
 * number.<br>
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.<br>
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.<br>
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 * 
 * @author Balaji Rayakota
 */
public class Problem_23_NonAbundantSums {
	/**
	 * Solution = 4179871.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		final List<Integer> abundantNumbers = new ArrayList<>();
		for (int i = 2; i < 28123; i++) {
			if (Problem_21_AmicableNumbers.getSumOfProperDivisors(i) > i) {
				abundantNumbers.add(i);
			}
		}

		System.out.println(abundantNumbers.toString());

		final boolean[] sieve = new boolean[28214];
		Arrays.fill(sieve, false);

		for (final Integer a : abundantNumbers) {
			for (final Integer b : abundantNumbers) {
				final int c = a + b;
				if (c <= 28213) {
					sieve[c] = true;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < sieve.length; i++) {
			if (!sieve[i]) {
				sum += i;
			}
		}
		System.out.println("Non-abundant sum = " + sum);
	}
}
