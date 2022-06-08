package io.github._7isenko.junitlearning.math;

import java.util.HashMap;
import java.util.function.DoubleFunction;

/**
 * @author 7isenko
 */
public class LogarithmFunction implements DoubleFunction<Double> {

    private final static HashMap<Integer, Double> BASES;

    private final double precision;
    private final double precalculatedBase;

    static {
        BASES = new HashMap<>();
        BASES.put(2, 0.69314718056);
        BASES.put(3, 1.09861228867);
        BASES.put(10, 2.30258509299);
    }

    public LogarithmFunction(double precision, int base) {
        this.precision = precision;
        this.precalculatedBase = BASES.get(base);
    }

    @Override
    public Double apply(double value) {
        NaturalLogarithmFunction naturalLogarithmFunction = new NaturalLogarithmFunction(precision);
        return naturalLogarithmFunction.apply(value) / precalculatedBase;
    }

}
