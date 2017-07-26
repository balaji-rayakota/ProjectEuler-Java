package com.balaji.projecteuler.solution;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime factor of the number 600851475143 ?
 * @author Balaji Rayakota
 */
public class Problem_3_LargestPrimeFactor
{
    /**
     * Solution = 6857.
     * @param args
     *            The String array with command line arguments.
     */
    public static void main(final String[] args)
    {
        long num = 600851475143L;
        long primeFactor = 1;

        while (num != 1)
        {
            if (num % primeFactor == 0)
            {
                num /= primeFactor;
                System.out.println(primeFactor);
            }
            primeFactor++;
        }
    }
}
