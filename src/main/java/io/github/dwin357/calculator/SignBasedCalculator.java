package io.github.dwin357.calculator;

import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.WorkingState;

public class SignBasedCalculator implements Calculator {

    @Override
    public void calculate(WorkingState state) throws CalculatorException {
        Integer solution = state
                                .getSign()
                                .getCalc()
                                .calculate(
                                        state.getFirstTerm(),
                                        state.getSecondTerm()
                                );

        state.setSolution(solution);
    }
}
