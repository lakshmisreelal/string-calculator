package com.arm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for LessThanValidationRule
 *
 * @author Lakshmi Sreelal
 */
public class UpperLimitValidationRuleTest {

    private static final int TOP_VALUE = 1000;
    private static final int LESS_THAN_TOP_VALUE = 11;

    private UpperLimitValidationRule rule;

    @Before
    public void setUp() {
        ruleInitializer();
    }

    @Test
    public void numberLessThanTopValueTest() {
        assertTrue(rule.isValid(LESS_THAN_TOP_VALUE));
    }

    @Test
    public void numberEqualsToTheTopValueTest() {
        assertTrue(rule.isValid(TOP_VALUE));
    }

    @Test
    public void numberGreaterThanTopValueTest() {
        assertFalse(rule.isValid(1001));
    }

    private void ruleInitializer() {
        rule = new UpperLimitValidationRule(TOP_VALUE);
    }
    
}
