package com.balaji.projecteuler.solution;

import java.util.Arrays;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the
 * permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:<br>
 * 012 021 102 120 201 210<br>
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * @author Balaji Rayakota
 */
public class Problem_24_LexicographicPermutations
{
    /**
     * Solution = 2783915604.
     * @param args
     *            The String array with command line arguments.
     */
    public static void main(final String[] args)
    {
        final long start = System.currentTimeMillis();
        final int[] permutation = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        final int finalPosition = 1000000;

        for (int currentPosition = 1; currentPosition <= finalPosition; currentPosition++)
        {
            // System.out.println(String.format("%4d = %s", currentPosition, Arrays.toString(permutation)));
            final int replacablePosition = calculateReplacablePosition(permutation);

            if (replacablePosition < 0)
            {
                System.out.println("Reached the end!");
                break;
            }
            produceNextPermutation(permutation, replacablePosition);
        }
        System.out.println(Arrays.toString(permutation));
        final long stop = System.currentTimeMillis();
        System.out.println("Time to compute = " + (stop - start) + " ms");
    }

    private static int calculateReplacablePosition(final int[] permutation)
    {
        for (int i = permutation.length - 1; i > 0; i--)
        {
            if (permutation[i] > permutation[i - 1])
            {
                return i - 1;
            }
        }

        return -1;
    }

    private static void produceNextPermutation(final int[] permutation, final int replacablePosition)
    {
        int replacingPosition = replacablePosition + 1;
        for (int i = replacablePosition + 1; i < permutation.length; i++)
        {
            if (permutation[replacablePosition] < permutation[i] && permutation[replacingPosition] > permutation[i])
            {
                replacingPosition = i;
            }
        }

        // swap replacablePosition and replacing position
        final int temp = permutation[replacablePosition];
        permutation[replacablePosition] = permutation[replacingPosition];
        permutation[replacingPosition] = temp;

        // sort permutation[replacablePosition+1 .. len]
        Arrays.sort(permutation, replacablePosition + 1, permutation.length);
    }
}
