package com.places.client.formatter.csv;

import com.googlecode.jcsv.writer.CSVEntryConverter;
import com.places.client.model.Place;

public class CSVFormatter implements CSVEntryConverter<Place> {

    @Override
    public String[] convertEntry(Place place) {
        return new String[]{
                String.valueOf(place.get_id()),
                place.getName(),
                place.getType(),
                String.valueOf(place.getGeo_position().getLatitude()),
                String.valueOf(place.getGeo_position().getLongitude())
        };
    }
}
