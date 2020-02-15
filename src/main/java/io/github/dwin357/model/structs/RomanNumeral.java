package io.github.dwin357.model.structs;

import io.github.dwin357.model.CalculatorException;

public enum RomanNumeral {

    ONE(1, "I"),
    FIVE(5, "V"),
    TEN(10, "X"),
    FIFTY(50, "L"),
    ONE_HUNDRED(100, "C"),
    FIVE_HUNDRED(500, "D"),
    ONE_THOUSAND(1000, "M");

    //////////////////////////////
    //////   Struct Setup   //////
    //////////////////////////////

    private int decimalValue;
    private String romanSymbol;
    RomanNumeral(int val, String letter) {
        this.decimalValue = val;
        this.romanSymbol = letter;
    }
    public int getValue() {
        return this.decimalValue;
    }
    public String getLetter() {
        return this.romanSymbol;
    }

    public static RomanNumeral getByLetter(String letter) throws CalculatorException {
        for(RomanNumeral numeral : RomanNumeral.values()) {
            if(numeral.getLetter().equalsIgnoreCase(letter)) {
                return numeral;
            }
        }
        throw new CalculatorException(String.format("Unable to parse %s to roman numeral", letter));
    }
}
