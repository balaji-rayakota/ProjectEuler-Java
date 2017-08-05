package com.balaji.projecteuler.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * What is the greatest product of four adjacent numbers in the same direction
 * (up, down, left, right, or diagonally) in the 20×20 grid?
 * 
 * @author Balaji Rayakota
 */
public class Problem_11_LargestProductInAGrid {
	/**
	 * Solution = 70600674 (numbers = 87, 97, 94, 89)
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 * @throws IOException
	 *            if file does not exist.
	 */
	public static void main(final String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader("./resources/Problem_11_LargestProductInAGrid"));
		final int[][] numbers = new int[20][20];
		final int[] points = new int[4];

		int index = 0;
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			final int[] lineOfNumbers = numbers[index];
			final String[] stringNumbers = line.split(" ");
			for (int i = 0; i < 20; i++) {
				lineOfNumbers[i] = Integer.parseInt(stringNumbers[i]);
			}
			index++;
		}
		br.close();

		long max = 0;

		// Right max.
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 17; j++) {
				final long product = numbers[i][j] * numbers[i][j + 1] * numbers[i][j + 2] * numbers[i][j + 3];
				if (max < product) {
					max = product;
					points[0] = numbers[i][j];
					points[1] = numbers[i][j + 1];
					points[2] = numbers[i][j + 2];
					points[3] = numbers[i][j + 3];
				}
			}
		}

		System.out.println(max);
		System.out.println(Arrays.toString(points));
		// Down max.
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 17; j++) {
				final long product = numbers[j][i] * numbers[j + 1][i] * numbers[j + 2][i] * numbers[j + 3][i];
				if (max < product) {
					max = product;
					points[0] = numbers[j][i];
					points[1] = numbers[j + 1][i];
					points[2] = numbers[j + 2][i];
					points[3] = numbers[j + 3][i];
				}
			}
		}
		System.out.println(max);
		System.out.println(Arrays.toString(points));

		// downward diagonal max.
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 17; j++) {
				final long product = numbers[i][j] * numbers[i + 1][j + 1] * numbers[i + 2][j + 2] * numbers[i + 3][j + 3];
				if (max < product) {
					max = product;
					points[0] = numbers[i][j];
					points[1] = numbers[i + 1][j + 1];
					points[2] = numbers[i + 2][j + 2];
					points[3] = numbers[i + 3][j + 3];
				}
			}
		}

		System.out.println(max);
		System.out.println(Arrays.toString(points));

		// upward diagonal max.
		for (int i = 19; i > 2; i--) {
			for (int j = 0; j < 17; j++) {
				final long product = numbers[i][j] * numbers[i - 1][j + 1] * numbers[i - 2][j + 2] * numbers[i - 3][j + 3];
				if (max < product) {
					max = product;
					points[0] = numbers[i][j];
					points[1] = numbers[i - 1][j + 1];
					points[2] = numbers[i - 2][j + 2];
					points[3] = numbers[i - 3][j + 3];
				}
			}
		}
		System.out.println(max);
		System.out.println(Arrays.toString(points));
	}
}
