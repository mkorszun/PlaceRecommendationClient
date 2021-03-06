package com.places.client.formatter.csv;

import com.googlecode.jcsv.writer.CSVEntryConverter;
import com.places.client.model.Place;

class CSVFormatter implements CSVEntryConverter<Place> {

    @Override
    public String[] convertEntry(final Place place) {

        String id = new CSVFieldFormatter() {
            public Object toField() {
                return place.getId();
            }
        }.format();

        String name = new CSVFieldFormatter() {
            public Object toField() {
                return place.getName();
            }
        }.format();

        String type = new CSVFieldFormatter() {
            public Object toField() {
                return place.getType();
            }
        }.format();

        String lat = new CSVFieldFormatter() {
            public Object toField() {
                return place.getGeoPosition().getLatitude();
            }
        }.format();

        String lon = new CSVFieldFormatter() {
            public Object toField() {
                return place.getGeoPosition().getLongitude();
            }
        }.format();

        return new String[]{id, name, type, lat, lon};
    }

    abstract class CSVFieldFormatter {

        public static final String EMPTY_FIELD = "";

        public abstract Object toField();

        public String format() {
            try {
                Object obj = toField();
                if (obj != null) {
                    return String.valueOf(obj);
                } else {
                    return EMPTY_FIELD;
                }
            } catch (Exception e) {
                return EMPTY_FIELD;
            }
        }
    }
}
