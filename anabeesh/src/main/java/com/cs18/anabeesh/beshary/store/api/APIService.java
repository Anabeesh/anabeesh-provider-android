package com.cs18.anabeesh.beshary.store.api;

import com.cs18.anabeesh.beshary.store.model.user.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("api/login")
    @FormUrlEncoded
    Call<User> login(
            @Field("Email") String email,
            @Field("Password") String password);

    @POST("api/Register")
    @FormUrlEncoded
    Call<User> register(
            @Field("Email") String email,
            @Field("Password") String password,
            @Field("FirstName") String firstName,
            @Field("LastName") String lastName);
}
