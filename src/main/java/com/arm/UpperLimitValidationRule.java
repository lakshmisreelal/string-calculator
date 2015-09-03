package com.arm;

/**
 * ValidationRule created to discard all the numbers grater than or equals to the value passed in the constructor.
 *
 * @author Lakshmi Sreelal.
 */
class UpperLimitValidationRule implements ValidationRule {

    private final int value;

    UpperLimitValidationRule(int value) {
        this.value = value;
    }

    @Override
    public boolean isValid(Integer number) {
        return number <= value;
    }

}
