package io.github._7isenko.junitlearning.io;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author 7isenko
 */
public class DoublePairCSVBeanWriter {
    private StatefulBeanToCsv<DoublePairCSVBean> beanToCsvWriter;
    private Writer writer;

    public DoublePairCSVBeanWriter() {
    }

    public void open(File file) throws IOException {
        close();
        writer = new FileWriter(file);
        beanToCsvWriter = buildBeanWriter(writer);
    }

    public void write(DoublePairCSVBean pair) throws IOException {
        try {
            beanToCsvWriter.write(pair);
        } catch (CsvException e) {
            throw new IOException("Exception during csv field assignment: " + e.getMessage());
        }
    }

    public void close() throws IOException {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }

    protected StatefulBeanToCsv<DoublePairCSVBean> buildBeanWriter(Writer writer) {
        return new StatefulBeanToCsvBuilder<DoublePairCSVBean>(writer)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();
    }

}
