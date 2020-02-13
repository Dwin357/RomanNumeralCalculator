package io.github.dwin357.output;

public class SystemOutput implements OutputVector {

    @Override
    public void publish(String msg) {
        System.out.println(msg);
    }
}
