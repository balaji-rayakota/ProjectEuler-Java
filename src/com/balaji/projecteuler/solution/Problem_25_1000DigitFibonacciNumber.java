package com.balaji.projecteuler.solution;

import java.util.Arrays;

/**
 * The Fibonacci sequence is defined by the recurrence relation:<br>
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.<br>
 * Hence the first 12 terms will be:<br>
 * F1 = 1, F2 = 1, F3 = 2, F4 = 3, F5 = 5, F6 = 8, F7 = 13, F8 = 21, F9 = 34,
 * F10 = 55, F11 = 89, F12 = 144, <br>
 * The 12th term, F12, is the first term to contain three digits.<br>
 * What is the index of the first term in the Fibonacci sequence to contain 1000
 * digits?
 * 
 * @author Balaji Rayakota
 */
public class Problem_25_1000DigitFibonacciNumber {
	/**
	 * Solution = 4782.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		final long start = System.currentTimeMillis();
		final int[] fib1 = new int[1000];
		final int[] fib2 = new int[1000];
		final int[] fibT = new int[1000];

		fib1[0] = fib2[0] = 1;

		int index = 2;
		while (fib2[999] == 0) {
			// System.out.println(String.format("%7d = %s", index, Arrays.toString(fib2)));
			int carry = 0;
			for (int i = 0; i < 1000; i++) {
				final int tempSum = fib1[i] + fib2[i] + carry;
				fibT[i] = tempSum != 0 ? Problem_4_LargestPalindromeProduct.getDigitAt(tempSum, 0) : 0;
				carry = tempSum / 10;
			}
			copy(fib1, fib2);
			copy(fib2, fibT);
			index++;
			Arrays.fill(fibT, 0);
		}

		System.out.println("Index = " + index);
		final long stop = System.currentTimeMillis();
		System.out.println("Time to compute = " + (stop - start) + " ms");
	}

	/**
	 * Copies "from" array values into "to" array.
	 * 
	 * @param to
	 *           The array to be copied into (must not be null, should have the same
	 *           size as from).
	 * @param from
	 *           The array to be copied from (must not be null, should have the same
	 *           size as to).
	 */
	private static void copy(final int[] to, final int[] from) {
		if (to == null || from == null || to.length != from.length) {
			throw new IllegalArgumentException("Either one of the arrays was null or their lengths were not same");
		}

		for (int i = 0; i < to.length; i++) {
			to[i] = from[i];
		}
	}
}
