package com.balaji.projecteuler.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:<br>
 * 1/2 = 0.5, 1/3 = 0.(3), 1/4 = 0.25, 1/5 = 0.2, 1/6 = 0.1(6), 1/7 =
 * 0.(142857), 1/8 = 0.125, 1/9 = 0.(1), 1/10 = 0.1, <br>
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
 * seen that 1/7 has a 6-digit recurring cycle.<br>
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 * 
 * @author Balaji Rayakota
 */
public class Problem_26_ReciprocalCycles {
	/**
	 * Solution = .
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		int maxCycle = 0;
		int number = 0;
		for (int i = 2; i < 1000; i++) {
			final int cycle = getRecurranceCycleDigit(i);
			if (maxCycle < cycle) {
				maxCycle = cycle;
				number = i;
			}
		}
		System.out.println(String.format("Maximum cycles = %d for %d", maxCycle, number));
	}

	/**
	 * Calculates the number of digits in recurrance cycle when divided with 1.
	 * 
	 * @param divisor
	 *           The integer divisor (must be positive).
	 * @return The non-negative number of digits in recurrance cycle.
	 */
	public static int getRecurranceCycleDigit(final int divisor) {
		if (divisor < 1) {
			throw new IllegalArgumentException("Divisor must be positive. Divisor = " + divisor);
		}

		final List<Integer> dividends = new ArrayList<>();
		int dividend = 10;
		while (true) {
			if (dividends.contains(dividend)) {
				break;
			}
			dividends.add(dividend);
			final int remainder = dividend % divisor;

			if (remainder == 0) {
				return 0;
			}
			dividend = remainder * 10;
		}

		for (int i = 0; i < dividends.size(); i++) {
			if (dividends.get(i) == dividend) {
				return dividends.size() - i;
			}
		}
		return 0;
	}
}
