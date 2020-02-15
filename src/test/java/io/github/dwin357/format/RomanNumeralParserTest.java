package io.github.dwin357.format;

import io.github.dwin357.model.CalculatorException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralParserTest {

    private RomanNumeralParser parserUnderTest;

    @Before
    public void initializeParser() {
        parserUnderTest = new RomanNumeralParserImpl();
    }

    @Test
    public void iReturns1() throws CalculatorException {
        String romanNumeral = "I";
        int expected = 1;

        int actual = parserUnderTest.parse(romanNumeral);

        assertEquals(expected, actual);
    }

    @Test
    public void iiiReturns3() throws CalculatorException {
        String romanNumeral = "III";
        int expected = 3;

        int actual = parserUnderTest.parse(romanNumeral);

        assertEquals(expected, actual);
    }

    @Test
    public void xReturns10() throws CalculatorException {
        String romanNumeral = "X";
        int expected = 10;

        int actual = parserUnderTest.parse(romanNumeral);

        assertEquals(expected, actual);
    }

    @Test
    public void viReturns6() throws CalculatorException {
        String romanNumeral = "VI";
        int expected = 6;

        int actual = parserUnderTest.parse(romanNumeral);

        assertEquals(expected, actual);
    }

    @Test
    public void ivReturns4() throws CalculatorException {
        String romanNumeral = "IV";
        int expected = 4;

        int actual = parserUnderTest.parse(romanNumeral);

        assertEquals(expected, actual);
    }

    @Test
    public void mcmxcviReturns1996() throws CalculatorException {
        String romanNumeral = "MCMXCVI";
        int expected = 1996;

        int actual = parserUnderTest.parse(romanNumeral);

        assertEquals(expected, actual);
    }
}