package com.balaji.projecteuler.solution;

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5,
 * 8, 13, 21, 34, 55, 89, ... By considering the terms in the Fibonacci sequence
 * whose values do not exceed four million, find the sum of the even-valued
 * terms.
 * 
 * @author Balaji Rayakota
 */
public class Problem_2_EvenFibonacciNumbers {
	/**
	 * Solution = 4613732.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		long fib1 = 1;
		long fib2 = 2;
		long sum = 2;

		while (fib2 <= 4000000) {
			final long next = fib1 + fib2;
			fib1 = fib2;
			fib2 = next;
			if (fib2 % 2 == 0) {
				sum += fib2;
			}
		}

		System.out.println(sum);
	}
}
