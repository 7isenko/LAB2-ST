package io.github._7isenko.junitlearning.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * @author 7isenko
 */
public class LogarithmBase3FunctionTest {
    private static final double PRECISION = 0.001;

    private LogarithmFunction log3;

    @BeforeEach
    void setupLog3() {
        log3 = new LogarithmFunction(3, PRECISION, Math::log);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/math/log3_good.csv", "/math/log3_low_precision.csv"})
    void log3OfValidValuesReturnsExpectedResults(double x, double expected) {
        Assertions.assertEquals(expected, log3.apply(x), PRECISION);
    }

}
