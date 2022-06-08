package io.github._7isenko.junitlearning;

import io.github._7isenko.junitlearning.math.LogarithmFunction;
import io.github._7isenko.junitlearning.math.NaturalLogarithmFunction;
import io.github._7isenko.junitlearning.math.SinusFunction;

import java.util.function.DoubleFunction;

/**
 * @author 7isenko
 */
public class SystemFunction implements DoubleFunction<Double> {

    private final double precision;

    public SystemFunction(double precision) {
        this.precision = precision;
    }

    @Override
    public Double apply(double value) {
        if (value < -1 || value > 2) {
            throw new IllegalArgumentException("Input value is out of bounds");
        }

        if (value <= 0) {
            double sin = new SinusFunction(precision).apply(value);

            double cos = Math.sqrt(1 - sin * sin);
            double tan = sin / cos;
            double sec = 1 / cos;
            double csc = 1 / sin;

            return (sec * sin * cos - sin * csc) / tan;
        } else {
            double ln = new NaturalLogarithmFunction(precision).apply(value);

            double log2 = new LogarithmFunction(2, precision).apply(value);
            double log3 = new LogarithmFunction(3, precision).apply(value);
            double log10 = new LogarithmFunction(10, precision).apply(value);

            return (log2 * log10 * log3 - log3 * ln) / log3;
        }
    }
}
