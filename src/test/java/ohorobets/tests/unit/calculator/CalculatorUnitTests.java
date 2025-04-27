package ohorobets.tests.unit.calculator;

import ohorobets.calculator.Calculator;
import ohorobets.tests.unit.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ohorobets.containers.GroupsContainers.ADD;
import static ohorobets.containers.GroupsContainers.ALL;
import static ohorobets.containers.GroupsContainers.CALCULATOR;
import static ohorobets.containers.GroupsContainers.DIVIDE;
import static ohorobets.containers.GroupsContainers.MULTIPLY;
import static ohorobets.containers.GroupsContainers.NEGATIVE;
import static ohorobets.containers.GroupsContainers.POSITIVE;
import static ohorobets.containers.GroupsContainers.SUBTRACT;
import static ohorobets.containers.GroupsContainers.UNIT;

public class CalculatorUnitTests extends BaseTest {

    private static final String EMPTY_ARRAY_MSG = "Numbers array is empty";
    private static final String NULL_VALUE_MSG_PATTERN = "%s is null";
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void setUpBeforeClass() {
        calculator = new Calculator();
    }

    @Test(groups = {ALL, UNIT, POSITIVE, CALCULATOR, ADD},
            dataProviderClass = CalculatorUnitDataProviders.class, dataProvider = "addPositiveProvider")
    public void addPositiveUnitTest(Double[] input, Double expected) {
        Double actual = calculator.add(input);
        Assert.assertEquals(actual, expected, "Addition result is incorrect");
    }

    @Test(groups = {ALL, UNIT, POSITIVE, CALCULATOR, SUBTRACT},
            dataProviderClass = CalculatorUnitDataProviders.class, dataProvider = "subtractPositiveProvider")
    public void subtractPositiveUnitTest(Double minuend, Double subtrahend, Double expected) {
        Double actual = calculator.subtract(minuend, subtrahend);
        Assert.assertEquals(actual, expected, "Subtraction result is incorrect");
    }

    @Test(groups = {ALL, UNIT, POSITIVE, CALCULATOR, MULTIPLY},
            dataProviderClass = CalculatorUnitDataProviders.class, dataProvider = "multiplyPositiveProvider")
    public void multiplyPositiveUnitTest(Double[] input, Double expected) {
        Double actual = calculator.multiply(input);
        Assert.assertEquals(actual, expected, "Multiplication result is incorrect");
    }

    @Test(groups = {ALL, UNIT, POSITIVE, CALCULATOR, DIVIDE},
            dataProviderClass = CalculatorUnitDataProviders.class, dataProvider = "dividePositiveProvider")
    public void dividePositiveUnitTest(Double dividend, Double divisor, Double expected) {
        Double actual = calculator.divide(dividend, divisor);
        Assert.assertEquals(actual, expected, "Division result is incorrect");
    }

    @Test(groups = {ALL, UNIT, NEGATIVE, CALCULATOR, ADD},
            dataProviderClass = CalculatorUnitDataProviders.class, dataProvider = "emptyArrayProvider")
    public void addWithEmptyInputUnitTest(Double[] input) {
        Assert.assertThrows(EMPTY_ARRAY_MSG, IllegalArgumentException.class, () -> calculator.add(input));
    }

    @Test(groups = {ALL, UNIT, NEGATIVE, CALCULATOR, MULTIPLY},
            dataProviderClass = CalculatorUnitDataProviders.class, dataProvider = "emptyArrayProvider")
    public void multiplyWithEmptyInputUnitTest(Double[] input) {
        Assert.assertThrows(EMPTY_ARRAY_MSG, IllegalArgumentException.class, () -> calculator.multiply(input));
    }

    @Test(groups = {ALL, UNIT, NEGATIVE, CALCULATOR, ADD},
            dataProviderClass = CalculatorUnitDataProviders.class, dataProvider = "arrayWithNullValueProvider")
    public void addWithNullValueInInputUnitTest(Double[] input) {
        Assert.assertThrows(String.format(NULL_VALUE_MSG_PATTERN, "Number"),
                IllegalArgumentException.class,
                () -> calculator.add(input));
    }

    @Test(groups = {ALL, UNIT, NEGATIVE, CALCULATOR, MULTIPLY},
            dataProviderClass = CalculatorUnitDataProviders.class, dataProvider = "arrayWithNullValueProvider")
    public void multiplyWithNullValueInInputUnitTest(Double[] input) {
        Assert.assertThrows(String.format(NULL_VALUE_MSG_PATTERN, "Number"),
                IllegalArgumentException.class,
                () -> calculator.multiply(input));
    }

    @Test(groups = {ALL, UNIT, NEGATIVE, CALCULATOR, SUBTRACT},
            dataProviderClass = CalculatorUnitDataProviders.class, dataProvider = "nullValueForSubtractProvider")
    public void subtractWithNullValueUnitTest(Double minuend, Double subtrahend, String operandName) {
        Assert.assertThrows(String.format(NULL_VALUE_MSG_PATTERN, operandName),
                IllegalArgumentException.class,
                () -> calculator.subtract(minuend, subtrahend));
    }

    @Test(groups = {ALL, UNIT, NEGATIVE, CALCULATOR, DIVIDE},
            dataProviderClass = CalculatorUnitDataProviders.class, dataProvider = "nullValueForDivideProvider")
    public void divideWithNullValueUnitTest(Double dividend, Double divisor, String operandName) {
        Assert.assertThrows(String.format(NULL_VALUE_MSG_PATTERN, operandName),
                IllegalArgumentException.class,
                () -> calculator.divide(dividend, divisor));
    }

    @Test(groups = {ALL, UNIT, NEGATIVE, CALCULATOR, DIVIDE})
    public void divideByZeroUnitTest() {
        Assert.assertThrows("Divisor is zero",
                ArithmeticException.class,
                () -> calculator.divide(1d, 0d));
    }
}
