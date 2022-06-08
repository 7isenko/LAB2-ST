package io.github._7isenko.junitlearning.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * @author 7isenko
 */
public class PrecisionLoopFunctionTest {

    PrecisionLoopFunction mockPrecisionLoopFunction;

    @BeforeEach
    void setupPrecisionLoopFunction() {
        mockPrecisionLoopFunction = Mockito.mock(PrecisionLoopFunction.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    void calculationBreaksOnTooManyOperations() {
        Mockito.when(mockPrecisionLoopFunction.getFunction()).thenReturn((x, i) -> x);
        Assertions.assertEquals(PrecisionLoopFunction.MAX_ITERATIONS, mockPrecisionLoopFunction.apply(1));
    }

    @Test
    void calculationBreaksOnInfinity() {
        Mockito.when(mockPrecisionLoopFunction.getFunction()).thenReturn((x, i) -> i/(x-i));
        Assertions.assertEquals(1, mockPrecisionLoopFunction.apply(2));
        // 1) 0/2 = 0;    2) 1/1 = 1;    3) 2/0 = Inf;   Сумма = 1
    }

    @SuppressWarnings("PointlessArithmeticExpression") // очень даже не pointless, x != i
    @Test
    void calculationBreaksOnNaN() {
        Mockito.when(mockPrecisionLoopFunction.getFunction()).thenReturn((x, i) -> (x-i)/(x-i));
        Assertions.assertEquals(2, mockPrecisionLoopFunction.apply(2));
        // 1) 2/2 = 1;    2) 1/1 = 1;    3) 0/0 = NaN;   Сумма = 2
    }
}
