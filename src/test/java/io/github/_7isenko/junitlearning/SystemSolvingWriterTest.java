package io.github._7isenko.junitlearning;

import io.github._7isenko.junitlearning.math.SystemFunction;
import io.github._7isenko.junitlearning.math.SystemFunctionIntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author 7isenko
 */
public class SystemSolvingWriterTest {

    @TempDir
    private Path testDirectory;
    private Path testPath;
    private SystemSolvingWriter writer;

    @BeforeEach
    void setupSystemFunction() {
        SystemFunction mockSystemFunction = Mockito.mock(SystemFunction.class);
        Mockito.when(mockSystemFunction.apply(Mockito.anyDouble()))
                .thenAnswer((invocationOnMock -> SystemFunctionIntegrationTest.calcReferenceValue(invocationOnMock.getArgument(0))));
        testPath = testDirectory.resolve("test.csv");
        writer = new SystemSolvingWriter(mockSystemFunction, testPath.toString());
    }

    @ParameterizedTest
    @CsvSource(value = {"1.1,-1", "1,-2.1"})
    void minBiggerThanMaxValueThrowsException(double min, double max) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> writer.produce(min, max, 0.1));
    }

    @Test
    void zeroStepThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> writer.produce(-1, 1, 0));
    }

    @Test
    void negativeStepThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> writer.produce(-1, 1, -1));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,1"})
    void minBiggerThanMaxValueThrowsException(double min, double max, double step) throws IOException {
        writer.produce(min, max, step);
        Assertions.assertEquals("1.0,NaN\n", Files.readString(testPath));
    }
}
