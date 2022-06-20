package stepDefinitions;

import helpers.BaseType;
import helpers.Calculator;
import helpers.TableColumnValues;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

/**
 * Step definitions
 */
public class CalculatorSteps {
    private static final String COLUMN_HAS_BIGGER_CALCULATION = "column has bigger calculation";
    private final TableColumnValues tableColumnValues = new TableColumnValues();
    private Calculator calculator;
    private BaseType<Object> firstParameter;
    private BaseType<Object> secondParameter;
    private BaseType<Object> expectedResult;
    private List<Integer> firstColumnValues;
    private List<Integer> secondColumnValues;
    private int actualIntResult;
    private double actualDoubleResult;
    private int totalOfColumn1;
    private int totalOfColumn2;

    @Given("Calculator of type {calculator}")
    public void sum_calculator(Calculator customCalculator) {
        calculator = customCalculator;
    }

    @Given("Integer a = {int} and integer b = {int}")
    public void number_a_and_number_b(int int1, int int2) {
        firstParameter = new BaseType<>(int1);
        secondParameter = new BaseType<>(int2);
    }

    @Given("Expected integer result {int}")
    public void expected_result(int expected) {
        expectedResult = new BaseType<>(expected);
    }

    @When("Call method calculate")
    public void call_method_calculate() {
        actualIntResult = calculator.calculate(firstParameter.getInteger(), secondParameter.getInteger());
    }

    @Then("Check actual and expected result")
    public void check_actual_and_expected_result() {
        Assert.assertEquals(expectedResult.getInteger(), actualIntResult);
    }

    @Given("Number  a = {} and number b = {}")
    public void double_a_and_double_b(Double double1, Double double2) {
        firstParameter = new BaseType<>(double1);
        secondParameter = new BaseType<>(double2);
    }

    @Given("Expected result {}")
    public void expected_result(Double expected) {
        expectedResult = new BaseType<>(expected);
    }


    @When("Call method for calculating")
    public void callMethodForCalculating() {
        actualDoubleResult = calculator.calculate(firstParameter.getDouble(), secondParameter.getDouble());
    }

    @Then("Check actual result and expected result")
    public void checkActualResultAndExpectedResult() {
        Assert.assertEquals(expectedResult.getDouble(), actualDoubleResult, 0.001);
    }

    @Given("the following table of numbers")
    public void the_following_table_of_numbers(io.cucumber.datatable.DataTable dataTable) {
        try {
            firstColumnValues = tableColumnValues.getValuesFromGivenColumn(dataTable, 1);
            secondColumnValues = tableColumnValues.getValuesFromGivenColumn(dataTable, 2);
        } catch (Exception e) {
            System.err.println("Invalid index of table\n" + dataTable);
        }
    }

    @When("Sum all numbers from the column_1 and column_2")
    public void sum_all_numbers_from_the_first_column_and_second_column() {
        totalOfColumn1 = tableColumnValues.sumListValues(firstColumnValues);
        totalOfColumn2 = tableColumnValues.sumListValues(secondColumnValues);
    }


    @Then("Verify which  column has the bigger calculation")
    public void verifyWhichColumnHasTheBiggerCalculation() {
        String message = totalOfColumn1 >= totalOfColumn2 ? "First " + COLUMN_HAS_BIGGER_CALCULATION : "Second " + COLUMN_HAS_BIGGER_CALCULATION;
        System.out.println(message);
    }

    @When("Calculate the difference of all the numbers in column_1 and column_2")
    public void calculateTheDifferenceOfAllTheNumbersInColumn1AndColumn2() {
        totalOfColumn1 = tableColumnValues.diffListValues(firstColumnValues);
        totalOfColumn2 = tableColumnValues.diffListValues(secondColumnValues);
    }
}
