package com.arm;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.arm.exception.ValidatorException;

/**
 * Main class. StringCalculator is an application created to analyze one string,
 * extract the numeric values and return an integer that represents the sum of
 * the numeric values.
 * 
 * @author Lakshmi Sreelal
 */
public class StringCalculator {

	public static void main(String[] args) {
		System.out.print("Sum of numeric values:");
		try {
			new StringCalculator().add("1,2,3");
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Parse an string and sum all the numeric values removing the non numeric
	 * characters.
	 * 
	 * @param numbers
	 *            to analyze and sum.
	 * @return the sum value with some restrictions described in the project
	 *         documentation.
	 * @throws ValidatorException 
	 */
	public int add(final String numbers) throws ValidatorException {
		List<Integer> numbersList = extractNumbers(numbers);
		if(!numbersList.isEmpty()) {
			NegativeNumberFinder.validate(numbersList);
		}	
		return sumNumbers(numbersList);
	}

	private List<Integer> extractNumbers(final String numbers) {
		List<Integer> result = new LinkedList<Integer>();
		if (numbers != null && !numbers.isEmpty()) {
			final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
			Matcher matcher = NUMBER_PATTERN.matcher(numbers);
			while (matcher.find()) {
				int number = Integer.parseInt(matcher.group());
				result.add(number);
			}
		}
		return result;
	}

	private int sumNumbers(List<Integer> numberList) {
		int sum = 0;
		for (Integer num : numberList) {
			sum += num;
		}
		System.out.print(sum);
		return sum;
	}

}
