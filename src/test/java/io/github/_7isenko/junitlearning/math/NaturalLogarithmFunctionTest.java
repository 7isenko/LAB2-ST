package io.github._7isenko.junitlearning.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author 7isenko
 */
public class NaturalLogarithmFunctionTest {
    private static final double PRECISION = 0.001;

    private NaturalLogarithmFunction logarithmFunction;

    @BeforeEach
    void setupNaturalLogarithm() {
        logarithmFunction = new NaturalLogarithmFunction(PRECISION);
    }

    @Test
    void lnOfOneIsZero() {
        Assertions.assertEquals(0, logarithmFunction.apply(1));
    }

    @ParameterizedTest
    @ValueSource(doubles = {1, 1.1, 1.5, 2, 0.1, 0.5})
    void lnOfValidValuesIsComparableWithJavaMathLog(double x) {
        Assertions.assertEquals(Math.log(x), logarithmFunction.apply(x), (x < 1 ? PRECISION * 10 : PRECISION));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/math/ln_good.csv")
    void lnOfValidValuesReturnsExpectedResults(double x) {
        Assertions.assertEquals(Math.log(x), logarithmFunction.apply(x), (x < 1 ? PRECISION * 10 : PRECISION));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, 2.1})
    void lnOfBadValuesThrowsException(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> logarithmFunction.apply(x));
    }

}
