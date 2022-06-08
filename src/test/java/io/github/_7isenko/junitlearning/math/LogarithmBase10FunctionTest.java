package io.github._7isenko.junitlearning.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * @author 7isenko
 */
public class LogarithmBase10FunctionTest {
    private static final double PRECISION = 0.001;

    private LogarithmFunction log10;

    @BeforeEach
    void setupLog10() {
        log10 = new LogarithmFunction(10, PRECISION, Math::log);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/math/log10_good.csv", "/math/log10_low_precision.csv"})
    void log10OfValidValuesReturnsExpectedResults(double x, double expected) {
        Assertions.assertEquals(expected, log10.apply(x), PRECISION);
    }

}
