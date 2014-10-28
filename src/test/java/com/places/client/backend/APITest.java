package com.places.client.backend;

import com.github.restdriver.clientdriver.ClientDriverRequest;
import com.github.restdriver.clientdriver.ClientDriverRule;
import com.google.gson.JsonObject;
import com.places.client.model.Place;
import org.json.simple.JSONArray;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static com.github.restdriver.clientdriver.RestClientDriver.giveResponse;
import static com.github.restdriver.clientdriver.RestClientDriver.onRequestTo;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class APITest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Rule
    public ClientDriverRule driver = new ClientDriverRule();

    @Test
    public void listShouldReturnSingleElement() throws APIException {
        JsonObject place = new JsonObject();
        place.addProperty("_id", 1234);
        place.addProperty("name", "Berlin");
        place.addProperty("type", "location");
        JsonObject position = new JsonObject();
        position.addProperty("latitude", 12.4567);
        position.addProperty("longitude", -61.49329);
        place.add("geo_position", position);

        String body = JSONArray.toJSONString(asList(place));
        setupDriver("/position/suggest/en/Berlin", body, 200, "application/json");

        API api = APIFactory.build(driver.getBaseUrl());
        List<Place> places = api.list("Berlin");

        assertEquals(1, places.size());
        assertEquals(1234, places.get(0).getId());
        assertEquals("Berlin", places.get(0).getName());
        assertEquals("location", places.get(0).getType());
        assertEquals(12.4567, places.get(0).getGeoPosition().getLatitude(), 0);
        assertEquals(-61.49329, places.get(0).getGeoPosition().getLongitude(), 0);
    }

    @Test
    public void listShouldReturnEmptyList() throws APIException {
        String body = JSONArray.toJSONString(asList());
        setupDriver("/position/suggest/en/Berlin", body, 200, "application/json");

        API api = APIFactory.build(driver.getBaseUrl());
        List<Place> places = api.list("Berlin");

        assertEquals(0, places.size());
    }


    @Test
    public void listShouldThrowAPIExceptionOn500() throws APIException {
        exception.expect(APIException.class);
        exception.expectMessage("API request failed");

        setupDriver("/position/suggest/en/Berlin", "Internal Error", 500, "application/json");
        APIFactory.build(driver.getBaseUrl()).list("Berlin");
    }

    private void setupDriver(String url, String body, int code, String contentType) {
        driver.addExpectation(
                onRequestTo(url).withMethod(ClientDriverRequest.Method.GET),
                giveResponse(body).withStatus(code).withContentType(contentType)
        );
    }
}
