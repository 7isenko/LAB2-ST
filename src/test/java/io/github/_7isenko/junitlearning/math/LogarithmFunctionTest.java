package io.github._7isenko.junitlearning.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * @author 7isenko
 */
public class LogarithmFunctionTest {
    private static final double PRECISION = 0.001;

    private final LogarithmFunction log2 = new LogarithmFunction(PRECISION, 2);
    private final LogarithmFunction log3 = new LogarithmFunction(PRECISION, 3);
    private final LogarithmFunction log10 = new LogarithmFunction(PRECISION, 10);

    @ParameterizedTest
    @CsvFileSource(resources = "/math/log2_good.csv")
    void log2OfValidValuesReturnsExpectedResults(double x, double expected) {
        Assertions.assertEquals(expected, log2.apply(x), PRECISION);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/log2_low_precision.csv")
    void log2OfValidBoundaryValuesReturnsExpectedResultsWithLowerPrecision(double x, double expected) {
        Assertions.assertEquals(expected, log2.apply(x), PRECISION*100);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/log3_good.csv")
    void log3OfValidValuesReturnsExpectedResults(double x, double expected) {
        Assertions.assertEquals(expected, log3.apply(x), PRECISION);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/log3_low_precision.csv")
    void log3OfValidBoundaryValuesReturnsExpectedResultsWithLowerPrecision(double x, double expected) {
        Assertions.assertEquals(expected, log3.apply(x), PRECISION*10);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/log10_good.csv")
    void log10OfValidValuesReturnsExpectedResults(double x, double expected) {
        Assertions.assertEquals(expected, log10.apply(x), PRECISION);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/log10_low_precision.csv")
    void log10OfValidBoundaryValuesReturnsExpectedResultsWithLowerPrecision(double x, double expected) {
        Assertions.assertEquals(expected, log10.apply(x), PRECISION*10);
    }

}
