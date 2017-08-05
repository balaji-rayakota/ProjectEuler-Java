package com.balaji.projecteuler.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * By starting at the top of the triangle and moving to adjacent numbers on the
 * row below find the maximum total from top to bottom of the triangle given in
 * data file corresponding to this problem.
 * 
 * @author Balaji Rayakota
 */
public class Problem_18_MaximumPathSum1 {
	/**
	 * Solution = 1074.
	 * 
	 * @param args The String array with command line arguments.
	 * @throws IOException If the data file does not exist or cannot be read.
	 */
	public static void main(final String[] args) throws IOException {
		maximumPathSum("./resources/Problem_18_MaximumPathSum1");
	}

	/**
	 * Solves the maximum path sum problem given the file path for file with data.
	 * 
	 * @param path The String path of file with data.
	 * @throws IOException if file does not exist.
	 */
	public static void maximumPathSum(final String path) throws IOException {
		if (path == null || path.trim().length() == 0) {
			throw new IllegalArgumentException("Path cannot be blank");
		}

		final BufferedReader bf = new BufferedReader(new FileReader(path));
		final int numberOfLines = getNumberOfLinesInFile(path);
		final int[][] triangle = getTriangle(numberOfLines);
		int index = 0;

		for (String line = bf.readLine(); line != null; line = bf.readLine()) {
			final String[] stringNumbers = line.split(" ");
			for (int i = 0; i <= index; i++) {
				triangle[index][i] = Integer.parseInt(stringNumbers[i]);
			}
			index++;
		}
		bf.close();

		for (int i = numberOfLines - 2; i >= 0; i--) {
			for (int j = 0; j < triangle[i].length; j++) {
				triangle[i][j] = triangle[i][j] + Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
			}
		}

		System.out.println(triangle[0][0]);
	}

	/**
	 * Calculates the number of lines in a file.
	 * 
	 * @param path The String path of the file (cannot be blank).
	 * @return the integer number of lines in the file.
	 * @throws IOException if file does not exist.
	 */
	public static int getNumberOfLinesInFile(final String path) throws IOException {
		if (path == null || path.trim().length() == 0) {
			throw new IllegalArgumentException("Path cannot be blank");
		}

		final LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(path));

		for (String line = lineNumberReader.readLine(); line != null; line = lineNumberReader.readLine()) {
			// calculates the number of lines in a file.
		}

		final int numberOfLines = lineNumberReader.getLineNumber();
		lineNumberReader.close();
		return numberOfLines;
	}

	/**
	 * Creates a triangle integer array.
	 * 
	 * @param size the size of the array to be created (must be positive).
	 * @return A non-null two dimensional integer array.
	 */
	public static int[][] getTriangle(final int size) {
		if (size < 1) {
			throw new IllegalArgumentException("Size for trigngle array must be positive");
		}

		final int[][] triangle = new int[size][];

		for (int i = 0; i < size; i++) {
			triangle[i] = new int[i + 1];
		}

		return triangle;
	}
}
