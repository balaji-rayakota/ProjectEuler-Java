package com.balaji.projecteuler.solution;

/**
 * An irrational decimal fraction is created by concatenating the positive
 * integers:<br>
 * 0.123456789101112131415161718192021...<br>
 * It can be seen that the 12th digit of the fractional part is 1.<br>
 * If d_n represents the nth digit of the fractional part, find the value of the
 * following expression.<br>
 * d_1 × d_10 × d_100 × d_1000 × d_10000 × d_100000 × d_1000000
 * 
 * @author Balaji Rayakota
 */
public class Problem_40_ChampernownesConstant {
	/**
	 * Solution = 210.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		final int d1 = getDigitAtPosition(1);
		System.out.println(d1);
		final int d10 = getDigitAtPosition(10);
		System.out.println(d10);
		final int d100 = getDigitAtPosition(100);
		System.out.println(d100);
		final int d1000 = getDigitAtPosition(1000);
		System.out.println(d1000);
		final int d10000 = getDigitAtPosition(10000);
		System.out.println(d10000);
		final int d100000 = getDigitAtPosition(100000);
		System.out.println(d100000);
		final int d1000000 = getDigitAtPosition(1000000);
		System.out.println(d1000000);

		System.out.println("Champernowner's Constant = " + (d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000));
	}

	/**
	 * Calculates the digit at the requested position for the irrational decimal
	 * fraction formed by positive integers.
	 * 
	 * @param position
	 *           The integer position (must be positive).
	 * @return The positive integer digit at requested position.
	 */
	public static int getDigitAtPosition(final int position) {
		if (position < 1) {
			throw new IllegalArgumentException("Position must be positive. position =" + position);
		}

		int currentPosition = 0;
		int currentNumber = 0;

		while (currentPosition < position) {
			currentNumber++;
			currentPosition += (int) Math.log10(currentNumber) + 1;
		}

		if (currentPosition == position) {
			return currentNumber % 10;
		}

		final int difference = currentPosition - position;
		int copy = currentNumber;
		for (int i = 0; i < difference; i++) {
			copy /= 10;
		}

		return copy % 10;
	}
}
