package io.github._7isenko.junitlearning.math;

import io.github._7isenko.junitlearning.utils.MathUtils;
import io.github._7isenko.junitlearning.utils.PrecisionLoopFunction;

import java.util.function.ToDoubleBiFunction;

/**
 * @author 7isenko
 */
public class SinusFunction extends PrecisionLoopFunction {

    public SinusFunction(double precision) {
        super(precision);
    }

    @Override
    protected ToDoubleBiFunction<Double, Integer> getFunction() {
        return (x, i) -> Math.pow(-1, i) * Math.pow(x, 2 * i + 1) / MathUtils.factorial(2 * i + 1);
    }
}
