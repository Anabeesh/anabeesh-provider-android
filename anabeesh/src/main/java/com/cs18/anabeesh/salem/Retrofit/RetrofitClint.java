package com.cs18.anabeesh.salem.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 TODO: Add class header
 */

public class RetrofitClint {
    private static final String BASE_URL = "http://anabeesh1-001-site1.atempurl.com";
    private static Retrofit Instance;

    public static Retrofit getInstance() {
        if (Instance == null) {
            Instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return Instance;
    }
}
