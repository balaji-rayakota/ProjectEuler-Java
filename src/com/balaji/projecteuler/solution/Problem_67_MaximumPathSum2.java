package com.balaji.projecteuler.solution;

import java.io.IOException;

/**
 * Find the maximum total from top to bottom in the data file for this problem, a 15K text file containing a triangle with one-hundred rows.
 * @author Balaji Rayakota
 */
public class Problem_67_MaximumPathSum2
{
    /**
     * Solution = 7273.
     * @param args
     *            The String array with command line arguments.
     * @throws IOException
     *             if data file does not exist.
     */
    public static void main(final String[] args) throws IOException
    {
        Problem_18_MaximumPathSum1.maximumPathSum("./resources/Problem_67_MaximumPathSum2");
    }
}
