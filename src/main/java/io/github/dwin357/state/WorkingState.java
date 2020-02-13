package io.github.dwin357.state;

public class WorkingState {

    private int firstTerm;
    private int secondTerm;
    private Sign sign;

    public WorkingState(int firstTerm, int secondTerm, Sign sign) {
        this.firstTerm = firstTerm;
        this.secondTerm = secondTerm;
        this.sign = sign;
    }

    public int getFirstTerm() {
        return firstTerm;
    }

    public int getSecondTerm() {
        return secondTerm;
    }

    public Sign getSign() {
        return sign;
    }
}
