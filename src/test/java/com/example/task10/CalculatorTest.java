package com.example.task10;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void shouldReturn0WhenEmptyString() {
		// given
		StringCalculator sut = new StringCalculator();
		// when
		int result = sut.add("");
		// then
		assertEquals(0, result);
	}

	@Test
	public void shouldReturnSameNumberWhenOneNumber() {
		// given
		StringCalculator sut = new StringCalculator();
		// when
		int result = sut.add("34");
		// then
		assertEquals(34, result);
	}
	
	@Test
	public void shouldReturnSumOfNumbersGivenInString() {
		// given
		StringCalculator sut = new StringCalculator();
		// when
		int result = sut.add("3,3");
		// then
		assertEquals(6, result);
	}
}
