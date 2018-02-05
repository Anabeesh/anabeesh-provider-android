package com.cs18.anabeesh.api;

import com.cs18.anabeesh.store.model.LogInUserResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 Singleton class for Retrofit network connection
 */

public class ApiClient {

    public static final String BASE_URL = "http://anabeesh1-001-site1.atempurl.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    /**
     This interface holds all the queries needed to login with Anabeesh's API
     */
    public interface UserLogInQueries {

        @POST("api/login")
        @FormUrlEncoded
        Call<LogInUserResponse> getUserLogInResponse (@Field("Email") String userEmail, @Field("Password") String userPassword);
    }


    /**
     This interface holds all the queries needed to register with Anabeesh's API
     */

//    public interface UserRegistrationQueries {
//        @POST("/api/register")
//        @FormUrlEncoded
//        Call<RegisterUserResponse> getUserRegistrationResponse(@Field("Email") String userEmail, @Field("Password") String userPassword,
//                                                               @Field("FirstName") String userFirstName, @Field("LastName") String userLastName);
//    }
}