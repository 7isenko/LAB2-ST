package io.github._7isenko.junitlearning.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * @author 7isenko
 */
public class SinusFunctionTest {
    private static final double PRECISION = 0.001;

    private SinusFunction sinusFunction;

    @BeforeEach
    void setupSinus() {
        sinusFunction = new SinusFunction(PRECISION);
    }

    @Test
    public void sinOfZeroIsZero() {
        Assertions.assertEquals(0, sinusFunction.apply(0));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/sin_good.csv")
    public void sinTest(double x, double expected) {
        Assertions.assertEquals(expected, sinusFunction.apply(x), PRECISION);
    }
}
