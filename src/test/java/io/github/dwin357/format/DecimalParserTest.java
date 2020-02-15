package io.github.dwin357.format;

import io.github.dwin357.model.CalculatorException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecimalParserTest {

    private DecimalParser parserUnderTest;

    @Before
    public void setUp() throws Exception {
        parserUnderTest = new DecimalParser();
    }

    /*
        5 -> v
        3 -> iii
        18 -> xviii
        9 -> ix
        49 -> xlix
        1974 -> mcmlxxiv
     */

    @Test
    public void vIs5() throws CalculatorException {
        int decimalArg = 5;
        String expectedOutput = "V";

        String actualOutput = parserUnderTest.parse(decimalArg);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void iiiIs3() throws CalculatorException {
        int decimalArg = 3;
        String expectedOutput = "III";

        String actualOutput = parserUnderTest.parse(decimalArg);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void xviiiIs18() throws CalculatorException {
        int decimalArg = 18;
        String expectedOutput = "XVIII";

        String actualOutput = parserUnderTest.parse(decimalArg);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void liiIs52() throws CalculatorException {
        int decimalArg = 52;
        String expectedOutput = "LII";

        String actualOutput = parserUnderTest.parse(decimalArg);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void ixIs9() throws CalculatorException {
        int decimalArg = 9;
        String expectedOutput = "IX";

        String actualOutput = parserUnderTest.parse(decimalArg);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void xlixIs47() throws CalculatorException {
        int decimalArg = 47;
        String expectedOutput = "VLII";

        String actualOutput = parserUnderTest.parse(decimalArg);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void cvliIs146() throws CalculatorException {
        int decimalArg = 146;
        String expectedOutput = "CVLI";

        String actualOutput = parserUnderTest.parse(decimalArg);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mcmIs1900() throws CalculatorException {
        int decimalArg = 1900;
        String expectedOutput = "MCM";

        String actualOutput = parserUnderTest.parse(decimalArg);

        assertEquals(expectedOutput, actualOutput);
    }

    /*
     * Catches edge case where LC is being retruned for 50 instead of L
     */
    @Test
    public void lxxivIs74() throws CalculatorException {
        int decimalArg = 74;
        String expectedOutput = "LXXIV";

        String actualOutput = parserUnderTest.parse(decimalArg);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void mlmxxivIs1974() throws CalculatorException {
        int decimalArg = 1974;
        String expectedOutput = "MLMXXIV";

        String actualOutput = parserUnderTest.parse(decimalArg);

        assertEquals(expectedOutput, actualOutput);
    }

}