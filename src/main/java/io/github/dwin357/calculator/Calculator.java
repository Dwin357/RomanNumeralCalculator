package io.github.dwin357.calculator;

import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.WorkingState;

public interface Calculator {
    void calculate(WorkingState state) throws CalculatorException;
}
