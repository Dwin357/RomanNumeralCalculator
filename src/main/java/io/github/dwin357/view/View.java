package io.github.dwin357.view;

import io.github.dwin357.model.WorkingState;

public interface View {
    <E extends Exception> String display(E badThings);

    String display(WorkingState state);
}
