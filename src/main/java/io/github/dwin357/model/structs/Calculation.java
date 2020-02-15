package io.github.dwin357.model.structs;

import io.github.dwin357.model.CalculatorException;

public interface Calculation {
    public int calculate(int firstTerm, int secondTerm) throws CalculatorException;
}
