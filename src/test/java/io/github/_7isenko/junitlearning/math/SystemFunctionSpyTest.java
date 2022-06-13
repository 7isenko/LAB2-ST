package io.github._7isenko.junitlearning.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.function.DoubleFunction;

/**
 * @author 7isenko
 */
public class SystemFunctionSpyTest {

    private static final double PRECISION = 0.001;
    private SystemFunction systemFunctionSpy;
    private DoubleFunction<Double> sinFunctionSpy;
    private DoubleFunction<Double> lnFunctionSpy;
    private DoubleFunction<Double> log2FunctionSpy;
    private DoubleFunction<Double> log3FunctionSpy;
    private DoubleFunction<Double> log10FunctionSpy;

    @BeforeEach
    void setupSystemFunction() {
        sinFunctionSpy = Mockito.spy(new SinusFunction(PRECISION));
        lnFunctionSpy = Mockito.spy(new NaturalLogarithmFunction(PRECISION));
        log2FunctionSpy = Mockito.spy(new LogarithmFunction(2, PRECISION, lnFunctionSpy));
        log3FunctionSpy = Mockito.spy(new LogarithmFunction(3, PRECISION, lnFunctionSpy));
        log10FunctionSpy = Mockito.spy(new LogarithmFunction(10, PRECISION, lnFunctionSpy));

        SystemFunction s = new SystemFunction(sinFunctionSpy, lnFunctionSpy, log2FunctionSpy, log3FunctionSpy, log10FunctionSpy);
        systemFunctionSpy = Mockito.spy(s);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0})
    void onNotPositiveValuesSinShouldBeExecuted(double x) {
        systemFunctionSpy.apply(x);
        Mockito.verify(sinFunctionSpy).apply(x);
        Mockito.verify(lnFunctionSpy, Mockito.never()).apply(x);
        Mockito.verify(log2FunctionSpy, Mockito.never()).apply(x);
        Mockito.verify(log3FunctionSpy, Mockito.never()).apply(x);
        Mockito.verify(log10FunctionSpy, Mockito.never()).apply(x);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 1, 2})
    void onPositiveValuesLogShouldBeExecuted(double x) {
        systemFunctionSpy.apply(x);
        Mockito.verify(sinFunctionSpy, Mockito.never()).apply(x);
        Mockito.verify(lnFunctionSpy, Mockito.times(4)).apply(x);
        Mockito.verify(log2FunctionSpy).apply(x);
        Mockito.verify(log3FunctionSpy).apply(x);
        Mockito.verify(log10FunctionSpy).apply(x);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -0.5, 0, 0.5, 1, 1.5, 2})
    void functionReturnsComparableWithJavaMathResults(double x) {
        Assertions.assertEquals(calcReferenceValue(x), systemFunctionSpy.apply(x), PRECISION * 2);
    }

    public static double calcReferenceValue(double value) {
        if (value <= 0) {
            double sin = Math.sin(value);
            double cos = Math.cos(value);
            double tan = Math.tan(value);
            double sec = 1 / cos;
            double csc = 1 / sin;

            return (sec * sin * cos - sin * csc) / tan;
        } else {
            double ln = Math.log(value);

            double log2 = ln / Math.log(2);
            double log3 = ln / Math.log(3);
            double log10 = Math.log10(value);

            return (log2 * log10 * log3 - log3 * ln) / log3;
        }
    }
}
