package io.github.dwin357.model.structs;

import io.github.dwin357.model.CalculatorException;

public enum Sign {
    ADD("+", (first, second) -> first + second),
    SUBTRACT("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) ->  {
        try {
            return first / second;
        } catch(ArithmeticException ex){
            throw new CalculatorException("Can not divide by zero", ex);
        }
    });

    ////////////////////////
    ////  Struct Setup  ////
    ////////////////////////

    private String symbol;
    private Calculation calc;

    Sign(String cymbol, Calculation eval) {
        this.calc = eval;
        this.symbol = cymbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
    public Calculation getCalc() { return this.calc; }

    public static Sign getFromSymbol(String symbol) throws CalculatorException {
        for(Sign cign : Sign.values()) {
            if(cign.getSymbol().equalsIgnoreCase(symbol)) {
                return cign;
            }
        }
        throw new CalculatorException(String.format("Unrecognized math symbol:%s", symbol)) ;
    }
}
