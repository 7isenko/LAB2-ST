package io.github._7isenko.junitlearning.io;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvFieldAssignmentException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author 7isenko
 */
public class CSVDoublePairWriter {
    private StatefulBeanToCsv<CSVDoublePair> sbc;
    private Writer writer;

    public CSVDoublePairWriter() {
    }

    public void open(String path) throws IOException {
        if (writer != null) writer.close();
        writer = new FileWriter(path);
        sbc = new StatefulBeanToCsvBuilder<CSVDoublePair>(writer)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();
    }

    public void write(CSVDoublePair pair) throws IOException {
        try {
            sbc.write(pair);
        } catch (CsvFieldAssignmentException e) {
            throw new IOException("Exception during csv field assignment: " + e.getMessage());
        }
    }

    public void close() throws IOException {
        writer.close();
        writer = null;
    }
}
