package io.github.dwin357.model;

import io.github.dwin357.model.structs.Sign;

public class WorkingState {

    private int firstTerm;
    private int secondTerm;
    private Sign sign;
    private Integer solution;

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

    public Integer getSolution() {
        return solution;
    }

    public void setSolution(Integer solution) {
        this.solution = solution;
    }
}
