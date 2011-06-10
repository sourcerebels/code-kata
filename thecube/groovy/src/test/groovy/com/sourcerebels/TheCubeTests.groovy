package com.sourcebels

import groovy.util.GroovyTestCase;

class TheCube {
	
	public boolean containsPrimeNumber(String code1, String code2, String code3) {
	
		if (isPrimeNumber(sumDigits(code1)) ||
			isPrimeNumber(sumDigits(code2)) ||
			isPrimeNumber(sumDigits(code3)) ) {
			return true
		}
		return false
	}
	
	def isPrimeNumber = { number ->
		
		def result = true
		(2..number - 1).each { previous ->
			if(number % previous == 0)
				result = false
			}
		return result
	}
	
	def toInteger = {
		
		Integer.valueOf(it)
	}
	
	def sumDigits = {
	
		code -> code.collect { toInteger(it) }.sum()
	}
}

class TheCubeTests extends GroovyTestCase {
	
	private TheCube theCube
	
	public void setUp() {
		theCube = new TheCube()
	}
	
	public void testShouldReturnFalse() {
		
		assertFalse theCube.containsPrimeNumber("6", "6", "6")
		
		assertFalse theCube.containsPrimeNumber("24", "44", "66")
	}
	
	public void testShouldReturnTrue() {
		
		assertTrue theCube.containsPrimeNumber("7", "6", "6")
		assertTrue theCube.containsPrimeNumber("6", "7", "6")
		assertTrue theCube.containsPrimeNumber("6", "6", "7")
		assertTrue theCube.containsPrimeNumber("6", "7", "7")
		assertTrue theCube.containsPrimeNumber("7", "7", "7")
		
		assertTrue theCube.containsPrimeNumber("6", "6", "43")
		assertTrue theCube.containsPrimeNumber("21", "6", "6")
		
		assertTrue theCube.containsPrimeNumber("34", "6", "6")
		assertTrue theCube.containsPrimeNumber("6", "34", "6")
	}
}
