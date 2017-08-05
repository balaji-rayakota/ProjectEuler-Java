package com.balaji.projecteuler.solution;

/**
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral?
 * 
 * @author Balaji Rayakota
 */
public class Problem_28_NumberSpiralDiagonals {
	/**
	 * Solution = 669171001.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		int sum = 1;
		int number = 1;

		for (int side = 3; side <= 1001; side += 2) {
			// bottom right
			number += (side - 1);
			sum += number;
			// System.out.println(sum);

			// bottom left
			number += (side - 1);
			sum += number;
			// System.out.println(sum);

			// top left
			number += (side - 1);
			sum += number;
			// System.out.println(sum);

			// top right
			number += (side - 1);
			sum += number;
			// System.out.println(sum);
		}
		System.out.println("Sum of diagonals = " + sum);
	}
}
