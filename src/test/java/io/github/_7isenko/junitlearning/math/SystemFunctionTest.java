package io.github._7isenko.junitlearning.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.function.DoubleFunction;

/**
 * @author 7isenko
 */
@SuppressWarnings("unchecked")
public class SystemFunctionTest {

    private SystemFunction systemFunction;

    @BeforeEach
    void setupSystemFunction() {
        DoubleFunction<Double> mockFunction = Mockito.mock(DoubleFunction.class);
        systemFunction = new SystemFunction(mockFunction, mockFunction, mockFunction, mockFunction, mockFunction);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10, -1.1, 2.1, 10})
    void shouldThrowExceptionOnBadValues(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, ()->systemFunction.apply(x));
    }
}
