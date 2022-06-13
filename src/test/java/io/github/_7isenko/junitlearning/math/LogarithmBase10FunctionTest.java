package io.github._7isenko.junitlearning.math;

import io.github._7isenko.junitlearning.math.mocks.FunctionMocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.function.DoubleFunction;

/**
 * @author 7isenko
 */
public class LogarithmBase10FunctionTest {
    private static final double PRECISION = 0.001;

    @ParameterizedTest
    @CsvFileSource(resources = {"/math/log10_good.csv", "/math/log10_low_precision.csv"})
    void log10OfValidValuesReturnsExpectedResults(double x, double expected) {
        LogarithmFunction log10 = new LogarithmFunction(10, PRECISION, Math::log);
        Assertions.assertEquals(expected, log10.apply(x), PRECISION);
    }

    @Test
    void log10OfValidValueReturnsExpectedResult() {
        DoubleFunction<Double> lnMock = FunctionMocks.getLnMock();

        LogarithmFunction log10 = new LogarithmFunction(10, PRECISION, lnMock);
        Assertions.assertEquals(0, log10.apply(1));
    }
}
