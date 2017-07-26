package com.balaji.projecteuler.solution;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a2 + b2 = c2 For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2. There
 * exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.
 * @author Balaji Rayakota
 */
public class Problem_9_SpecialPythagoreanTriplet
{
    /**
     * Solution = 31875000.
     * @param args
     *            The String array with command line arguments.
     */
    public static void main(final String[] args)
    {
        for (int a = 1; a <= 1000; a++)
        {
            for (int b = a + 1; b <= 1000; b++)
            {
                final int c = 1000 - a - b;
                if (c > b && (a * a + b * b == c * c))
                {
                    System.out.println("a = " + a + ", b = " + b + ", c = " + c + "; abc = " + a * b * c);
                }
            }
        }
    }
}
