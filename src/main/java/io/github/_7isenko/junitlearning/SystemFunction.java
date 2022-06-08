package io.github._7isenko.junitlearning;

import java.util.function.DoubleFunction;

/**
 * @author 7isenko
 */
public class SystemFunction implements DoubleFunction<Double> {

    private final DoubleFunction<Double> sinFunction;
    private final DoubleFunction<Double> lnFunction;

    private final DoubleFunction<Double> log2Function;
    private final DoubleFunction<Double> log3Function;
    private final DoubleFunction<Double> log10Function;

    public SystemFunction(DoubleFunction<Double> sinFunction,
                          DoubleFunction<Double> lnFunction,
                          DoubleFunction<Double> log2Function,
                          DoubleFunction<Double> log3Function,
                          DoubleFunction<Double> log10Function) {
        this.sinFunction = sinFunction;
        this.lnFunction = lnFunction;
        this.log2Function = log2Function;
        this.log3Function = log3Function;
        this.log10Function = log10Function;
    }

    @Override
    public Double apply(double value) {
        if (value < -1 || value > 2) {
            throw new IllegalArgumentException("Input value is out of bounds");
        }

        if (value <= 0) {
            double sin = sinFunction.apply(value);

            double cos = Math.sqrt(1 - sin * sin);
            double tan = sin / cos;
            double sec = 1 / cos;
            double csc = 1 / sin;

            return (sec * sin * cos - sin * csc) / tan;
        } else {
            double ln = lnFunction.apply(value);

            double log2 = log2Function.apply(value);
            double log3 = log3Function.apply(value);
            double log10 = log10Function.apply(value);

            return (log2 * log10 * log3 - log3 * ln) / log3;
        }
    }
}
