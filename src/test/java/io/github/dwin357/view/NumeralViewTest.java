package io.github.dwin357.view;

import io.github.dwin357.format.DecimalParser;
import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.WorkingState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class NumeralViewTest {

    private View viewUnderTest;

    @Mock
    private DecimalParser parser;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        NumeralView numView = new NumeralView();
        numView.setParser(parser);
        viewUnderTest = numView;
    }

    @Test
    public void display_solution() throws CalculatorException {
        WorkingState stateArgument = new WorkingState(0, 0, null);
        stateArgument.setSolution(42);

        when(parser.parse(42)).thenReturn("XLII");

        String expectedOutput = String.format("Answer is XLII");
        String actualOutput = viewUnderTest.display(stateArgument);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void display_parseError() throws CalculatorException {
        WorkingState stateArgument = new WorkingState(0, 0, null);
        stateArgument.setSolution(42);

        String errorMsg = "parser blew up";
        when(parser.parse(42)).thenThrow(new CalculatorException(errorMsg));

        String actualOutput = viewUnderTest.display(stateArgument);

        assertEquals(errorMsg, actualOutput);
    }

    @Test
    public void display_error() {
        String expectedOutput = "Very Bad Things Happened";
        CalculatorException whoops = new CalculatorException(expectedOutput);

        String actual = viewUnderTest.display(whoops);

        assertEquals(expectedOutput, actual);
    }
}