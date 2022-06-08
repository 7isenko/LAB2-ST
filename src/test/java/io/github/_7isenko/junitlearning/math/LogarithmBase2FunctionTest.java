package io.github._7isenko.junitlearning.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * @author 7isenko
 */
public class LogarithmBase2FunctionTest {
    private static final double PRECISION = 0.001;

    private LogarithmFunction log2;

    @BeforeEach
    void setupLog2() {
        log2 = new LogarithmFunction(2, PRECISION, Math::log);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/math/log2_good.csv", "/math/log2_low_precision.csv"})
    void log2OfValidValuesReturnsExpectedResults(double x, double expected) {
        Assertions.assertEquals(expected, log2.apply(x), PRECISION);
    }

}
