package com.balaji.projecteuler.solution;

/**
 * The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain prime
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.<br>
 * Find the sum of the only eleven primes that are both truncatable from left to
 * right and right to left.<br>
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.<br>
 * 
 * @author Balaji Rayakota
 */
public class Problem_37_TruncatablePrimes {
	private static boolean[] primes = Problem_35_CircularPrimes.createPrimeSieve(1000000);

	/**
	 * Solution = .
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		int sumOfTruncatablePrimes = 0;
		int numberOfTruncatablePrimes = 0;
		for (int i = 10; i <= 1000000; i++) {
			if (isTruncatablePrime(i)) {
				System.out.println(i);
				sumOfTruncatablePrimes += i;
				numberOfTruncatablePrimes++;
			}
			if (numberOfTruncatablePrimes == 11) {
				break;
			}
		}

		System.out.println("Sum of truncatable primes = " + sumOfTruncatablePrimes);
	}

	/**
	 * Calculates if a number is truncatable prime or not.
	 * 
	 * @param number
	 *           The integer number that has to be checked (must be at least 10).
	 * @return True iff number is truncatable prime.
	 */
	public static boolean isTruncatablePrime(final int number) {
		if (number < 10) {
			return false;
		}

		final String stringInteger = Integer.toString(number);
		for (int i = 0; i < stringInteger.length(); i++) {
			final int leftTruncated = Integer.parseInt(stringInteger.substring(i, stringInteger.length()));
			final int rightTruncated = Integer.parseInt(stringInteger.substring(0, stringInteger.length() - i));

			if (!primes[leftTruncated] || !primes[rightTruncated]) {
				return false;
			}
		}

		return true;
	}
}
