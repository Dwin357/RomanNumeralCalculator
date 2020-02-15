package io.github.dwin357.format;

import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.structs.Sign;
import io.github.dwin357.model.WorkingState;

public class CommandLineArgParser {

    private RomanNumeralParser parser;

    public WorkingState makeWorkingState(String[] clInputs) throws CalculatorException {
        try {
            String firstTerm = clInputs[0];
            String sign = clInputs[1];
            String secondTerm = clInputs[2];
            return new WorkingState(parser.parse(firstTerm), parser.parse(secondTerm), Sign.getFromSymbol(sign));
        } catch (IndexOutOfBoundsException ex) {
            throw new CalculatorException("Wrong arguments, example usage: II * XIV");
        }
    }

    /////////////////////////////
    ////  Getters + Setters  ////
    /////////////////////////////

    public RomanNumeralParser getParser() {
        return parser;
    }

    public void setParser(RomanNumeralParser parser) {
        this.parser = parser;
    }
}
