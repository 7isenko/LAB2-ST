package io.github._7isenko.junitlearning.io;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

/**
 * @author 7isenko
 */
public class DoublePairCSVBean {
    @CsvBindByName(column = "left")
    private final double left;
    @CsvBindByName(column = "right")
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
