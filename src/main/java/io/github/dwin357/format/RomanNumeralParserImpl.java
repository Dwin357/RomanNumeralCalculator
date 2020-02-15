package io.github.dwin357.format;

import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.structs.RomanNumeral;

public class RomanNumeralParserImpl implements RomanNumeralParser {

    @Override
    public int parse(String romanNumeral) throws CalculatorException {
        int runnintTotal = 0;
        String[] letters = romanNumeral.split("");
        for(int i=0; i < letters.length; i++) {
            runnintTotal += getSign(i, letters) * getNumber(letters[i]);
        }
        return runnintTotal;
    }

    private int getSign(int index, String[] letters) throws CalculatorException {
        int nextPosition = index + 1;
        if(nextPosition == letters.length) {
            return 1;
        }
        return getNumber(letters[index]) < getNumber(letters[nextPosition]) ? -1 : 1;
    }

    private int getNumber(String letter) throws CalculatorException {
        return RomanNumeral.getByLetter(letter).getValue();
    }
}
