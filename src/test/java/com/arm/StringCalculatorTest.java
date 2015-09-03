package com.arm;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.arm.exception.ValidatorException;

/**
 * Test created to check the correct behaviour of the StringCalculator application.
 * @author Lakshmi Sreelal
 */
public class StringCalculatorTest {

    private static final String EMPTY_SET_OF_NUMBERS = "";
    private static final String ONE_NUMBER_STRING = "1";
    private static final String TWO_NUMBER_STRING = "1,2";
    private static final String THREE_NUMBER_STRING = "1,2,3";
    
    private StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void ifTheArgumentIsEmpty() throws ValidatorException {
        int result = stringCalculator.add(EMPTY_SET_OF_NUMBERS);

        assertEquals(0, result);
    }

    @Test
    public void ifArgumentContainsOnlyOneNumber() throws ValidatorException{
        int result = stringCalculator.add(ONE_NUMBER_STRING);

        int expectedResult = Integer.parseInt(ONE_NUMBER_STRING);
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void ifTheArgumentContainsOnlyTwoNumbers() throws ValidatorException{
        int result = stringCalculator.add(TWO_NUMBER_STRING);
        assertEquals(3, result);
    }
    
    @Test(expected = ValidatorException.class)
    public void ifTheArgumentContainsMoreThanTwoNumbers() throws ValidatorException{
        stringCalculator.add(THREE_NUMBER_STRING);
    }
    
    @SuppressWarnings({ "unchecked" })
	@Test
    public void ifParamIsEmptyCollection() 
    throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	Method method = StringCalculator.class.getDeclaredMethod("extractNumbers", new Class[]{ String.class});
		method.setAccessible(true);	
		List<Integer> result = (List<Integer>) method.invoke(stringCalculator, "");
        List<Integer> expectedResult = new LinkedList<Integer>();
        assertEquals(expectedResult, result);
    }

}
