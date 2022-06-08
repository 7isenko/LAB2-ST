package io.github._7isenko.junitlearning.math;

import java.util.function.DoubleFunction;
import java.util.function.ToDoubleBiFunction;

/**
 * @author 7isenko
 */
public abstract class PrecisionLoopFunction implements DoubleFunction<Double> {

    private final static int MAX_ITERATIONS = 512;

    private final double precision;

    public PrecisionLoopFunction(double precision) {
        this.precision = precision;
    }

    /**
     * First operand is an x of calculated point;
     * Second operand is index.
     * <p>
     * In case if (x, 0) is diverging, it will be set as 0
     *
     * @return lambda containing convergent function
     */
    protected abstract ToDoubleBiFunction<Double, Integer> getFunction();

    public Double apply(double x) {
        double result = calcFirstElement(x);

        for (int i = 1; i < MAX_ITERATIONS; i++) {
            double t = getFunction().applyAsDouble(x, i);

            if (Math.abs(t) < precision || Double.isNaN(t) || Double.isInfinite(t)) {
                break;
            }

            result += t;
        }
        return result;
    }

    private double calcFirstElement(double x) {
        double res = getFunction().applyAsDouble(x, 0);
        if (Double.isNaN(res) || Double.isInfinite(res)) {
            return 0;
        }
        return res;
    }

}
