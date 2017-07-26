package com.balaji.projecteuler.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
 * @author Balaji Rayakota
 */
public class Problem_8_LargestProductInASeries
{
    /**
     * Solution = 23514624000.
     * @param args
     *            The String array with command line arguments.
     * @throws IOException
     *             if the problem data file does not exist.
     */
    public static void main(final String[] args) throws IOException
    {
        final BufferedReader br = new BufferedReader(new FileReader("./resources/Problem_8_LargestProductInASeries"));
        final int[] numbers = new int[1000];
        int index = 0;

        for (String line = br.readLine(); line != null; line = br.readLine())
        {
            for (int lineIndex = 0; lineIndex < line.length(); lineIndex++)
            {
                numbers[index] = Character.getNumericValue(line.charAt(lineIndex));
                index++;
            }
        }
        br.close();

        long max = 0;
        for (int first = 0; first < 1000 - 13; first++)
        {
            final int last = first + 12;
            long product = 1;
            for (int position = first; position <= last; position++)
            {
                product *= numbers[position];
            }

            if (product > max)
            {
                max = product;
            }
        }

        System.out.println(max);
    }
}
