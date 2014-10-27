package com.places.client.backend;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class APIFactory {

    private static final String URL = "http://apiii.goeuro.com/api/v2";

    private static final ErrorHandler ERROR_HANDLER = new ErrorHandler() {
        @Override
        public Throwable handleError(RetrofitError retrofitError) {
            return new APIException(retrofitError);
        }
    };

    public static API build() {
        return build(URL);
    }

    public static API build(String url) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setErrorHandler(ERROR_HANDLER)
                .setEndpoint(url)
                .build();
        return restAdapter.create(API.class);
    }
}
