package ohorobets.tests.unit.calculator;

import org.testng.annotations.DataProvider;

public class CalculatorUnitDataProviders {

    @DataProvider(name = "addPositiveProvider")
    public Object[][] addPositiveProvider() {
        return new Object[][]{
                {new Double[]{5d}, 5d},
                {new Double[]{-1d, -2d}, -3d},
                {new Double[]{1d, 2d, 3d}, 6d},
                {new Double[]{0d, 0d, 0d}, 0d},
                {new Double[]{1.123d, 2.222222d, 3.00001d}, 6.345232}
        };
    }

    @DataProvider(name = "subtractPositiveProvider")
    public Object[][] subtractPositiveProvider() {
        return new Object[][]{
                {10d, 3d, 7d},
                {5.5, 2.2, 3.3},
                {-5d, -5d, 0d},
                {0d, 10d, -10d},
                {12.555555, 3.9999999999, 8.5555550001}
        };
    }

    @DataProvider(name = "multiplyPositiveProvider")
    public Object[][] multiplyPositiveProvider() {
        return new Object[][]{
                {new Double[]{7d}, 7d},
                {new Double[]{-2d, 3d}, -6d},
                {new Double[]{2d, 3d, 4d}, 24d},
                {new Double[]{0d, 5d}, 0d},
                {new Double[]{2.00001, 1.001}, 2.00201001}
        };
    }

    @DataProvider(name = "dividePositiveProvider")
    public Object[][] dividePositiveProvider() {
        return new Object[][]{
                {10d, 2d, 5d},
                {5.5, 2d, 2.75},
                {-9d, 3d, -3d},
                {0d, 5d, 0d},
                {3.7, 2.111, 1.752723827569872}
        };
    }

    @DataProvider(name = "emptyArrayProvider")
    public Object[][] emptyArrayProvider() {
        return new Object[][]{
                {null},
                {new Double[]{}}
        };
    }

    @DataProvider(name = "arrayWithNullValueProvider")
    public Object[][] arrayWithNullValueProvider() {
        return new Object[][]{
                {new Double[]{null}},
                {new Double[]{null, null}},
                {new Double[]{0d, null}},
                {new Double[]{null, 0d}},
                {new Double[]{null, null, null}},
                {new Double[]{0d, null, null}},
                {new Double[]{null, 0d, null}},
                {new Double[]{null, null, 0d}}
        };
    }

    @DataProvider(name = "nullValueForSubtractProvider")
    public Object[][] nullValueForSubtractProvider() {
        return new Object[][]{
                {null, null, "Minuend"},
                {null, 5d, "Minuend"},
                {5d, null, "Subtrahend"}
        };
    }

    @DataProvider(name = "nullValueForDivideProvider")
    public Object[][] nullValueForDivideProvider() {
        return new Object[][]{
                {null, null, "Dividend"},
                {null, 5d, "Dividend"},
                {5d, null, "Divisor"}
        };
    }
}
