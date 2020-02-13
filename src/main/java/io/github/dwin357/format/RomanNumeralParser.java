package io.github.dwin357.format;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralParser {

    private static final Map<String, Integer> NUMERAL_DICTIONARY;
    static {
        Map<String, Integer> numerals = new HashMap<>();
        numerals.put("I", 1);
        numerals.put("V", 5);
        numerals.put("X", 10);
        numerals.put("L", 50);
        numerals.put("C", 100);
        numerals.put("D", 500);
        numerals.put("M", 1000);
        NUMERAL_DICTIONARY = numerals;
    }

    public static int parse(String romanNumeral) {
        int runnintTotal = 0;
        String[] letters = romanNumeral.split("");
        for(int i=0; i < letters.length; i++) {
            runnintTotal += getSign(i, letters) * NUMERAL_DICTIONARY.get(letters[i]);
        }
        return runnintTotal;
    }

    private static int getSign(int index, String[] letters) {
        int nextPosition = index + 1;
        if(nextPosition == letters.length) {
            return 1;
        }
        return getNumber(letters[index]) < getNumber(letters[nextPosition]) ? -1 : 1;
    }
    private static int getNumber(String letter) {
        return NUMERAL_DICTIONARY.get(letter);
    }
}
