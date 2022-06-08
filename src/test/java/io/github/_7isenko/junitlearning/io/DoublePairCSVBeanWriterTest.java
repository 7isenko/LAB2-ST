package io.github._7isenko.junitlearning.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author 7isenko
 */
public class DoublePairCSVBeanWriterTest {

    private DoublePairCSVBeanWriter writer;

    @TempDir
    private Path testDirectory;

    @BeforeEach
    void setupWriter() {
        writer = new DoublePairCSVBeanWriter();
    }

    @Test
    void givenSingleValueSavedWithoutException() throws IOException {
        DoublePairCSVBean pair = new DoublePairCSVBean(1.4, 1.5);

        writer.open(appendTestDirectory("test.csv"));
        writer.write(pair);
        writer.close();
    }

    private String appendTestDirectory(String filename) {
        return testDirectory + "\\" + filename;
    }
}
