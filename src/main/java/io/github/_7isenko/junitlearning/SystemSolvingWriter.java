package io.github._7isenko.junitlearning;

import io.github._7isenko.junitlearning.io.DoublePairCSVBean;
import io.github._7isenko.junitlearning.io.DoublePairCSVBeanWriter;
import io.github._7isenko.junitlearning.math.SystemFunction;

import java.io.File;
import java.io.IOException;

/**
 * @author 7isenko
 */
public class SystemSolvingWriter {
    private final SystemFunction systemFunction;
    private final String file;

    public SystemSolvingWriter(SystemFunction systemFunction, String file) {
        this.systemFunction = systemFunction;
        this.file = file;
    }

    public void produce(double min, double max, double step) throws IOException, IllegalArgumentException {
        assertValid(min, max, step);

        DoublePairCSVBeanWriter writer = new DoublePairCSVBeanWriter();
        writer.open(new File(file));

        double x = min;
        while (x <= max) {
            writer.write(new DoublePairCSVBean(x, systemFunction.apply(x)));
            x += step;
        }

        writer.close();
    }

    private void assertValid(double min, double max, double step) {
        if (max < min) {
            throw new IllegalArgumentException("given max number is bigger than min");
        }
        if (step <= 0) {
            throw new IllegalArgumentException("step should be bigger than zero");
        }
    }

}
