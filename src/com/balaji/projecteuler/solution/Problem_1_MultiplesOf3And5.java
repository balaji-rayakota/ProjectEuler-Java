package com.balaji.projecteuler.solution;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of
 * all the multiples of 3 or 5 below 1000.
 * @author Balaji Rayakota
 */
public class Problem_1_MultiplesOf3And5
{
    /**
     * Solution = 233168.
     * @param args
     *            The String array with command line arguments.
     */
    public static void main(final String[] args)
    {
        long sum = 0;
        for (int mulThree = 3; mulThree < 1000; mulThree += 3)
        {
            sum += mulThree;
        }

        for (int mulFive = 5; mulFive < 1000; mulFive += 5)
        {
            if (mulFive % 3 != 0)
            {
                sum += mulFive;
            }
        }

        System.out.println(sum);
    }
}
