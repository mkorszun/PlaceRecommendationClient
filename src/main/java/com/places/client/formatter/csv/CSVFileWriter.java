package com.places.client.formatter.csv;

import com.googlecode.jcsv.writer.CSVWriter;
import com.googlecode.jcsv.writer.internal.CSVWriterBuilder;
import com.places.client.model.Place;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVFileWriter {

    public void write(File file, List<Place> places) throws IOException {
        PrintWriter pw = new PrintWriter(file);
        CSVFormatter entryConverter = new CSVFormatter();
        CSVWriterBuilder<Place> builder = new CSVWriterBuilder(pw);

        CSVWriter<Place> csvWriter = builder.entryConverter(entryConverter).build();

        csvWriter.writeAll(places);
        csvWriter.flush();
        csvWriter.close();
    }
}
