package io.github._7isenko.junitlearning.math;

import io.github._7isenko.junitlearning.math.mocks.FunctionMocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.util.function.DoubleFunction;

/**
 * @author 7isenko
 */
public class LogarithmBase2FunctionTest {
    private static final double PRECISION = 0.001;

    @ParameterizedTest
    @CsvFileSource(resources = {"/math/log2_good.csv", "/math/log2_low_precision.csv"})
    void log2OfValidValuesReturnsExpectedResults(double x, double expected) {
        LogarithmFunction log2 = new LogarithmFunction(2, PRECISION, Math::log);
        Assertions.assertEquals(expected, log2.apply(x), PRECISION);
    }

    @Test
    void log2OfValidValueReturnsExpectedResult() {
        DoubleFunction<Double> lnMock = FunctionMocks.getLnMock();

        LogarithmFunction log2 = new LogarithmFunction(2, PRECISION, lnMock);
        Assertions.assertEquals(0, log2.apply(1));
    }
}
