package com.arm;

import java.util.LinkedList;
import java.util.List;

import com.arm.exception.NegativeNumbersNotAllowedException;
import com.arm.exception.ValidatorException;


/**
 * This class detects negative numbers and throws a NegativeNumbersNotAllowedException.
 *
 * @author Lakshmi Sreelal
 */
public class NegativeNumberFinder {

    public static void  validate(final List<Integer> numbers) throws ValidatorException {
    	List<Integer> negNumbersLst = new LinkedList<Integer>();
    	for (Integer num : numbers) {
            if (num < 0) {
                negNumbersLst.add(num);
            }
        }
        if (negNumbersLst.size() > 0) {
            throw new NegativeNumbersNotAllowedException(negNumbersLst);
        }
    }
}