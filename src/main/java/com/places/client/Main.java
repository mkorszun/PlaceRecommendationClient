package com.places.client;

import com.places.client.backend.API;
import com.places.client.backend.APIFactory;
import com.places.client.formatter.csv.CSVFileWriter;
import com.places.client.model.Place;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String... args) throws Exception {
        API api = APIFactory.build();
        List<Place> places = api.list("Berlin");
        new CSVFileWriter().write(new File("out.csv"), places);
    }
}
