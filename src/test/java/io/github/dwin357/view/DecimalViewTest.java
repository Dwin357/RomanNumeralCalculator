package io.github.dwin357.view;

import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.WorkingState;
import io.github.dwin357.model.structs.Sign;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecimalViewTest {

    private View viewUnderTest;

    @Before
    public void setUp() throws Exception {
        viewUnderTest = new DecimalView();
    }

    @Test
    public void display_solution() {
        WorkingState stateArgument = new WorkingState(0, 0, null);
        stateArgument.setSolution(42);

        String expectedOutput = String.format("Answer is 42");
        String actualOutput = viewUnderTest.display(stateArgument);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void display_error() {
        String expectedOutput = "Very Bad Things Happened";
        CalculatorException whoops = new CalculatorException(expectedOutput);

        String actual = viewUnderTest.display(whoops);

        assertEquals(expectedOutput, actual);
    }
}