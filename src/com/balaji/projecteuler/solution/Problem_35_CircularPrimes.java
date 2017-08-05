package com.balaji.projecteuler.solution;

import java.util.Arrays;

/**
 * The number, 197, is called a circular prime because all rotations of the
 * digits: 197, 971, and 719, are themselves prime.<br>
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71,
 * 73, 79, and 97.<br>
 * How many circular primes are there below one million?
 * 
 * @author Balaji Rayakota
 */
public class Problem_35_CircularPrimes {
	/**
	 * Solution = .
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		final boolean[] primes = createPrimeSieve(10000000);
		int numberOfCircularPrimes = 0;
		for (int i = 2; i < 1000000; i++) {
			if (isCircularPrime(i, primes)) {
				System.out.println(i);
				numberOfCircularPrimes++;
			}
		}
		System.out.println("Total number of circular primes below million = " + numberOfCircularPrimes);
	}

	/**
	 * Determines if a number is a circular prime given prime numbers.
	 * 
	 * @param number
	 *           The number to be checked for being circular prime (may be
	 *           negative).
	 * @param primes
	 *           The boolean array with a value being true only if the index is a
	 *           prime number, false otherwise (cannot be null).
	 * @return True iff number is a circular prime according to the given primes
	 *         boolean array.
	 */
	public static boolean isCircularPrime(final int number, final boolean[] primes) {
		if (primes == null) {
			throw new IllegalArgumentException("primes array was null");
		}

		if (!primes[number]) {
			return false;
		}

		final int[] digits = getDigits(number);

		for (int i = 1; i <= digits.length - 1; i++) {
			rotate(digits);
			final int newNumber = getNumber(digits);
			if (!primes[newNumber]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Creates a number form an array of digits.
	 * 
	 * @param digits
	 *           The array of integer with digits (may be null).
	 * @return The integer formed by digits.
	 */
	public static int getNumber(final int[] digits) {
		if (digits == null) {
			return 0;
		}
		int number = 0;
		for (int i = 0; i < digits.length; i++) {
			number = number + digits[i] * (int) Math.pow(10, i);
		}

		return number;
	}

	/**
	 * Rotates a number, represented by digit array, to the right by one position.
	 * 
	 * @param digits
	 *           the integer array which has digits (may be null).
	 * @return null if null digits is given otherwise non-null integer array.
	 */
	public static int[] rotate(final int[] digits) {
		if (digits == null) {
			return null;
		}
		final int lastDigit = digits[digits.length - 1];
		for (int i = digits.length - 2; i >= 0; i--) {
			digits[i + 1] = digits[i];
		}
		digits[0] = lastDigit;

		return digits;
	}

	/**
	 * Converts an integer to an array of integer digits.
	 * 
	 * @param number
	 *           The integer to be converted (must be positive).
	 * @return A non-null integer array.
	 */
	public static int[] getDigits(final int number) {
		if (number < 1) {
			throw new IllegalArgumentException("Number must be positive. number = " + number);
		}

		int copy = number;
		final int[] digits = new int[(int) Math.log10(number) + 1];
		int index = 0;
		while (copy != 0) {
			digits[index] = copy % 10;
			copy /= 10;
			index++;
		}

		return digits;
	}

	/**
	 * Creates a boolean array which has true only if index is a prime number.
	 * 
	 * @param limit
	 *           The limit to which primes have to be calculated (must be greater
	 *           than 1).
	 * @return A non-null boolean array.
	 */
	public static boolean[] createPrimeSieve(final int limit) {
		if (limit < 1) {
			throw new IllegalArgumentException("Limit must be greater than 1. limit = " + limit);
		}

		final boolean[] primeSieve = new boolean[limit + 1];
		Arrays.fill(primeSieve, true);
		primeSieve[0] = primeSieve[1] = false;

		for (int i = 2; i < primeSieve.length; i++) {
			if (primeSieve[i]) {
				for (int j = 2 * i; j < primeSieve.length; j += i) {
					primeSieve[j] = false;
				}
			}
		}

		return primeSieve;
	}
}
