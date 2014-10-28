package com.places.client.formatter.csv;

import com.places.client.model.Place;
import com.places.client.model.Position;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CSVFormatterTest {

    @Test
    public void shouldReturnArrayWithAllPlaceAttributes() {
        Place place = new Place();

        place.setId(1234);
        place.setName("Berlin");
        place.setType("location");
        place.setGeoPosition(new Position(70.54, 60.71));

        CSVFormatter formatter = new CSVFormatter();
        assertArrayEquals(new String[]{"1234", "Berlin", "location", "70.54", "60.71"}, formatter.convertEntry(place));
    }

    @Test
    public void shouldReturnArrayWithEmptyStringsWhenPlaceNotComplete() {
        Place place = new Place();
        place.setId(1234);

        CSVFormatter formatter = new CSVFormatter();
        assertArrayEquals(new String[]{"1234", "", "", "", ""}, formatter.convertEntry(place));
    }

    @Test
    public void shouldReturnArrayWithEmptyStringsWhenPlaceNull() {
        CSVFormatter formatter = new CSVFormatter();
        assertArrayEquals(new String[]{"", "", "", "", ""}, formatter.convertEntry(null));
    }
}
