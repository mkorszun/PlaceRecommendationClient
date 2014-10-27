package com.places.client.model;

public class Place {

    private int _id;

    private String name;

    private String type;

    private Position geo_position;

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Position getGeoPosition() {
        return geo_position;
    }

    public void setGeoPosition(Position geoPosition) {
        this.geo_position = geoPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
