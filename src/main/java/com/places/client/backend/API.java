package com.places.client.backend;

import com.places.client.model.Place;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

public interface API {

    @GET("/position/suggest/en/{phrase}")
    List<Place> list(@Path("phrase") String phrase) throws APIException;

    @GET("/position/suggest/{language}/{phrase}")
    List<Place> list(@Path("language") String language, @Path("phrase") String phrase) throws APIException;
}
