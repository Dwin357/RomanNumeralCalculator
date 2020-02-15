package io.github.dwin357.model;

import io.github.dwin357.model.structs.Sign;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkingStateTest {

    @Test
    public void getters() {
        int first = 1;
        int second = 2;
        Sign plus = Sign.ADD;

        WorkingState testedState = new WorkingState(first, second, plus);

        assertEquals("first term", first, testedState.getFirstTerm());
        assertEquals("second term", second, testedState.getSecondTerm());
        assertEquals("sign", plus, testedState.getSign());
    }

    @Test
    public void solution() {
        int first = 1;
        int second = 2;
        Sign plus = Sign.ADD;

        WorkingState testedState = new WorkingState(first, second, plus);

        assertNull("Solution not initialized to null", testedState.getSolution());
        testedState.setSolution(42);
        assertEquals("Solution incorrect", new Integer(42), testedState.getSolution());
    }
}