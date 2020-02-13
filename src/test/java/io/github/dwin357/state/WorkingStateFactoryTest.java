package io.github.dwin357.state;

import org.junit.Test;

import static io.github.dwin357.state.Sign.ADD;
import static org.junit.Assert.*;

public class WorkingStateFactoryTest {

    @Test
    public void makeWorkingState() {
        String[] clArgs = {"I", "+", "II"};
        int expectedFirstTerm = 1;
        Sign expectedSign = ADD;
        int expectedSecondTerm = 2;

        WorkingState actual = WorkingStateFactory.makeWorkingState(clArgs);

        assertEquals("first term", expectedFirstTerm, actual.getFirstTerm());
        assertEquals("sign", expectedSign, actual.getSign());
        assertEquals("second term", expectedSecondTerm, actual.getSecondTerm());
    }
}