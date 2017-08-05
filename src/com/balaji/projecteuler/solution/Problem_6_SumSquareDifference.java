package com.balaji.projecteuler.solution;

/**
 * The sum of the squares of the first ten natural numbers is, 12 + 22 + ... +
 * 102 = 385 The square of the sum of the first ten natural numbers is, (1 + 2 +
 * ... + 10)2 = 552 = 3025 Hence the difference between the sum of the squares
 * of the first ten natural numbers and the square of the sum is 3025 − 385 =
 * 2640. Find the difference between the sum of the squares of the first one
 * hundred natural numbers and the square of the sum.
 * 
 * @author Balaji Rayakota
 */
public class Problem_6_SumSquareDifference {
	/**
	 * Solutions = 25164150. (1 + 2 +..+100)^2 - (1^2 + 2^2 + .. + 100^2) = S^2
	 * -(1^2 + 2^2 + .. + 100^2) where S = 100*101/2
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		double sum = Math.pow(5050, 2);
		for (double i = 1; i <= 100D; i++) {
			sum -= Math.pow(i, 2);
		}
		System.out.println(sum);
	}
}
