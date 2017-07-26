package com.balaji.projecteuler.solution;

import java.util.Arrays;

/**
 * Find the sum of the digits in the number 100!
 * @author Balaji Rayakota
 */
public class Problem_20_FactorialDigitSum
{
    /**
     * Solution = 648.
     * @param args
     *            The String array with command line arguments.
     */
    public static void main(final String[] args)
    {
        final int[] digits = new int[1000];
        // initial state of 1
        digits[0] = 1;

        int carry = 0;
        int scanTill = 0;
        for (int j = 2; j <= 100; j++)
        {
            for (int i = 0; i <= scanTill; i++)
            {
                final int tempProduct = digits[i] * j + carry;
                digits[i] = tempProduct == 0 ? 0 : Problem_4_LargestPalindromeProduct.getDigitAt(tempProduct, 0);
                carry = tempProduct / 10;

                if (i == scanTill && carry != 0)
                {
                    scanTill += (Math.floor(Math.log10(carry)) + 1);
                }
            }
            System.out.println(Arrays.toString(digits));
            System.out.println(scanTill);
        }

        int sum = 0;
        for (final int a : digits)
        {
            sum += a;
        }

        System.out.println("sum of digits = " + sum);
    }
}
