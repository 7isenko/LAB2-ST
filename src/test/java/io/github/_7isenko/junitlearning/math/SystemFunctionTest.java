package io.github._7isenko.junitlearning.math;

import io.github._7isenko.junitlearning.math.mocks.FunctionMocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.DoubleFunction;

/**
 * @author 7isenko
 */
public class SystemFunctionTest {

    private SystemFunction systemFunction;
    private final DoubleFunction<Double> sinFunction = FunctionMocks.getSinMock();
    private final DoubleFunction<Double> lnFunction = FunctionMocks.getLnMock();
    private final DoubleFunction<Double> log2Function = FunctionMocks.getLog2Mock();
    private final DoubleFunction<Double> log3Function = FunctionMocks.getLog3Mock();
    private final DoubleFunction<Double> log10Function = FunctionMocks.getLog10Mock();

    @BeforeEach
    void setupSystemFunction() {
        systemFunction = new SystemFunction(sinFunction, lnFunction, log2Function, log3Function, log10Function);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10, -1.1, 2.1, 10})
    void shouldThrowExceptionOnBadValues(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> systemFunction.apply(x));
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 2})
    void shouldCalculateRightOnValidInputOfPositive(double x) {
        Assertions.assertEquals(-0.32381136449172328D, systemFunction.apply(x), 0.0001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1})
    void shouldReturnNaNOnValidInputOfOne(double x) {
        Assertions.assertEquals(Double.NaN, systemFunction.apply(x));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0})
    void shouldReturnNaNOnValidInputOnZero(double x) {
        Assertions.assertTrue(systemFunction.apply(x).isNaN());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.5})
    void shouldCalculateRightOnValidInputOfNegative(double x) {
        Assertions.assertEquals(2.70807D, systemFunction.apply(x), 0.0001);
    }
}
