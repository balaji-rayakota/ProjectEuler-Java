package com.balaji.projecteuler.solution;

/**
 * The decimal number, 585 = 1001001001 (binary), is palindromic in both
 * bases.<br>
 * Find the sum of all numbers, less than one million, which are palindromic in
 * base 10 and base 2.<br>
 * (Please note that the palindromic number, in either base, may not include
 * leading zeros.)
 * 
 * @author Balaji Rayakota
 */
public class Problem_36_DoubleBasePalindromes {
	/**
	 * Solution = 872187.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		int sum = 0;
		for (int i = 1; i < 1000000; i++) {
			if (isStringPalindrome(Integer.toBinaryString(i)) && isStringPalindrome(Integer.toString(i))) {
				System.out.println(Integer.toBinaryString(i));
				sum += i;
			}
		}

		System.out.println("Sum of double base palindromes = " + sum);
	}

	/**
	 * Calculates if the supplied String is palindrome.
	 * 
	 * @param str
	 *           The String to be checked (cannot be blank).
	 * @return True iff str is palindrome.
	 */
	public static boolean isStringPalindrome(final String str) {
		if (str == null || str.trim().length() == 0) {
			throw new IllegalArgumentException("String should not be null. str = " + str);
		}

		for (int i = 0; i <= str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
