package io.github.dwin357.operation;

import io.github.dwin357.calculator.Calculator;
import io.github.dwin357.format.CommandLineArgParser;
import io.github.dwin357.output.OutputVector;
import io.github.dwin357.view.DecimalView;
import io.github.dwin357.model.CalculatorException;
import io.github.dwin357.model.WorkingState;
import io.github.dwin357.view.View;

public class Operation {

    private CommandLineArgParser argParser;
    private Calculator calc;
    private View view;
    private OutputVector out;

    public void perform(String[] clInput) {
        try {
            WorkingState calculatorState = argParser.makeWorkingState(clInput);
            calc.calculate(calculatorState);
            out.publish(view.display(calculatorState));

        } catch (CalculatorException e) {
            out.publish(view.display(e));
        }
    }




    ///////////////////////////
    ////  Getter + Setter  ////
    ///////////////////////////


    public Calculator getCalc() {
        return calc;
    }

    public void setCalc(Calculator calc) {
        this.calc = calc;
    }

    public CommandLineArgParser getArgParser() {
        return argParser;
    }

    public void setArgParser(CommandLineArgParser argParser) {
        this.argParser = argParser;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public OutputVector getOut() {
        return out;
    }

    public void setOut(OutputVector out) {
        this.out = out;
    }
}
