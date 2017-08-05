package com.balaji.projecteuler.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total. If all the
 * numbers from 1 to 1000 (one thousand) inclusive were written out in words,
 * how many letters would be used? NOTE: Do not count spaces or hyphens. For
 * example, 342 (three hundred and forty-two) contains 23 letters and 115 (one
 * hundred and fifteen) contains 20 letters. The use of "and" when writing out
 * numbers is in compliance with British usage.
 * 
 * @author Balaji Rayakota
 */
public class Problem_17_NumberLetterCounts {
	/**
	 * The Map of numbers with their numeric names.
	 */
	public static final Map<Integer, String> numberNames = getNumberNames();

	/**
	 * Solution = 21124.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		int length = 0;
		for (int i = 1; i <= 1000; i++) {
			length += getNumberName(i).replaceAll(" ", "").length();
		}
		System.out.println(length);

		System.out.println(getNumberName(999579));
	}

	/**
	 * Calculates the name of number.
	 * 
	 * @param number
	 *           The integer (must be between 1 and 999999).
	 * @return A non-blank string.
	 */
	public static String getNumberName(final int number) {
		if (number < 1 || number > 999999) {
			throw new IllegalArgumentException("Number should be between 1 and 999999");
		}

		if (number < 100) {
			return getTensNumberName(number);
		}

		if (number < 1000) {
			return getHundredsNumberName(number);
		}

		return getThousandsNumberName(number);
	}

	/**
	 * Calculates the name of number between 1 and 99.
	 * 
	 * @param number
	 *           The number (must be between 1 and 99).
	 * @return A non-blank string.
	 */
	public static String getTensNumberName(final int number) {
		if (number < 0 || number > 99) {
			throw new IllegalArgumentException("Tens number should be between 1 and 99");
		}

		if (numberNames.get(number) != null) {
			return numberNames.get(number);
		}

		final int ones = Problem_4_LargestPalindromeProduct.getDigitAt(number, 0);
		final int tens = number - ones;

		return numberNames.get(tens) + " " + numberNames.get(ones);
	}

	/**
	 * Calculates the name of the number below and including 999.
	 * 
	 * @param number
	 *           The number must be less than 1000.
	 * @return A non-blank String.
	 */
	public static String getHundredsNumberName(final int number) {
		if (number > 999) {
			throw new IllegalArgumentException("Hundreds cannot process numbers greater than 999");
		}

		if (number < 100) {
			return getTensNumberName(number);
		}

		final int hundreds = Problem_4_LargestPalindromeProduct.getDigitAt(number, 2);
		final int tens = number - (hundreds * 100);

		final String suffix = tens == 0 ? "" : "and " + getTensNumberName(tens);

		return numberNames.get(hundreds) + " hundred " + suffix;
	}

	/**
	 * Calculates name of number between 1000 and 999999.
	 * 
	 * @param number
	 *           The number between 1000 and 999999.
	 * @return A non-blank String.
	 */
	public static String getThousandsNumberName(final int number) {
		if (number < 1000 || number > 999999) {
			throw new IllegalArgumentException("Thousands number must be between 1000 and 999999");
		}

		final int hundreds = number % 1000;
		final int thousands = (number - hundreds) / 1000;

		final String suffix = hundreds == 0 ? "" : getHundredsNumberName(hundreds);

		return getNumberName(thousands) + " thousand " + suffix;
	}

	/**
	 * Initialize the {@link #numberNames}
	 * 
	 * @return A non-null Map of String names keyed by Integer.
	 */
	public static Map<Integer, String> getNumberNames() {
		final Map<Integer, String> numberNamesInitialize = new HashMap<>();
		numberNamesInitialize.put(1, "one");
		numberNamesInitialize.put(2, "two");
		numberNamesInitialize.put(3, "three");
		numberNamesInitialize.put(4, "four");
		numberNamesInitialize.put(5, "five");
		numberNamesInitialize.put(6, "six");
		numberNamesInitialize.put(7, "seven");
		numberNamesInitialize.put(8, "eight");
		numberNamesInitialize.put(9, "nine");
		numberNamesInitialize.put(10, "ten");
		numberNamesInitialize.put(11, "eleven");
		numberNamesInitialize.put(12, "twelve");
		numberNamesInitialize.put(13, "thirteen");
		numberNamesInitialize.put(14, "fourteen");
		numberNamesInitialize.put(15, "fifteen");
		numberNamesInitialize.put(16, "sixteen");
		numberNamesInitialize.put(17, "seventeen");
		numberNamesInitialize.put(18, "eighteen");
		numberNamesInitialize.put(19, "nineteen");
		numberNamesInitialize.put(20, "twenty");
		numberNamesInitialize.put(30, "thirty");
		numberNamesInitialize.put(40, "forty");
		numberNamesInitialize.put(50, "fifty");
		numberNamesInitialize.put(60, "sixty");
		numberNamesInitialize.put(70, "seventy");
		numberNamesInitialize.put(80, "eighty");
		numberNamesInitialize.put(90, "ninety");

		return numberNamesInitialize;
	}
}
