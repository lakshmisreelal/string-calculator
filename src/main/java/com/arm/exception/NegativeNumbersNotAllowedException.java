package com.arm.exception;

import java.util.List;

/**
 * Exception created to be thrown when the application is used with negative numbers.
 * <p/>
 * This exception contains information about the negative numbers that throws the exception.
 *
 * @author Lakshmi Sreelal.
 */
public class NegativeNumbersNotAllowedException extends ValidatorException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String EXCEPTION_NAME = "NegativesNotAllowed";

    private List<Integer> negativeNumbers;

    public NegativeNumbersNotAllowedException(List<Integer> negativeNumbers) {
        this.negativeNumbers = negativeNumbers;
    }

    @Override
    public String getMessage() {
        return EXCEPTION_NAME + negativeNumbers.toString();
    }
}
