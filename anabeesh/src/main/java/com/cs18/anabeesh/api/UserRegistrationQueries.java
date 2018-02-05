package com.cs18.anabeesh.api;

import com.cs18.anabeesh.store.model.register.RegisterUserRequest;
import com.cs18.anabeesh.store.model.register.RegisterUserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 This interface holds all the queries needed to register with Anabeesh's API
 */

public interface UserRegistrationQueries {

    @POST("/api/register")
    Call<RegisterUserResponse> getUserRegistrationResponse (@Body RegisterUserRequest registerUserRequest);
}
