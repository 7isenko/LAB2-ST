package io.github._7isenko.junitlearning.math.mocks;

import org.mockito.Mockito;

import java.util.function.DoubleFunction;

/**
 * @author 7isenko
 */
@SuppressWarnings("unchecked")
public class FunctionMocks {

    public static DoubleFunction<Double> getSinMock() {
        DoubleFunction<Double> mock = Mockito.mock(DoubleFunction.class);
        Mockito.when(mock.apply(0)).thenReturn(0D);
        Mockito.when(mock.apply(-0.5)).thenReturn(-0.4794255386D);
        return mock;
    }

    public static DoubleFunction<Double> getLnMock() {
        DoubleFunction<Double> mock = Mockito.mock(DoubleFunction.class);
        Mockito.when(mock.apply(0)).thenReturn(Double.NEGATIVE_INFINITY);
        Mockito.when(mock.apply(1)).thenReturn(0D);

        Mockito.when(mock.apply(Math.PI / 2)).thenReturn(0.45158270528D);
        return mock;
    }

    public static DoubleFunction<Double> getLog2Mock() {
        DoubleFunction<Double> mock = getLnMock();
        Mockito.when(mock.apply(Math.PI / 2)).thenReturn(0.65149612947D);
        return mock;
    }

    public static DoubleFunction<Double> getLog3Mock() {
        DoubleFunction<Double> mock = getLnMock();
        Mockito.when(mock.apply(Math.PI / 2)).thenReturn(0.41104829242D);
        return mock;
    }

    public static DoubleFunction<Double> getLog10Mock() {
        DoubleFunction<Double> mock = getLnMock();
        Mockito.when(mock.apply(Math.PI / 2)).thenReturn(0.196119877030D);
        return mock;
    }


}
