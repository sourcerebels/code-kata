package com.sourcerebels.thecube;

import junit.framework.Assert;

import org.junit.Test;

public class TheCubeTest {

	@Test
	public void testContainsPrimeNumber() {
		
		TheCube aCube = new TheCube();
		Assert.assertFalse(aCube.containsPrimeNumber("1", "1", "1"));
		Assert.assertTrue(aCube.containsPrimeNumber("111", "1", "1"));
		Assert.assertTrue(aCube.containsPrimeNumber("1", "111", "1"));
		Assert.assertTrue(aCube.containsPrimeNumber("1", "32", "1"));
		Assert.assertTrue(aCube.containsPrimeNumber("1", "1", "5"));
		Assert.assertTrue(aCube.containsPrimeNumber("1", "1", "7"));
		Assert.assertTrue(aCube.containsPrimeNumber("1", "1", "67"));
		Assert.assertFalse(aCube.containsPrimeNumber("1", "1", "0"));
	}
}
