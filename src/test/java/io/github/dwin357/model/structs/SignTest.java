package io.github.dwin357.model.structs;

import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.structs.Sign;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignTest {

    @Test
    public void plus() throws CalculatorException {
        String symbol = "+";
        Sign expected = Sign.ADD;
        int expectedEvaluation = 5;

        Sign actual = Sign.getFromSymbol(symbol);
        int eval = actual.getCalc().calculate(2, 3);

        assertEquals("enum", expected, actual);
        assertEquals("symbol", symbol, actual.getSymbol());
        assertEquals("eval", expectedEvaluation, eval);
    }

    @Test
    public void minus() throws CalculatorException {
        String symbol = "-";
        Sign expected = Sign.SUBTRACT;
        int expectedEval = -1;

        Sign actual = Sign.getFromSymbol(symbol);
        int eval = actual.getCalc().calculate(2, 3);

        assertEquals("enum", expected, actual);
        assertEquals("symbol", symbol, actual.getSymbol());
        assertEquals("eval", expectedEval, eval);
    }

    @Test
    public void multiply() throws CalculatorException {
        String symbol = "*";
        Sign expected = Sign.MULTIPLY;
        int expectedEval = 6;

        Sign actual = Sign.getFromSymbol(symbol);
        int eval = actual.getCalc().calculate(2, 3);

        assertEquals("enum", expected, actual);
        assertEquals("symbol", symbol, actual.getSymbol());
        assertEquals("eval", expectedEval, eval);
    }

    @Test
    public void divide() throws CalculatorException {
        String symbol = "/";
        Sign expected = Sign.DIVIDE;
        int expectedEval = 3;

        Sign actual = Sign.getFromSymbol(symbol);
        int eval = actual.getCalc().calculate(6, 2);

        assertEquals("enum", expected, actual);
        assertEquals("symbol", symbol, actual.getSymbol());
        assertEquals("eval", expectedEval, eval);
    }

    @Test(expected = CalculatorException.class)
    public void divideByZero() throws CalculatorException {
        Sign.DIVIDE.getCalc().calculate(8, 0);
    }

    @Test(expected = CalculatorException.class)
    public void unrecognizedValue() throws CalculatorException {
        Sign.getFromSymbol("$");
    }
}