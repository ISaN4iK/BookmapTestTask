package ohorobets.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Calculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Calculator.class);

    public Double add(Double... nums) {
        LOGGER.info("Starting add method with input {}", (Object) nums);
        Double result = 0d;
        checkArrayNotEmpty(nums);
        for (Double num : nums) {
            checkNumNotNull(num);
            result += num;
        }
        LOGGER.info("Finished add method. Result: {}", result);
        return result;
    }

    public Double subtract(Double minuend, Double subtrahend) {
        LOGGER.info("Starting subtract method. Minuend = {}, subtrahend = {}", minuend, subtrahend);
        checkNumNotNull(minuend, "Minuend");
        checkNumNotNull(subtrahend, "Subtrahend");
        Double result = minuend - subtrahend;
        LOGGER.info("Finished subtract method. Result: {}", result);
        return result;
    }

    public Double multiply(Double... nums) {
        LOGGER.info("Starting multiply method with input {}", (Object) nums);
        Double result = 1d;
        checkArrayNotEmpty(nums);
        for (Double num : nums) {
            checkNumNotNull(num);
            result *= num;
        }
        LOGGER.info("Finished multiply method. Result: {}", result);
        return result;
    }

    public Double divide(Double dividend, Double divisor) {
        LOGGER.info("Starting dividend method. Dividend = {}, divisor = {}", dividend, divisor);
        checkNumNotNull(dividend, "Dividend");
        checkNumNotNull(divisor, "Divisor");
        if (divisor.equals(0d)) {
            throw new ArithmeticException("Divisor is zero");
        }
        Double result = dividend / divisor;
        LOGGER.info("Finished divide method. Result: {}", result);
        return result;
    }

    private void checkNumNotNull(Double num) {
        checkNumNotNull(num, "Number");
    }

    private void checkNumNotNull(Double num, String name) {
        if (Objects.isNull(num)) {
            LOGGER.error("Input has null value");
            throw new IllegalArgumentException(String.format("%s is null", name));
        }
    }

    private void checkArrayNotEmpty(Double... nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            LOGGER.error("Input array is empty");
            throw new IllegalArgumentException("Numbers array is empty");
        }
    }
}