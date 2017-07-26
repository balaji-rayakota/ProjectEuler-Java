package com.balaji.projecteuler.solution;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99. Find the
 * largest palindrome made from the product of two 3-digit numbers.
 * @author Balaji Rayakota
 */
public class Problem_4_LargestPalindromeProduct
{
    /**
     * Solution = 906609.
     * @param args
     *            The String array with command line arguments.
     */
    public static void main(final String[] args)
    {
        long max = 0;
        for (long a = 999; a > 99; a--)
        {
            for (long b = a; b > 99; b--)
            {
                final long product = a * b;
                if (isPalindrome(product))
                {
                    max = Math.max(max, product);
                    System.out.println(a + " * " + b + " = " + product);
                }
            }
        }
        System.out.println("maximum palindrom = " + max);
    }

    /**
     * Checks if supplied number is a palindrome nubmer or not.
     * @param number
     *            The number to be tested.
     * @return True iff number is palindrome.
     */
    public static boolean isPalindrome(final long number)
    {
        if (number < 0)
        {
            return false;
        }

        final int numberOfDigits = (int) Math.floor(Math.log10(number));

        for (int frontPosition = numberOfDigits; frontPosition >= numberOfDigits / 2; frontPosition--)
        {
            final int backPosition = numberOfDigits - frontPosition;
            if (getDigitAt(number, frontPosition) != getDigitAt(number, backPosition))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Gets the digit at supplied position.
     * @param number
     *            The number from which digit has to be extracted (must be positive).
     * @param position
     *            The position to be extracted (must be positive and less than number of digits in number).
     * @return an integer.
     */
    public static int getDigitAt(final long number, final int position)
    {
        if (number < 0 || position < 0 || position > Math.floor(Math.log10(number)))
        {
            throw new IllegalArgumentException("Cannot find " + position + " digit for " + number);
        }

        return (int) (((number % (Math.pow(10, position + 1))) - number % (Math.pow(10, position))) / (Math.pow(10, position)));
    }
}
