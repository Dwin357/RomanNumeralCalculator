package io.github.dwin357.format;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralParserTest {

    @Test
    public void iReturns1() {
        String romanNumeral = "I";
        int expected = 1;

        int actual = RomanNumeralParser.parse(romanNumeral);

        assertEquals(expected, actual);
    }

    @Test
    public void iiiReturns3() {
        String romanNumeral = "III";
        int expected = 3;

        int actual = RomanNumeralParser.parse(romanNumeral);

        assertEquals(expected, actual);
    }
}