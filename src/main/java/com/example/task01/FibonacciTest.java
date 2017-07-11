package com.example.task01;

import org.junit.Test;

import org.junit.Assert;

public class FibonacciTest {

	@Test
	public void testFibonacci() {
		Fibonacci fib = new Fibonacci();
		int test = fib.fibonacci(6);
		int results = 8;
		
		Assert.assertEquals(results, test);
	}
	
	public void shouldReturnOneForTwo() {
		//given
		Fibonacci fib = new Fibonacci();
		//when
		int test = fib.fibonacci(2);
		//then
		int results = 1;
		
		Assert.assertEquals(results, test);

}
	public void shouldReturn34For9(){
		Fibonacci fib = new Fibonacci();
		int test = fib.fibonacci(9);
		int result = 34;
		Assert.assertEquals(result, test);
	}
}