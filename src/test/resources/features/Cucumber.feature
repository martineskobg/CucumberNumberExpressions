Feature: Verify the output from given calculator

  Rule: Will calculate only integers and the result will be always Integer
    Scenario: Check the result after summing two int numbers
      Given Calculator of type SumCalculator
      And Integer a = 3 and integer b = 5
      And Expected integer result 8
      When Call method calculate
      Then Check actual and expected result

    Scenario: Check the result after subtracting two int numbers
      Given Calculator of type DifferenceCalculator
      And Integer a = 10 and integer b = 6
      And Expected integer result 4
      When Call method calculate
      Then Check actual and expected result

  Rule: Will calculate any number but result will be always different from Integer
    Scenario: Check the result after summing two double numbers
      Given Calculator of type SumCalculator
      And Number  a = 1.2 and number b = 3.0
      And Expected result 3.4
      When Call method for calculating
      Then Check actual result and expected result

    Scenario: Check the result after subtracting two double numbers
      Given Calculator of type DifferenceCalculator
      And Number  a = 7.5 and number b = 2.5
      And Expected result 3.8
      When Call method for calculating
      Then Check actual result and expected result

# Compare two columns with numbers
  Rule: Will use calculator of type SUM
    Scenario: Using a sum calculator verify which  column has the bigger calculation
      Given Calculator of type SumCalculator
      Given the following table of numbers
        | col_1 | col_2 |
        | 4     | 2     |
        | 33    | 7     |
        | 4     | 2     |
        | 50    | 34    |
      When Sum all numbers from the column_1 and column_2
      Then Verify which  column has the bigger calculation

  Rule: Will use calculator of type DIFF
    Scenario: Using a diff calculator verify which  column has the bigger calculation
      Given Calculator of type DifferenceCalculator
      Given the following table of numbers
        | col_1 | col_2 |
        | 4     | 2     |
        | 33    | 7     |
        | 4     | 2     |
        | 50    | 34    |
      When Calculate the difference of all the numbers in column_1 and column_2
      Then Verify which  column has the bigger calculation