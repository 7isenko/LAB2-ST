package io.github._7isenko.junitlearning.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.function.DoubleFunction;

/**
 * @author 7isenko
 */
public class LogarithmFunctionTest {
    private static final double PRECISION = 0.001;

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 4, 5, 25})
    void illegalBaseThrowsException(int base) {
        Assertions.assertThrows(Exception.class, () -> new LogarithmFunction(base, PRECISION, Math::log));
    }

}
