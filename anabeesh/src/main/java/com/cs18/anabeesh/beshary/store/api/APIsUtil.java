package com.cs18.anabeesh.beshary.store.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIsUtil {


    public static final String BASE_URL = "http://anabeesh2-001-site1.itempurl.com/";
    private static final String API_URL = "";

    private static Retrofit retrofit;

    public static APIService getAPIService() {
        return getClient().create(APIService.class);
    }

    private static Retrofit getClient() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL.concat(API_URL))
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.newThread()))
                    .build();
        }
        return retrofit;
    }
}
