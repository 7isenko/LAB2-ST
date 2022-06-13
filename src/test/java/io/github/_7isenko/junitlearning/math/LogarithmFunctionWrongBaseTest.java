package io.github._7isenko.junitlearning.math;

import io.github._7isenko.junitlearning.math.mocks.FunctionMocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.DoubleFunction;

/**
 * @author 7isenko
 */
public class LogarithmFunctionWrongBaseTest {
    private static final double PRECISION = 0.001;
    private final DoubleFunction<Double> lnMock = FunctionMocks.getLnMock();

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 4, 5, 25})
    void illegalBaseThrowsException(int base) {
        Assertions.assertThrows(Exception.class, () -> new LogarithmFunction(base, PRECISION, lnMock));
    }

}
