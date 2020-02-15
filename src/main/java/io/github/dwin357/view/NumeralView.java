package io.github.dwin357.view;

import io.github.dwin357.format.DecimalParser;
import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.WorkingState;

public class NumeralView implements View {

    private DecimalParser parser;

    @Override
    public <E extends Exception> String display(E badThings) {
        return badThings.getMessage();
    }

    @Override
    public String display(WorkingState state) {
        String solution;

        try {
            solution = parser.parse(state.getSolution());
        } catch (CalculatorException e) {
            return display(e);
        }

        return String.format("Answer is %s", solution);
    }

    public DecimalParser getParser() {
        return parser;
    }

    public void setParser(DecimalParser parser) {
        this.parser = parser;
    }
}
