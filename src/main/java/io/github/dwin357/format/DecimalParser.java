package io.github.dwin357.format;

import com.sun.javafx.binding.StringFormatter;
import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.structs.RomanNumeral;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class DecimalParser {

    public String parse(int decimal) throws CalculatorException {
        StringBuilder returnString = new StringBuilder();
        parse(decimal, returnString, getNumeralsInDecimalOrdered());
        return returnString.toString();
    }

    private void parse(int decimal, StringBuilder rtn, List<RomanNumeral> orderedNumerals) throws CalculatorException {
        RomanNumeral numeral;
        RomanNumeral debitNumeral;

        for(int i=0; i < orderedNumerals.size(); i++) {

            if(decimal == 0) {
                break;
            }

            numeral = orderedNumerals.get(i);

            while ( totalContainsAmount(decimal, numeral.getValue()) ) {
                decimal -= numeral.getValue();
                rtn.append(numeral.getLetter());
            }

            if(hasDebitNumeral(decimal, i, orderedNumerals)) {
                debitNumeral = getLowestDebitNumeral(decimal, i, orderedNumerals);
                if(! sixOfOneOrHalfDozenOfOther(debitNumeral, i, orderedNumerals) ) {
                    decimal += debitNumeral.getValue();
                    decimal -= numeral.getValue();
                    rtn.append(debitNumeral.getLetter());
                    rtn.append(numeral.getLetter());
                }
            }
        }
    }

    private boolean totalContainsAmount(int total, int amount) {
        return total / amount > 0;
    }

    private RomanNumeral getLowestDebitNumeral(int currentAmount, int currentIndex, List<RomanNumeral> orderedNumerals) throws CalculatorException {

        // processing numeral list from low -> high
        for(int i= orderedNumerals.size()-1; i > currentIndex; i--) {
            if(isDebitNumeral(i, currentIndex, orderedNumerals, currentAmount)) {
                return orderedNumerals.get(i);
            }
        }
        throw new CalculatorException(String.format(
                        "Logical Error: looking for debit-numeral of numeral:%s in amt:%d but none found",
                        orderedNumerals.get(currentIndex), currentAmount));
    }

    private boolean hasDebitNumeral(int currentAmount, int currentIndex, List<RomanNumeral> orderedNumerals) throws CalculatorException {
        if(currentIndex + 1 >= orderedNumerals.size()) {
            return false;
        }
        return isDebitNumeral(currentIndex+1, currentIndex, orderedNumerals, currentAmount);
    }

    private boolean isDebitNumeral(int testedIndex, int referenceIndex, List<RomanNumeral> orderedNumerals, int currentAmount) throws CalculatorException {
        int debitNumeralValue = getValueOfNumeralAt(testedIndex, orderedNumerals);
        int debitedAmt = getValueOfNumeralAt(referenceIndex, orderedNumerals) - debitNumeralValue;
        return totalContainsAmount(currentAmount, debitedAmt);
    }

    private int getValueOfNumeralAt(int index, List<RomanNumeral> numerals) throws CalculatorException {
        try {
            return pluckNumeral(index, numerals).getValue();
        } catch (NullPointerException npe) {
            throw new CalculatorException(String.format("No numeral present at index %d in numerals %s", index, numerals));
        }
    }

    private List<RomanNumeral> getNumeralsInDecimalOrdered() {
        List<RomanNumeral> numerals = new ArrayList<RomanNumeral>(Arrays.asList(RomanNumeral.values()));
        //// ordered high -> low
        Collections.sort(numerals, (e1, e2) -> {
            return e2.getValue() - e1.getValue();
        });
        return numerals;
    }

    private boolean sixOfOneOrHalfDozenOfOther(RomanNumeral debitNumeral, int currentIndex, List<RomanNumeral> orderedNumerals) {
        return debitNumeral.equals(pluckNumeral(currentIndex+1, orderedNumerals))
                && isLeadingDigitFive(debitNumeral.getValue());
    }

    private RomanNumeral pluckNumeral(int index, List<RomanNumeral> numerals) {
        try {
            return numerals.get(index);
        } catch(IndexOutOfBoundsException ex) {
            return null;
        }
    }

    private boolean isLeadingDigitFive(int number) {
        while (number / 10 > 0) {
            number /= 10;
        }
        return number == 5;
    }
}
