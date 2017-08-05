package com.balaji.projecteuler.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1
 * through 5 pandigital.<br>
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing
 * multiplicand, multiplier, and product is 1 through 9 pandigital.<br>
 * Find the sum of all products whose multiplicand/multiplier/product identity
 * can be written as a 1 through 9 pandigital.
 * 
 * @author Balaji Rayakota
 */
public class Problem_32_PandigitalProducts {
	/**
	 * Solution = 45228.
	 * 
	 * @param args
	 *           The String array containing command line parameters.
	 */
	public static void main(final String[] args) {
		final int[] digits = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		final Set<Integer> products = new HashSet<>();
		do {
			for (int splitIndex = 0; splitIndex <= 3; splitIndex++) {
				final int[] numbers = split(digits, splitIndex, 4);

				if (numbers[0] * numbers[1] == numbers[2]) {
					System.out.println(numbers[0] + " * " + numbers[1] + " = " + numbers[2]);
					products.add(numbers[2]);
				}
			}
		} while (nextLexicographicPermutation(digits));

		int sum = 0;
		for (final Integer product : products) {
			sum += product;
		}

		System.out.println("Sum of products = " + sum);
	}

	/**
	 * Splits the supplied digits into three numbers such that digits[0..pos1] is
	 * first number, digits(pos1..pos2] is the second number, and
	 * digits(pos2..len-1] is the third number.
	 * 
	 * @param digits
	 *           The integer array with digits (cannot be null).
	 * @param pos1
	 *           The integer position.
	 * @param pos2
	 *           The integer position.
	 * @return A non-null array with three numbers.
	 */
	public static int[] split(final int[] digits, final int pos1, final int pos2) {
		final int[] numbers = new int[3];

		// digits[0..pos1] = multiplier
		int multiplier = 0;
		for (int i = 0; i <= pos1; i++) {
			multiplier = multiplier * 10 + digits[i];
		}
		numbers[0] = multiplier;

		// digits(pos1, pos2] = multiplicand
		int multiplicand = 0;
		for (int i = pos1 + 1; i <= pos2; i++) {
			multiplicand = multiplicand * 10 + digits[i];
		}
		numbers[1] = multiplicand;

		// digits(pos2..len-1] = product
		int product = 0;
		for (int i = pos2 + 1; i < digits.length; i++) {
			product = product * 10 + digits[i];
		}
		numbers[2] = product;
		return numbers;
	}

	/**
	 * Manipulates the digits of currentPosition to produce a permutation which will
	 * be the next lexicographic permutation.
	 * 
	 * @param currentPermutation
	 *           The integer array with current permutation(cannot be null).
	 * @return True if next permutation can be calculated, false otherwise.
	 */
	public static boolean nextLexicographicPermutation(final int[] currentPermutation) {
		if (currentPermutation == null) {
			throw new IllegalArgumentException("Supplied current permutation is null");
		}

		final int replacablePosition = calculateReplacablePosition(currentPermutation);

		if (replacablePosition < 0) {
			return false;
		}

		int replacingPosition = replacablePosition + 1;
		for (int i = replacablePosition + 1; i < currentPermutation.length; i++) {
			if (currentPermutation[replacablePosition] < currentPermutation[i]
					&& currentPermutation[replacingPosition] > currentPermutation[i]) {
				replacingPosition = i;
			}
		}

		// swap replacablePosition and replacing position
		final int temp = currentPermutation[replacablePosition];
		currentPermutation[replacablePosition] = currentPermutation[replacingPosition];
		currentPermutation[replacingPosition] = temp;

		// sort permutation[replacablePosition+1 .. len]
		Arrays.sort(currentPermutation, replacablePosition + 1, currentPermutation.length);

		return true;
	}

	private static int calculateReplacablePosition(final int[] currentPermutation) {
		if (currentPermutation.length <= 1) {
			return -1;
		}

		int index = currentPermutation.length - 2;

		while (index >= 0 && currentPermutation[index + 1] < currentPermutation[index]) {
			index--;
		}

		return index;
	}
}
