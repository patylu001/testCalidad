package com.fca.calidad.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {
	
	private Calculadora cal;
	
	@Before
	public void inicializar()
	{
		cal = new Calculadora();
	}

	
	@Test
	public void sumaTest() {
		
		//Ejercicio del código
		float resultadoEjecucion = cal.suma(2, 2);
		float resultadoEsperado = 4.0f;
		
		//Verificación
		assertEquals(resultadoEsperado, resultadoEjecucion,0.01);
		
	}
	

}
