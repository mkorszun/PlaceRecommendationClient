package com.places.client.formatter.csv;

import com.places.client.model.Place;
import com.places.client.model.Position;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CSVFormatterTest extends TestCase {

    @Test
    public void testFormat() {
        Position geoPosition = new Position(70.54, 60.71);
        Place place = new Place();

        place.setId(1234);
        place.setName("Berlin");
        place.setType("location");
        place.setGeoPosition(geoPosition);

        CSVFormatter formatter = new CSVFormatter();
        assertArrayEquals(new String[]{"1234", "Berlin", "location", "70.54", "60.71"}, formatter.convertEntry(place));
    }

    @Test
    public void testFormatNullPlaceAttributes() {
        Place place = new Place();
        place.setId(1234);

        CSVFormatter formatter = new CSVFormatter();
        assertArrayEquals(new String[]{"1234", "", "", "", ""}, formatter.convertEntry(place));
    }

    @Test
    public void testFormatNullPlace() {
        CSVFormatter formatter = new CSVFormatter();
        assertArrayEquals(new String[]{"", "", "", "", ""}, formatter.convertEntry(null));
    }
}
