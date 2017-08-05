package com.balaji.projecteuler.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * The following iterative sequence is defined for the set of positive
 * integers:<br>
 * n → n/2 (n is even) <br>
 * n → 3n + 1 (n is odd) <br>
 * Using the rule above and starting with 13, we generate the following
 * sequence: 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1 It can be seen that this
 * sequence (starting at 13 and finishing at 1) contains 10 terms. Although it
 * has not been proved yet (Collatz Problem), it is thought that all starting
 * numbers finish at 1. Which starting number, under one million, produces the
 * longest chain?
 * 
 * @author Balaji Rayakota
 */
public class Problem_14_LongestCollatzSequence {
	/**
	 * Solution = 837799.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		final Map<Long, Integer> numberByCollatzLength = new HashMap<>(1000000);
		numberByCollatzLength.put(1L, 1);
		numberByCollatzLength.put(2L, 2);
		int max = 0;

		for (Long i = 1L; i <= 1000000L; i++) {
			final int result = calculateCollatzLength(i, numberByCollatzLength);
			System.out.println(i + " = " + result);
			if (max < result) {
				max = result;
			}
		}

		System.out.println("Maximum collatz length = " + max);
		for (final Long key : numberByCollatzLength.keySet()) {
			if (numberByCollatzLength.get(key) == max) {
				System.out.println("Number = " + key);
			}
		}

		System.out.println(new HashSet<Integer>(numberByCollatzLength.values()));
	}

	/**
	 * Calculates the collatz length for a number.
	 * 
	 * @param number
	 *           The number for which collatz length has to be calculated (must be
	 *           at least 1).
	 * @param numberByCollatzLength
	 *           The Map of known collatz length keyed by the number that has that
	 *           length (cannot be null).
	 * @return a positive integer.
	 */
	public static int calculateCollatzLength(final Long number, final Map<Long, Integer> numberByCollatzLength) {
		if (number < 1 || numberByCollatzLength == null) {
			throw new IllegalArgumentException("Unacceptable!!");
		}

		int numbersSeen = 0;
		long currentNumber = number;
		while (numberByCollatzLength.get(currentNumber) == null) {
			// System.out.println(currentNumber);
			numbersSeen++;
			if (currentNumber % 2 == 0) {
				currentNumber /= 2;
			} else {
				currentNumber = currentNumber * 3 + 1;
			}
		}
		final int result = numbersSeen + numberByCollatzLength.get(currentNumber);
		numberByCollatzLength.put(number, result);
		return result;
	}

	/**
	 * The collatz function.
	 * 
	 * @param num
	 *           The number for which collatz function has to be applied (must be at
	 *           least 1).
	 * @return A positive integer.
	 */
	public static int collatz(final int num) {
		if (num < 1) {
			throw new IllegalArgumentException("num cannot be less than 1");
		}

		if (num == 1) {
			return 1;
		}

		if (num % 2 == 0) {
			return num / 2;
		}

		return num * 3 + 1;
	}
}
