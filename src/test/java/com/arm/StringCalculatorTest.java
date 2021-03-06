package com.arm;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.arm.exception.NegativeNumbersNotAllowedException;
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
    private static final String NEW_LINE_DELIMTER_BETWEEN_STRING = "1\n2\n3";
    private static final String SEPARATOR_NEW_LINE = "1\n2,3";
    private static final String DIFFERENT_SEPARATORS = "//;\n1;2p4";
    private static final String NEGATIVE_VALUES = "-10,1,3";
    private static final String MORE_THAN_THOUSAND = "2,1000";
    private static final String DIFFERENT_SEPARATORS_CONSECUTIVES = "[*][%]\\n1*2%4";
        
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
    
    @Test
    public void ifTheArgumentContainsMoreThanTwoNumbers() throws ValidatorException{
        int result = stringCalculator.add(THREE_NUMBER_STRING);
        assertEquals(6, result);
    }
    @Test
    public void newLineDelimeterBetweenNumbers() throws ValidatorException{
        int result = stringCalculator.add(NEW_LINE_DELIMTER_BETWEEN_STRING);
        assertEquals(6, result);
    }
    
    @Test
    public void sumOfAnUnknownAmountTest() throws ValidatorException {
        int result = stringCalculator.add(SEPARATOR_NEW_LINE);

        assertEquals(6, result);
    }

    @Test
    public void sumOfAnUnknownAmoutOfNumbersSeparatedWithDifferentDelimitersTest() throws ValidatorException {
        int result = stringCalculator.add(DIFFERENT_SEPARATORS);

        assertEquals(7, result);
    }
    
    @Test(expected = NegativeNumbersNotAllowedException.class)
    public void negativeNumbersNotSupportedException() throws ValidatorException {
        stringCalculator.add(NEGATIVE_VALUES);
    }
    

    @Test
    public void ignoreNumbersGreaterThanOneThousand() throws ValidatorException {
        int result = stringCalculator.add(MORE_THAN_THOUSAND);

        assertEquals(1002, result);
    }

    @Test
    public void differentDelimitersWithMoreThanOneCharAndMoreThanOneConsecutive() throws ValidatorException {
        int result = stringCalculator.add(DIFFERENT_SEPARATORS_CONSECUTIVES);

        assertEquals(7, result);
    }
    
    @SuppressWarnings({ "unchecked" })
	@Test
    public void anEmptyCollectionIfTheParamIsEmpty() 
    throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	Method method = StringCalculator.class.getDeclaredMethod("extractNumbers", new Class[]{ String.class});
		method.setAccessible(true);	
		List<Integer> result = (List<Integer>) method.invoke(stringCalculator, "");
        List<Integer> expectedResult = new LinkedList<Integer>();
        assertEquals(expectedResult, result);
    }
    
    @SuppressWarnings({ "unchecked" })
	@Test
    public void aCollectionWithTheNumbersExtracted() 
    throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	Method method = StringCalculator.class.getDeclaredMethod("extractNumbers", new Class[]{ String.class});
		method.setAccessible(true);	
		List<Integer> result = (List<Integer>) method.invoke(stringCalculator, "\n|�1,2,3,pouusdf4%5&6");
		List<Integer> expectedResult = generateListOfNumbers(1, 2, 3, 4, 5, 6);
        assertEquals(expectedResult, result);
    }
    
    private List<Integer> generateListOfNumbers(Integer... nums) {
        List<Integer> result = new LinkedList<Integer>();
        for (Integer num : nums) {
            result.add(num);
        }
        return result;
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
