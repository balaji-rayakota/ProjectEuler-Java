package com.balaji.projecteuler.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Work out the first ten digits of the sum of the one-hundred 50-digit numbers
 * in resource file.
 * 
 * @author Balaji Rayakota
 */
public class Problem_13_LargeSum {
	/**
	 * Solution = 5537376230
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 * @throws IOException
	 *            if the file does not exist.
	 */
	public static void main(final String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader("./resources/Problem_13_LargeSum"));
		final int[][] numbers = new int[100][50];
		int index = 0;

		for (String line = br.readLine(); line != null; line = br.readLine()) {
			for (int i = 0; i < line.length(); i++) {
				numbers[index][i] = Character.getNumericValue(line.charAt(i));
			}
			index++;
		}
		br.close();

		final int[] result = new int[51];
		int carry = 0;
		for (int i = 49; i >= 0; i--) {
			int tempSum = carry;
			for (int j = 0; j < 100; j++) {
				tempSum += numbers[j][i];
			}

			result[i + 1] = Problem_4_LargestPalindromeProduct.getDigitAt(tempSum, 0);
			carry = tempSum / 10;
		}
		result[0] = carry;
		System.out.println(Arrays.toString(result));
	}
}
