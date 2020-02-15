package io.github.dwin357.format;

import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.structs.Sign;
import io.github.dwin357.model.WorkingState;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandLineArgParserTest {

    private CommandLineArgParser liveParser;

    @Before
    public void setUp() throws Exception {
        this.liveParser = new CommandLineArgParser();
        this.liveParser.setParser(new RomanNumeralParserImpl());
    }

    @Test
    public void happyPath_returnsCorrectWorkingState() throws CalculatorException {
        String[] commandLineArgs = {"III", "+", "X"};

        WorkingState actual = liveParser.makeWorkingState(commandLineArgs);

        assertNotNull("working state missing", actual);
        assertEquals("first term wrong", 3, actual.getFirstTerm());
        assertEquals("second term wrong", 10, actual.getSecondTerm());
        assertEquals("sign wrong", Sign.ADD, actual.getSign());
    }

    @Test(expected = CalculatorException.class)
    public void firstTerm_invalidRomanNumeral() throws CalculatorException {
        String[] commandLineArgs = {"apple", "*", "lv"};

        liveParser.makeWorkingState(commandLineArgs);
    }

    @Test(expected = CalculatorException.class)
    public void secondTerm_invalidRomanNumeral() throws CalculatorException {
        String[] commandLineArgs = {"cx", "-", "orange"};

        liveParser.makeWorkingState(commandLineArgs);
    }

    @Test(expected = CalculatorException.class)
    public void signTerm_invalid() throws CalculatorException {
        String[] commandLineArgs = {"xxiii", "$", "lv"};

        liveParser.makeWorkingState(commandLineArgs);
    }

    @Test(expected = CalculatorException.class)
    public void missingArguments() throws CalculatorException {
        String[] commandLineArgs = {"xix", "*"};

        liveParser.makeWorkingState(commandLineArgs);
    }
}