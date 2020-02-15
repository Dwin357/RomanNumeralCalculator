package io.github.dwin357.model.structs;

import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.structs.RomanNumeral;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralTest {


    @Test
    public void one() throws CalculatorException {
        RomanNumeral expectedNumeral = RomanNumeral.ONE;
        int expectedDecimal = 1;
        String expectedLetter = "I";

        RomanNumeral lowerCase = RomanNumeral.getByLetter("i");
        assertEquals(expectedNumeral, lowerCase);
        assertEquals(expectedDecimal, lowerCase.getValue());
        assertEquals(expectedLetter, lowerCase.getLetter());

        RomanNumeral upperCase = RomanNumeral.getByLetter("I");
        assertEquals(expectedNumeral, upperCase);
        assertEquals(expectedDecimal, upperCase.getValue());
        assertEquals(expectedLetter, upperCase.getLetter());
    }

    @Test
    public void five() throws CalculatorException {
        RomanNumeral expectedNumeral = RomanNumeral.FIVE;
        int expectedDecimal = 5;
        String expectedLetter = "V";

        RomanNumeral lowerCase = RomanNumeral.getByLetter("v");
        assertEquals(expectedNumeral, lowerCase);
        assertEquals(expectedDecimal, lowerCase.getValue());
        assertEquals(expectedLetter, lowerCase.getLetter());

        RomanNumeral upperCase = RomanNumeral.getByLetter("V");
        assertEquals(expectedNumeral, upperCase);
        assertEquals(expectedDecimal, upperCase.getValue());
        assertEquals(expectedLetter, upperCase.getLetter());
    }

    @Test
    public void ten() throws CalculatorException {
        RomanNumeral expectedNumeral = RomanNumeral.TEN;
        int expectedDecimal = 10;
        String expectedLetter = "X";

        RomanNumeral lowerCase = RomanNumeral.getByLetter("x");
        assertEquals(expectedNumeral, lowerCase);
        assertEquals(expectedDecimal, lowerCase.getValue());
        assertEquals(expectedLetter, lowerCase.getLetter());

        RomanNumeral upperCase = RomanNumeral.getByLetter("X");
        assertEquals(expectedNumeral, upperCase);
        assertEquals(expectedDecimal, upperCase.getValue());
        assertEquals(expectedLetter, upperCase.getLetter());
    }

    @Test
    public void fifty() throws CalculatorException {
        RomanNumeral expectedNumeral = RomanNumeral.FIFTY;
        int expectedDecimal = 50;
        String expectedLetter = "L";

        RomanNumeral lowerCase = RomanNumeral.getByLetter("l");
        assertEquals(expectedNumeral, lowerCase);
        assertEquals(expectedDecimal, lowerCase.getValue());
        assertEquals(expectedLetter, lowerCase.getLetter());

        RomanNumeral upperCase = RomanNumeral.getByLetter("L");
        assertEquals(expectedNumeral, upperCase);
        assertEquals(expectedDecimal, upperCase.getValue());
        assertEquals(expectedLetter, upperCase.getLetter());
    }

    @Test
    public void hundred() throws CalculatorException {
        RomanNumeral expectedNumeral = RomanNumeral.ONE_HUNDRED;
        int expectedDecimal = 100;
        String expectedLetter = "C";

        RomanNumeral lowerCase = RomanNumeral.getByLetter("c");
        assertEquals(expectedNumeral, lowerCase);
        assertEquals(expectedDecimal, lowerCase.getValue());
        assertEquals(expectedLetter, lowerCase.getLetter());

        RomanNumeral upperCase = RomanNumeral.getByLetter("C");
        assertEquals(expectedNumeral, upperCase);
        assertEquals(expectedDecimal, upperCase.getValue());
        assertEquals(expectedLetter, upperCase.getLetter());
    }

    @Test
    public void fiveHundred() throws CalculatorException {
        RomanNumeral expectedNumeral = RomanNumeral.FIVE_HUNDRED;
        int expectedDecimal = 500;
        String expectedLetter = "D";

        RomanNumeral lowerCase = RomanNumeral.getByLetter("d");
        assertEquals(expectedNumeral, lowerCase);
        assertEquals(expectedDecimal, lowerCase.getValue());
        assertEquals(expectedLetter, lowerCase.getLetter());

        RomanNumeral upperCase = RomanNumeral.getByLetter("D");
        assertEquals(expectedNumeral, upperCase);
        assertEquals(expectedDecimal, upperCase.getValue());
        assertEquals(expectedLetter, upperCase.getLetter());
    }

    @Test
    public void oneThousand() throws CalculatorException {
        RomanNumeral expectedNumeral = RomanNumeral.ONE_THOUSAND;
        int expectedDecimal = 1000;
        String expectedLetter = "M";

        RomanNumeral lowerCase = RomanNumeral.getByLetter("m");
        assertEquals(expectedNumeral, lowerCase);
        assertEquals(expectedDecimal, lowerCase.getValue());
        assertEquals(expectedLetter, lowerCase.getLetter());

        RomanNumeral upperCase = RomanNumeral.getByLetter("M");
        assertEquals(expectedNumeral, upperCase);
        assertEquals(expectedDecimal, upperCase.getValue());
        assertEquals(expectedLetter, upperCase.getLetter());
    }

    @Test(expected = CalculatorException.class)
    public void unrecognizedLetter() throws CalculatorException {
        RomanNumeral.getByLetter("s");
    }
}