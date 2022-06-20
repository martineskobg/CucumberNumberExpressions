package helpers;

import io.cucumber.datatable.DataTable;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TableColumnValues {
    private final SumCalculatorHelper sumCalculatorHelper = new SumCalculatorHelper();
    private final DifferenceCalculatorHelper differenceCalculatorHelper = new DifferenceCalculatorHelper();

    /**
     * Extract all values in given column and return them as List of Integers
     *
     * @param dataTable
     * @param indexOfColumn
     * @return List<Integer>
     * @throws InvalidKeyException
     */
    public List<Integer> getValuesFromGivenColumn(DataTable dataTable, int indexOfColumn) throws InvalidKeyException {
        List<Integer> values = new ArrayList<>();
        // Set column name 
        String key = "col_" + indexOfColumn;
        // Throw an exception if the column name does not exist
        if (!dataTable.asMaps(String.class, String.class).get(indexOfColumn).containsKey(key)) {
            throw new InvalidKeyException();
        }
        // Parsing the values of the column to Integer and add them to a List<Integer>
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            values.add(Integer.valueOf(row.get(key)));
        }
        return values;
    }

    /**
     * Sum all values in given List by using SumCalculatorHelper
     * @param list
     * @return Integer
     */
    public int sumListValues(List<Integer> list) {
        int total = 0;
        // Foreach all values and add them to total
        for (Integer integer : list) {
            total = sumCalculatorHelper.calculate(total, integer);
        }
        return total;
    }

    /**
     *  Calculate the difference of all numbers in given List by using DifferenceCalculatorHelper
     * @param list
     * @return Integer
     */
    public int diffListValues(List<Integer> list) {
        // Set total to be equal to the first element of the list
        // and multiply it by 2 to avoid loss of data
        // since it is using DifferenceCalculatorHelper
        int total = list.get(0)*2;
        for (Integer integer : list) {
            total = differenceCalculatorHelper.calculate(total, integer);
        }
        return total;
    }
}
