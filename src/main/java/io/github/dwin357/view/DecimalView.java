package io.github.dwin357.view;

import io.github.dwin357.model.WorkingState;

public class DecimalView implements View {

    @Override
    public <E extends Exception> String display(E badThings) {
        return badThings.getMessage();
    }

    @Override
    public String display(WorkingState state) {
        return String.format("Answer is %d", state.getSolution());
    }

}
