package com.arm;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Class evaluate valid numbers inside a List<Integer> based on a validation
 * rule collection that will be executed each time a List<Integer> be validated.
 * 
 * @author Lakshmi Sreelal.
 */
public class NumericValidator {

	private Collection<ValidationRule> rules;

	NumericValidator(Collection<ValidationRule> rules) {
		this.rules = rules;
	}

	/**
	 * For each element inside the numbers parameter this method will evaluate
	 * if it's valid to add it or not to collection.
	 * 
	 * @param numbers
	 *            to analyze.
	 * @return a List<Integer> without the invalid numbers
	 */
	public List<Integer> removeInvalidNumbers(List<Integer> numbers) {
		List<Integer> result = new LinkedList<Integer>();
		for (Integer num : numbers) {
			if (isValid(num)) {
				result.add(num);
			}
		}
		return result;
	}

	private boolean isValid(Integer num) {
		boolean res = true;
		for (ValidationRule rule : rules) {
			if (!rule.isValid(num)) {
				res = false;
				break;
			}
		}
		return res;
	}
}
