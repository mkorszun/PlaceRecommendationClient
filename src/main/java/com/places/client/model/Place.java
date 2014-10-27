package com.places.client.model;

public class Place {

    private int _id;

    private String name;

    private String type;

    private Position geo_position;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Position getGeo_position() {
        return geo_position;
    }

    public void setGeo_position(Position geo_position) {
        this.geo_position = geo_position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
