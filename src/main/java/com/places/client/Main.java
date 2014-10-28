package com.places.client;

import com.places.client.backend.API;
import com.places.client.backend.APIFactory;
import com.places.client.formatter.csv.CSVFileWriter;
import com.places.client.model.Place;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String... args) throws Exception {
        if (args.length > 0 && !args[0].isEmpty()) {
            API api = APIFactory.build();
            List<Place> places = api.list(args[0]);
            new CSVFileWriter().write(new File("out.csv"), places);
        } else {
            System.out.println("Search phrase required");
        }
    }
}
