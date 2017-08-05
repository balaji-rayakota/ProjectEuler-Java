package com.balaji.projecteuler.solution;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to
 * the right and down, there are exactly 6 routes to the bottom right corner.How
 * many such routes are there through a 20×20 grid?
 * 
 * @author Balaji Rayakota
 */
public class Problem_15_LatticePaths {
	/**
	 * Solution = 137846528820.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		final long[][] latticePoints = new long[21][21];

		for (int i = 0; i < 21; i++) {
			latticePoints[0][i] = 1;
			latticePoints[i][0] = 1;
		}

		for (int i = 1; i < 21; i++) {
			for (int j = 1; j < 21; j++) {
				latticePoints[i][j] = latticePoints[i][j - 1] + latticePoints[i - 1][j];
				// System.out.println(Arrays.toString(latticePoints[i]));
			}
		}

		System.out.println(latticePoints[20][20]);
	}
}
