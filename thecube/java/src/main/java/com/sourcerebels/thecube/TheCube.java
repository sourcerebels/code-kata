package com.sourcerebels.thecube;

import static org.apache.commons.lang.CharUtils.*;

public class TheCube {

	public boolean containsPrimeNumber(String code1, String code2, String code3) {

		return isPrimeNumber(sumDigits(code1))
				|| isPrimeNumber(sumDigits(code2))
				|| isPrimeNumber(sumDigits(code3));
	}

	private boolean isPrimeNumber(int number) {

		boolean result = false;
		if (!isZeroOrOne(number)) {
			for (int i = number - 1; i > 1; i--) {
				if (number % i == 0) {
					return false;
				}
			}
			result = true;
		}
		return result;
	}

	private boolean isZeroOrOne(int number) {
		return number == 0 || number == 1;
	}

	private int sumDigits(String code) {

		int result = 0;
		for (int i = 0; i < code.length(); i++) {
			result += toIntValue(code.charAt(i));
		}
		return result;
	}
}
