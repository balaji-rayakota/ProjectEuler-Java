package com.balaji.projecteuler.solution;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b,
 * then a and b are an amicable pair and each of a and b are called amicable numbers.<br>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1,
 * 2, 4, 71 and 142; so d(284) = 220.<br>
 * Evaluate the sum of all the amicable numbers under 10000.
 * @author Balaji Rayakota
 */
public class Problem_21_AmicableNumbers
{
    /**
     * Solution = 31626.
     * @param args
     *            The String array with command line arguments.
     */
    public static void main(final String[] args)
    {
        int sum = 0;
        for (int i = 2; i < 10000; i++)
        {
            if (isAmicableNumber(i))
            {
                System.out.println(i);
                sum += i;
            }
        }

        System.out.println("Sum = " + sum);
    }

    /**
     * Calculates if the given number is an amicable number or not.
     * @param number
     *            The number to be tested (must be greater than 1).
     * @return True iff number is amicable number.
     */
    public static boolean isAmicableNumber(final int number)
    {
        if (number < 2)
        {
            throw new IllegalArgumentException("Number must be greater than 1. number = " + number);
        }

        final int d_number = getSumOfProperDivisors(number);
        if ((d_number != 1) && (d_number != number) && (number == getSumOfProperDivisors(d_number)))
        {
            return true;
        }
        return false;
    }

    /**
     * Calculates sum of all proper divisors of a number.
     * @param number
     *            The number (must be greater than 1).
     * @return The sum of all proper divisors.
     */
    public static int getSumOfProperDivisors(final int number)
    {
        if (number < 2)
        {
            throw new IllegalArgumentException("Number must be greater than 1. number = " + number);
        }

        int sum = 1;
        for (int i = 2; i <= number / 2; i++)
        {
            if (number % i == 0)
            {
                sum += i;
            }
        }

        return sum;
    }
}
