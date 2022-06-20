package stepDefinitions.parameters;

import helpers.Calculator;
import helpers.DifferenceCalculatorHelper;
import helpers.SumCalculatorHelper;
import io.cucumber.java.ParameterType;

public class ParameterTypes {

    @ParameterType("SumCalculator|DifferenceCalculator")
    public Calculator calculator(String calculatorType){
        return calculatorType.equals("DifferenceCalculator") ?
                new DifferenceCalculatorHelper() : new SumCalculatorHelper();
    }
}
