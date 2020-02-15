package io.github.dwin357.format;

import io.github.dwin357.model.CalculatorException;

public interface RomanNumeralParser {
    int parse(String romanNumeral) throws CalculatorException;
}
