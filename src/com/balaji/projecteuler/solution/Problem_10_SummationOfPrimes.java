package com.balaji.projecteuler.solution;

import static com.balaji.projecteuler.solution.Problem_7_10001stPrime.notDivisibleByAny;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17. Find the sum of all the
 * primes below two million.
 * 
 * @author Balaji Rayakota
 */
public class Problem_10_SummationOfPrimes {
	/**
	 * Solution = 142913828922.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		final long startMillS = System.currentTimeMillis();

		final int size = 2000001;
		final int limit = (int) Math.ceil(Math.sqrt(size));
		final boolean[] sieve = new boolean[size];
		Arrays.fill(sieve, true);
		sieve[0] = sieve[1] = false;

		for (int i = 2; i < limit; i++) {
			if (sieve[i] == true) {
				int stepIndex = 2 * i;
				while (stepIndex < sieve.length) {
					sieve[stepIndex] = false;
					stepIndex += i;
				}
			}
		}

		long sum = 0;
		for (int i = 0; i < sieve.length; i++) {
			if (sieve[i]) {
				sum += i;
			}
		}

		System.out.println(sum);
		final long stopMillS = System.currentTimeMillis();
		System.out.println("Took " + (stopMillS - startMillS) + " ms");
	}

	@SuppressWarnings("javadoc")
	public void slowerMethod() {
		final List<Long> primes = new ArrayList<>();
		primes.add(2L);

		long nextPrime = 3;
		long primeSum = 2;

		while (nextPrime < 2000000) {
			if (notDivisibleByAny(nextPrime, primes)) {
				primeSum += nextPrime;
				primes.add(nextPrime);
				System.out.println(nextPrime);
			}
			nextPrime++;
		}

		System.out.println(primeSum);
	}
}
