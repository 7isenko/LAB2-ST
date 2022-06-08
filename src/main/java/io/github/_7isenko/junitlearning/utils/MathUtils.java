package io.github._7isenko.junitlearning.utils;

/**
 * @author 7isenko
 */
public class MathUtils {
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
