package com.example.task10;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	private String numbers;

	public int add(String numbers) {
		if (!numbers.contains(",") && !numbers.isEmpty()) {
			return Integer.parseInt(numbers);
		} else if (numbers.isEmpty()) {
			return 0;
		} else {
			//List<String> list = new ArrayList<>();
			
			int temp = numbers.indexOf(",");
			int num1 = Integer.parseInt(numbers.substring(0, temp));
			int num2 = Integer.parseInt(numbers.substring(temp + 1));
			return num1 + num2;
		}
	}
}
