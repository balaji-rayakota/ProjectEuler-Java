package com.balaji.projecteuler.solution;

import java.util.Arrays;

/**
 * Considering quadratics of the form: n^2+an+b, where |a|<1000|a|<1000 and |b|≤1000 <br>
 * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n,
 * starting with n=0.
 * @author Balaji Rayakota
 */
public class Problem_27_QuadraticPrimes
{
    /**
     * Solution = -59231.
     * @param args
     *            The String array with command line arguments.
     */
    public static void main(final String[] args)
    {
        final int[] bArray = getPrimes(1000);
        // System.out.println(Arrays.toString(b));

        int max = 0;
        int a_max = 0;
        int b_max = 0;
        for (int a = -999; a < 1000; a++)
        {
            for (int index = 0; index < bArray.length; index++)
            {
                int n = 0;
                while (isPrime(n * n + a * n + bArray[index]))
                {
                    n++;
                }
                if (max < n)
                {
                    max = n;
                    a_max = a;
                    b_max = bArray[index];
                }
            }
        }
        System.out.println(String.format("maximum primes = %d for a = %d and b = %d, a*b = %d", max, a_max, b_max, a_max * b_max));
    }

    /**
     * Calculates the primes that are less than or equal to max.
     * @param max
     *            The maximum integer till which primes are to be calculated(must be positive).
     * @return A non-null integer array.
     */
    public static int[] getPrimes(final int max)
    {
        if (max < 1)
        {
            throw new IllegalArgumentException("Supplied max value is non-positive. max = " + max);
        }

        final boolean[] sieve = new boolean[max + 1];
        Arrays.fill(sieve, true);

        int size = 0;
        for (int i = 2; i <= max; i++)
        {
            if (sieve[i])
            {
                // System.out.println(i);
                size++;
                for (int j = i * 2; j <= max; j += i)
                {
                    sieve[j] = false;
                }
            }
        }

        final int[] primes = new int[size];
        int index = 0;
        for (int i = 2; i <= max; i++)
        {
            if (sieve[i])
            {
                primes[index++] = i;
            }
        }
        return primes;
    }

    /**
     * Calculates if the supplied number is prime or not.
     * @param n
     *            The number to be checked.
     * @return True iff n is prime.
     */
    public static boolean isPrime(final int n)
    {
        if (n < 2)
        {
            return false;
        }

        for (int i = 2; i <= n / 2; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
