package io.github._7isenko.junitlearning.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author 7isenko
 */
public class DoublePairCSVBeanWriterTest {

    private DoublePairCSVBeanWriter writer;

    @TempDir
    private Path testDirectory;
    private Path testPath;

    @BeforeEach
    void setupWriter() {
        writer = new DoublePairCSVBeanWriter();
        testPath = testDirectory.resolve("test.csv");
    }

    @Test
    void givenNoValueSavedWithoutException() throws IOException {
        writer.open(testPath.toFile());
        writer.close();

        Assertions.assertEquals("", Files.readString(testPath));
    }

    @Test
    void givenSingleValueSavedWithoutException() throws IOException {
        DoublePairCSVBean pair = new DoublePairCSVBean(1.4, 1.5);

        writer.open(testPath.toFile());
        writer.write(pair);
        writer.close();

        Assertions.assertEquals("1.4,1.5\n", Files.readString(testPath));
    }

    @Test
    void givenMultipleValuesSavedWithoutException() throws IOException {
        DoublePairCSVBean pair = new DoublePairCSVBean(1.4, 1.5);
        DoublePairCSVBean pair2 = new DoublePairCSVBean(-121.4, 0.544);
        DoublePairCSVBean pair3 = new DoublePairCSVBean(133769, 0);

        writer.open(testPath.toFile());
        writer.write(pair);
        writer.write(pair2);
        writer.write(pair3);
        writer.close();

        Assertions.assertEquals(
                "1.4,1.5\n" + "-121.4,0.544\n" + "133769.0,0.0\n", Files.readString(testPath));
    }

}
