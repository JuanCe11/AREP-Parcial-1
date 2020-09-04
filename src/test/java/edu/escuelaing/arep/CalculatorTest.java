package edu.escuelaing.arep;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.escuelaing.arep.tools.Calculator;
import edu.escuelaing.arep.tools.LectorArchivos;

/**
 * Unit test for simple App.
 */
public class CalculatorTest 
{
	/**
	 * Test that calculates the mean with example 1.
	 */
	@Test
	public void shouldCalculateMean() {
		
		double[] lda_values;
		
		lda_values = LectorArchivos.leerArchivo("ejemplo.txt");
		
		assertTrue(Calculator.mean(lda_values) == (double)638.9);
		
	}
	
	/**
	 * Test that calculates the mean with proxy size example.
	 */
	@Test
	public void shouldCalculateMeanEstimateProxySize() {
		
		double[] lda_values;
		
		lda_values = LectorArchivos.leerArchivo("proxy.txt");
		
		assertTrue(Calculator.mean(lda_values) == (double)550.6);
		
	}
	
	/**
	 * Test that calculates the mean with development hours example.
	 */
	@Test
	public void shouldCalculateMeanDevelopmentHours() {
		
		double[] lda_values;
		
		lda_values = LectorArchivos.leerArchivo("development.txt");	
		
		{
			double ld_answer;
			
			ld_answer = Calculator.mean(lda_values);
			ld_answer = (double) Math.round(ld_answer * 100) / 100;
					
			assertTrue(ld_answer == (double)60.32);
		}
		
	}
	
	/**
	 * Test that calculates the standar deviation with example 1.
	 */
	@Test
	public void shouldCalculateDeviation() {
		
		double[] lda_values;
		
		lda_values = LectorArchivos.leerArchivo("ejemplo.txt");
		
		{
			double ld_answer;
			
			ld_answer = Calculator.standardDeviation(lda_values);
			ld_answer = (double) Math.round(ld_answer * 1000000) / 1000000;
			
			assertTrue(ld_answer == (double)625.633981);
		}
		
		
	}
	
	/**
	 * Test that calculates the standar deviation with proxy size example.
	 */
	@Test
	public void shouldCalculateDeviationEstimateProxySize() {
		
		double[] lda_values;
		
		lda_values = LectorArchivos.leerArchivo("proxy.txt");
		
		{
			double ld_answer;
			
			ld_answer = Calculator.standardDeviation(lda_values);
			ld_answer = (double) Math.round(ld_answer * 100) / 100;
			
			assertTrue(ld_answer == (double)572.03);
		}
		
		
	}
	
	/**
	 * Test that calculates the standar deviation with development hours example.
	 */
	@Test
	public void shouldCalculateDeviationDevelopmentHours() {
		
		double[] lda_values;
		
		lda_values = LectorArchivos.leerArchivo("development.txt");	
		
		{
			double ld_answer;
			
			ld_answer = Calculator.standardDeviation(lda_values);
			ld_answer = (double) Math.round(ld_answer * 100) / 100;
					
			assertTrue(ld_answer == (double)62.26);
		}
		
	}

}