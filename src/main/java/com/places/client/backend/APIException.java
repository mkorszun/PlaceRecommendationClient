package com.places.client.backend;

public class APIException extends Exception {

    public APIException(Throwable t) {
        super("API request failed", t);
    }
}
