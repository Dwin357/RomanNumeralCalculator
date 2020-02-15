package io.github.dwin357.operation;

import io.github.dwin357.calculator.SignBasedCalculator;
import io.github.dwin357.format.CommandLineArgParser;
import io.github.dwin357.format.DecimalParser;
import io.github.dwin357.format.RomanNumeralParserImpl;
import io.github.dwin357.output.OutputVector;
import io.github.dwin357.view.DecimalView;
import io.github.dwin357.view.NumeralView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class OperationTest {

    @Mock
    private OutputVector mockOut;

    private Operation operationUnderTest;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        CommandLineArgParser commandLineArgParser = new CommandLineArgParser();
        commandLineArgParser.setParser(new RomanNumeralParserImpl());

        NumeralView numeralView = new NumeralView();
        numeralView.setParser(new DecimalParser());

        this.operationUnderTest = new Operation();
        this.operationUnderTest.setArgParser(commandLineArgParser);
        this.operationUnderTest.setCalc(new SignBasedCalculator());
        this.operationUnderTest.setView(numeralView);
        this.operationUnderTest.setOut(mockOut);
    }

    @Test
    public void i_plus_i() {
        String[] clInput = {"i", "+", "i"};
        String expectedOutput = "Answer is II";

        operationUnderTest.perform(clInput);

        verify(mockOut, times(1)).publish(expectedOutput);
    }

    @Test
    public void vli_minus_vii() {
        String[] clInput = {"vli", "-", "vii"};
        String expectedOutput = "Answer is XXXIX";

        operationUnderTest.perform(clInput);

        verify(mockOut, times(1)).publish(expectedOutput);
    }

    @Test
    public void iii_times_xviii() {
        String[] clInput = {"iii", "*", "xviii"};
        String expectedOutput = "Answer is LIV";

        operationUnderTest.perform(clInput);

        verify(mockOut, times(1)).publish(expectedOutput);
    }

    @Test
    public void ccc_times_xx() {
        String[] clInput = {"ccc", "/", "xx"};
        String expectedOutput = "Answer is XV";

        operationUnderTest.perform(clInput);

        verify(mockOut, times(1)).publish(expectedOutput);
    }


}