package com.places.client.formatter.csv;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.writer.CSVWriter;
import com.googlecode.jcsv.writer.internal.CSVWriterBuilder;
import com.places.client.model.Place;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVFileWriter {

    public void write(File file, List<Place> places) throws IOException {
        try (PrintWriter pw = new PrintWriter(file)) {

            CSVFormatter entryConverter = new CSVFormatter();
            CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);

            CSVWriterBuilder<Place> builder = new CSVWriterBuilder(pw);
            builder.entryConverter(entryConverter);
            builder.strategy(strategy);

            try (CSVWriter<Place> csvWriter = builder.build()) {
                csvWriter.writeAll(places);
            }
        }
    }
}
