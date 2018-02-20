package com.cs18.anabeesh.beshary.store.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIsUtil {

    //TODO add base url
    public static final String BASE_URL = "http://anabeesh1-001-site1.atempurl.com/";
    private static final String API_URL = "";

    private static Retrofit retrofit;

    public static APIService getAPIService() {
        return getClient().create(APIService.class);
    }

    private static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL.concat(API_URL))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
