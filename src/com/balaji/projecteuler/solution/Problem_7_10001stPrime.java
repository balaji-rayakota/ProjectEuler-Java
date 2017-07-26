package com.balaji.projecteuler.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13. What is the 10 001st prime number?
 * @author Balaji Rayakota
 */
public class Problem_7_10001stPrime
{
    /**
     * Solution =
     * @param args
     *            The String array with command line arguments.
     */
    public static void main(final String[] args)
    {
        final int size = 10001;
        final List<Long> primes = new ArrayList<>(size);
        primes.add(2L);
        long nextPrime = 3;

        while (primes.size() != 10001)
        {
            if (notDivisibleByAny(nextPrime, primes))
            {
                primes.add(nextPrime);
            }
            nextPrime++;
        }
        System.out.println(primes.get(size - 1));
    }

    /**
     * Checks if number is divisible by any number in divisors.
     * @param number
     *            The long number to be checked (must be positive).
     * @param divisors
     *            The List of Long divisors to be checked against (must not be null, may be empty).
     * @return True iff number is not divisible by any number in divisors.
     */
    public static boolean notDivisibleByAny(final long number, final List<Long> divisors)
    {
        if (number < 2 || divisors == null)
        {
            throw new IllegalArgumentException("Number must be positive and divisors must be non-null");
        }

        for (final Long divisor : divisors)
        {
            if (number % divisor == 0)
            {
                return false;
            }
        }

        return true;
    }
}
