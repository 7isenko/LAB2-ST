package io.github._7isenko.junitlearning.math;

import java.util.function.ToDoubleBiFunction;

/**
 * @author 7isenko
 */
public class NaturalLogarithmFunction extends PrecisionLoopFunction {

    public NaturalLogarithmFunction(double precision) {
        super(precision);
    }

    @Override
    public Double apply(double x) {
        if (x <= 0 || x > 2) {
            throw new IllegalArgumentException("x not bigger than 0 and bigger than 2 can't be solved");
        }
        return super.apply(x);
    }

    @Override
    public ToDoubleBiFunction<Double, Integer> getFunction() {
        return (x, i) -> (((i - 1) % 2 == 0 ? 1 : -1) * Math.pow(x - 1, i)) / i;
    }

}
