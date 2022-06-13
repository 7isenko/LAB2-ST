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
public class LogarithmBase3FunctionTest {
    private static final double PRECISION = 0.001;

    @ParameterizedTest
    @CsvFileSource(resources = {"/math/log3_good.csv", "/math/log3_low_precision.csv"})
    void log3OfValidValuesReturnsExpectedResults(double x, double expected) {
        LogarithmFunction log3 = new LogarithmFunction(3, PRECISION, Math::log);
        Assertions.assertEquals(expected, log3.apply(x), PRECISION);
    }

    @Test
    void log3OfValidValueReturnsExpectedResult() {
        DoubleFunction<Double> lnMock = FunctionMocks.getLnMock();

        LogarithmFunction log3 = new LogarithmFunction(3, PRECISION, lnMock);
        Assertions.assertEquals(0, log3.apply(1));
    }

}
