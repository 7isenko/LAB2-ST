package io.github._7isenko.junitlearning.io;

import com.opencsv.bean.CsvBindByPosition;

/**
 * @author 7isenko
 */
public class DoublePairCSVBean {
    @CsvBindByPosition(position = 0)
    private final double left;
    @CsvBindByPosition(position = 1)
    private final double right;

    public DoublePairCSVBean(double left, double right) {
        this.left = left;
        this.right = right;
    }

    public double getLeft() {
        return left;
    }

    public double getRight() {
        return right;
    }


}
