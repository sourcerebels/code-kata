package com.sourcerebels.kata

import org.junit.Test
import org.junit.Before

import static org.junit.Assert.*

class StringCalculatorTests {

	private StringCalculator calculator

	@Before
	public void setUp() {

		calculator = new StringCalculator()
	}

	@Test
	public void cuandoRecibeStringVacioDeberiaDevolverCero() {

		assertEquals 0, calculator.add("")
	}
	
	@Test
	public void cuandoRecibeUnaCifraDeberiaDevolverla() {
		
		assertEquals 1, calculator.add("1")
		assertEquals 2, calculator.add("2")
		assertEquals 10, calculator.add("10")
		assertEquals 100, calculator.add("100")
		assertEquals 9999, calculator.add("9999")
	}
	
	@Test
	public void cuandoRecibeDosCifrasSeparadasPorComasDeberiaSumarlas() {
		
		assertEquals 5, calculator.add("2,3")
		assertEquals 52, calculator.add("32,20")
		assertEquals 2000, calculator.add("1500,500")
	}
	
	@Test
	public void cuandoRecibeTresCifrasSeparadasPorComasDeberiaSumarlas() {
		
		assertEquals 0, calculator.add("0,0,0")
		assertEquals 3, calculator.add("1,1,1")
		assertEquals 6, calculator.add("1,2,3")
		assertEquals 255, calculator.add("200,50,5")
	}
	
	@Test
	public void cuandoRecibeSaltoDeLineaEnLugarDeComaDeberiaSumarlas() {
		
		assertEquals 5, calculator.add("2\n3")
	}
	
	@Test
	public void cuandoMezclamosSaltosDeLineaYComasDeberiaSumarlas() {
		
		assertEquals 255, calculator.add("200\n50,5")
	}
	
	@Test
	public void cuandoIndicamosUnDelimitadorDeberiaSumarlas() {
		
		assertEquals 5, calculator.add("//;\n2;3")
	}
	
	@Test
	public void cuandoIndicamosNegativosGeneraExcepcion() {
		
		try {
		
			calculator.add "-2,-1,0"
			fail "An exception is expected"
				
		} catch (NumberFormatException e) {
		
			assertEquals e.getMessage(), "[-2, -1]"
		}
	}
}


