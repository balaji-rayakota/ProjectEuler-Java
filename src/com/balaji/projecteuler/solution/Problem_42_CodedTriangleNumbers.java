package com.balaji.projecteuler.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1);
 * so the first ten triangle numbers are:<br>
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...<br>
 * By converting each letter in a word to a number corresponding to its
 * alphabetical position and adding these values we form a word value. For
 * example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value
 * is a triangle number then we shall call the word a triangle word.<br>
 * Using problem's data file, a 16K text file containing nearly two-thousand
 * common English words, how many are triangle words?
 * 
 * @author Balaji Rayakota
 */
public class Problem_42_CodedTriangleNumbers {
	/**
	 * Solution = .
	 * 
	 * @param args The String array with command line arguments.
	 * @throws IOException Thrown when data file cannot be read or accessed.
	 */
	public static void main(final String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader("./resources/Problem_42_CodedTriangleNumbers"));
		final String[] words = br.readLine().split(",");
		br.close();

		int triangleWordCount = 0;
		int max = 0;
		for (final String word : words) {
			final int n = isTriangleNumber(calculateWordValue(word));
			if (n > 0) {
				// System.out.println(word);
				triangleWordCount++;
				if (max < n) {
					max = n;
				}
			}
		}
		System.out.println("Triangle word count = " + triangleWordCount + "max = " + max);
		System.out.println(words[22]);
	}

	/**
	 * Calculates the word value by summing the alphabet values of characters
	 * present in word.
	 * 
	 * @param word The String word (cannot be blank).
	 * @return The integer word value.
	 */
	public static int calculateWordValue(final String word) {
		if (word == null || word.trim().length() == 0) {
			throw new IllegalArgumentException("Word cannot be blank");
		}

		// remove the quotes because the string retains the quotes from the file.
		final String trimmedWord = word.substring(1, word.length() - 1);
		System.out.println(trimmedWord);
		int value = 0;
		for (int i = 0; i < trimmedWord.length(); i++) {
			value += (trimmedWord.charAt(i) - 64);
		}

		return value;
	}

	/**
	 * Calculates if the given number is a triangle number.
	 * @param number The integer to be checked (must be positive).
	 * @return True iff number is a triangle number.
	 */
	public static int isTriangleNumber(final int number) {
		if (number < 1) {
			return 0;
		}

		int currentTriangleValue = 0;
		int index = 0;
		while (currentTriangleValue <= number) {
			index++;
			currentTriangleValue = (index * (index + 1)) / 2;
			if (number == currentTriangleValue) {
				return index;
			}
		}

		return 0;
	}
}
