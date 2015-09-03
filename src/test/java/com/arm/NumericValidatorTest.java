package com.arm;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Test for NumberValidator
 * 
 * @author Lakshmi Sreelal
 */
public class NumericValidatorTest {

	private NumericValidator numericValidator;

	@Mock
	private ValidationRule mockedValidationRule1;
	@Mock
	private ValidationRule mockedValidationRule2;

	@Before
	public void setUp() throws Exception {
		initializeMocks();
		initializeNumberValidator();
	}

	@Test
	public void validNumericTest() {
		when(mockedValidationRule1.isValid(anyInt())).thenReturn(true);
		when(mockedValidationRule2.isValid(anyInt())).thenReturn(true);

		List<Integer> numbers = generateNumbersList(1, 2, 3, 4);

		List<Integer> result = numericValidator.removeInvalidNumbers(numbers);

		assertEquals(numbers, result);
	}

	private void initializeMocks() {
		MockitoAnnotations.initMocks(this);
	}

	private void initializeNumberValidator() {
		Collection<ValidationRule> rules = new LinkedList<ValidationRule>();
		rules.add(mockedValidationRule1);
		rules.add(mockedValidationRule2);
		numericValidator = new NumericValidator(rules);
	}

	private List<Integer> generateNumbersList(Integer... numbers) {
		List<Integer> result = new LinkedList<Integer>();
		for (Integer num : numbers) {
			result.add(num);
		}
		return result;
	}

}
