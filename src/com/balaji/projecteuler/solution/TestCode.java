package com.balaji.projecteuler.solution;

@SuppressWarnings("javadoc")
public class TestCode
{
    public static void main(final String[] args)
    {
        System.out.println(isPalindrome(1984563654891L));
    }

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

    public static int getDigitAt(final long number, final int position)
    {
        if (number < 0 || position > Math.floor(Math.log10(number)))
        {
            throw new IllegalArgumentException("Cannot find " + position + " digit for " + number);
        }

        // (int) ((number % (10 ^ (position + 1)) - number % (10 ^ position)) / (10 ^ position));

        return (int) (((number % (Math.pow(10, position + 1))) - number % (Math.pow(10, position))) / (Math.pow(10, position)));
    }
}
