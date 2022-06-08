package io.github._7isenko.junitlearning.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * @author 7isenko
 */
public class LogarithmFunctionIntegrationTest {
    private static final double PRECISION = 0.001;

    private NaturalLogarithmFunction lnSpy;

    private LogarithmFunction log2Spy;
    private LogarithmFunction log3Spy;
    private LogarithmFunction log10Spy;

    @BeforeEach
    void setupLogarithms() {
        lnSpy = Mockito.spy(new NaturalLogarithmFunction(PRECISION));

        log2Spy = Mockito.spy(new LogarithmFunction(2, PRECISION, lnSpy));
        log3Spy = Mockito.spy(new LogarithmFunction(3, PRECISION, lnSpy));
        log10Spy = Mockito.spy(new LogarithmFunction(10, PRECISION, lnSpy));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/log2_good.csv")
    void log2OfValidValuesReturnsExpectedResults(double x, double expected) {
        Assertions.assertEquals(expected, log2Spy.apply(x), PRECISION);
        Mockito.verify(log2Spy).apply(x);
        Mockito.verify(lnSpy).apply(x);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/log2_low_precision.csv")
    void log2OfValidBoundaryValuesReturnsExpectedResultsWithLowerPrecision(double x, double expected) {
        Assertions.assertEquals(expected, log2Spy.apply(x), PRECISION * 100);
        Mockito.verify(log2Spy).apply(x);
        Mockito.verify(lnSpy).apply(x);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/log3_good.csv")
    void log3OfValidValuesReturnsExpectedResults(double x, double expected) {
        Assertions.assertEquals(expected, log3Spy.apply(x), PRECISION);
        Mockito.verify(log3Spy).apply(x);
        Mockito.verify(lnSpy).apply(x);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/log3_low_precision.csv")
    void log3OfValidBoundaryValuesReturnsExpectedResultsWithLowerPrecision(double x, double expected) {
        Assertions.assertEquals(expected, log3Spy.apply(x), PRECISION * 10);
        Mockito.verify(log3Spy).apply(x);
        Mockito.verify(lnSpy).apply(x);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/log10_good.csv")
    void log10OfValidValuesReturnsExpectedResults(double x, double expected) {
        Assertions.assertEquals(expected, log10Spy.apply(x), PRECISION);
        Mockito.verify(log10Spy).apply(x);
        Mockito.verify(lnSpy).apply(x);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/log10_low_precision.csv")
    void log10OfValidBoundaryValuesReturnsExpectedResultsWithLowerPrecision(double x, double expected) {
        Assertions.assertEquals(expected, log10Spy.apply(x), PRECISION * 10);
        Mockito.verify(log10Spy).apply(x);
        Mockito.verify(lnSpy).apply(x);
    }

}
