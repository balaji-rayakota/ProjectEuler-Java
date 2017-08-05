package com.balaji.projecteuler.solution;

/**
 * If p is the perimeter of a right angle triangle with integral length sides,
 * {a,b,c}, there are exactly three solutions for p = 120.<br>
 * {20,48,52}, {24,45,51}, {30,40,50}<br>
 * For which value of p ≤ 1000, is the number of solutions maximised?
 * 
 * @author Balaji Rayakota
 */
public class Problem_39_IntegerRightTriangles {
	/**
	 * Solution = .
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		int maxSolutions = 0;
		int maxSolutionsPerimeter = 0;
		for (int perimeter = 3; perimeter <= 1000; perimeter++) {
			final int numOfSolutions = numberOfIntegerRightTriangles(perimeter);
			if (maxSolutions < numOfSolutions) {
				maxSolutions = numOfSolutions;
				maxSolutionsPerimeter = perimeter;
			}
		}

		System.out.println("Maximum number of solutions = " + maxSolutions + " for perimeter = " + maxSolutionsPerimeter);
	}

	/**
	 * Calculates the number of right angled triangles with integeral length sides
	 * exist for a given perimeter.
	 * 
	 * @param perimeter
	 *           The integer perimeter (must be at least 3).
	 * @return A non-negative integer.
	 */
	public static int numberOfIntegerRightTriangles(final int perimeter) {
		if (perimeter < 3) {
			throw new IllegalArgumentException("Perimeter must be at least three. perimeter = " + perimeter);
		}

		System.out.println("Perimeter = " + perimeter);
		int numberOfIntegerRightTriangles = 0;
		for (int a = 1; a < perimeter; a++) {
			for (int b = a; b < perimeter; b++) {
				final int c = perimeter - a - b;
				if (c > 0 && c >= b) {
					if (a * a + b * b == c * c) {
						System.out.println("{" + a + ", " + b + ", " + c + "}");
						numberOfIntegerRightTriangles++;
					}
				}
			}
		}

		return numberOfIntegerRightTriangles;
	}
}
