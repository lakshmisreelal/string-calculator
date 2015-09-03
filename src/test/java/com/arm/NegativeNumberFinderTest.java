package com.arm;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.arm.exception.NegativeNumbersNotAllowedException;
import com.arm.exception.ValidatorException;

/**
 * Test for NegativeNumberSearcher.
 *
 * @author Lakshmi Sreelal
 */
public class NegativeNumberFinderTest {

    private static final int POSITIVE_VALUE = 10;
    private static final int ZERO = 0;
    private static final int NEGATIVE_VALUE = -10;

    @Test
    public void shouldValidatePositiveNumbers() throws ValidatorException {
        List<Integer> positiveNumbers = generateIntegerList(POSITIVE_VALUE);
        NegativeNumberFinder.validate(positiveNumbers);
    }

    @Test
    public void shouldValidateZero() throws ValidatorException {
        List<Integer> positiveNumbers = generateIntegerList(ZERO);
        NegativeNumberFinder.validate(positiveNumbers);
    }


    @Test(expected = NegativeNumbersNotAllowedException.class)
    public void shouldNotValidateNegativeNumbers() throws ValidatorException {
        List<Integer> positiveNumbers = generateIntegerList(NEGATIVE_VALUE);
        NegativeNumberFinder.validate(positiveNumbers);
    }

    private List<Integer> generateIntegerList(int num) {
        List<Integer> nums = new LinkedList<Integer>();
        nums.add(num);
        return nums;
    }
}
