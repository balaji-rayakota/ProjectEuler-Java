package com.balaji.projecteuler.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The text data file contains over five-thousand first names, begin by sorting
 * it into alphabetical order. Then working out the alphabetical value for each
 * name, multiply this value by its alphabetical position in the list to obtain
 * a name score.<br>
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 × 53 = 49714.<br>
 * What is the total of all the name scores in the file?
 * 
 * @author Balaji Rayakota
 */
public class Problem_22_NamesScore {
	/**
	 * Solution = .
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 * @throws IOException
	 *            if the data file does not exist or if it cannot be read.
	 */
	public static void main(final String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader("./resources/Problem_22_NamesScores"));
		final String[] strings = br.readLine().split(",");
		br.close();

		for (int i = 0; i < strings.length; i++) {
			strings[i] = strings[i].substring(1, strings[i].length() - 1);
		}

		bubbleSort(strings);
		long totalScore = 0;
		for (int i = 0; i < strings.length; i++) {
			totalScore += stringScore(strings[i]) * (i + 1);
		}

		System.out.println("Names score = " + totalScore);
	}

	/**
	 * Sorts a String array with bubble sort.
	 * 
	 * @param strings
	 *           The String array to be sorted (cannot be null).
	 */
	public static void bubbleSort(final String[] strings) {
		if (strings == null) {
			throw new IllegalArgumentException("Null array of Strings was supplied");
		}

		for (int i = 1; i < strings.length; i++) {
			final String key = strings[i];
			int j = i;
			while (j > 0) {
				strings[j] = strings[j - 1];
				if (compare(key, strings[j]) > 0) {
					break;
				}
				j--;
			}
			strings[j] = key;
		}
	}

	/**
	 * Compares two Strings.
	 * 
	 * @param str1
	 *           First String to be compared (cannot be null).
	 * @param str2
	 *           Second String to be compared (cannot be null).
	 * @return 1, 0, -1 if str1 is greater than, equal to, and less than str2
	 *         respectively.
	 */
	public static int compare(final String str1, final String str2) {
		if (str1 == null || str2 == null) {
			throw new IllegalArgumentException("Strings should not be null. Strings = " + str1 + ", " + str2);
		}

		final int shortLength = Math.min(str1.length(), str2.length());

		for (int i = 0; i < shortLength; i++) {
			if (str1.charAt(i) < str2.charAt(i)) {
				return -1;
			}
			if (str1.charAt(i) > str2.charAt(i)) {
				return 1;
			}
		}

		if (str1.length() < str2.length()) {
			return -1;
		}

		if (str1.length() > str2.length()) {
			return 1;
		}

		return 0;
	}

	/**
	 * Calculates the score of a String.
	 * 
	 * @param str
	 *           The String (cannot be blank).
	 * @return The positive score of the String.
	 */
	public static int stringScore(final String str) {
		if (str == null || str.trim().length() == 0) {
			throw new IllegalArgumentException("Empty string was given.");
		}

		int score = 0;
		for (int i = 0; i < str.length(); i++) {

			score += (str.charAt(i) - 64);
		}

		return score;
	}
}
