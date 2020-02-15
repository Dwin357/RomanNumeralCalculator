package io.github.dwin357.calculator;

import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.WorkingState;
import io.github.dwin357.model.structs.Sign;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignBasedCalculatorTest {

    private Calculator calculatorUnderTest;
    private WorkingState argumentState;
    private Integer expectedAnswer;

    @Before
    public void setUp() throws Exception {
        calculatorUnderTest = new SignBasedCalculator();
    }

    @Test
    public void onePlusTwo() throws CalculatorException {
        argumentState = new WorkingState(1, 2, Sign.ADD);
        expectedAnswer = 3;

        assertNull("solution not initilized to null", argumentState.getSolution());

        calculatorUnderTest.calculate(argumentState);

        assertEquals("solution was not expected", expectedAnswer, argumentState.getSolution());
    }

    @Test
    public void oneThousandDividedTen() throws CalculatorException {
        argumentState = new WorkingState(1000, 10, Sign.DIVIDE);
        expectedAnswer = 100;

        assertNull("solution not initilized to null", argumentState.getSolution());

        calculatorUnderTest.calculate(argumentState);

        assertEquals("solution was not expected", expectedAnswer, argumentState.getSolution());
    }

    @Test(expected = CalculatorException.class)
    public void oneThousandDividedZero() throws CalculatorException {
        argumentState = new WorkingState(1000, 0, Sign.DIVIDE);

        assertNull("solution not initilized to null", argumentState.getSolution());

        calculatorUnderTest.calculate(argumentState);
    }

    @Test
    public void oneFiftyTimesThree() throws CalculatorException {
        argumentState = new WorkingState(150, 3, Sign.MULTIPLY);
        expectedAnswer = 450;

        assertNull("solution not initilized to null", argumentState.getSolution());

        calculatorUnderTest.calculate(argumentState);

        assertEquals("solution was not expected", expectedAnswer, argumentState.getSolution());
    }

    @Test
    public void fortyTwoMinusSeventeen() throws CalculatorException {
        argumentState = new WorkingState(42, 17, Sign.SUBTRACT);
        expectedAnswer = 25;

        assertNull("solution not initilized to null", argumentState.getSolution());

        calculatorUnderTest.calculate(argumentState);

        assertEquals("solution was not expected", expectedAnswer, argumentState.getSolution());
    }
}