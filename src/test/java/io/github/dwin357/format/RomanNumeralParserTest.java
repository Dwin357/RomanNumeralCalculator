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

    @Test
    public void xReturns10() {
        String romanNumeral = "X";
        int expected = 10;

        int actual = RomanNumeralParser.parse(romanNumeral);

        assertEquals(expected, actual);
    }

    @Test
    public void viReturns6() {
        String romanNumeral = "VI";
        int expected = 6;

        int actual = RomanNumeralParser.parse(romanNumeral);

        assertEquals(expected, actual);
    }

    @Test
    public void ivReturns4() {
        String romanNumeral = "IV";
        int expected = 4;

        int actual = RomanNumeralParser.parse(romanNumeral);

        assertEquals(expected, actual);
    }

    @Test
    public void mcmxcviReturns1996() {
        String romanNumeral = "mcmxcvi";
        int expected = 1996;
    }
}