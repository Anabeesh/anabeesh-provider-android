package com.cs18.anabeesh.api;

import com.cs18.anabeesh.store.model.login.LogInUserRequest;
import com.cs18.anabeesh.store.model.login.LogInUserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 This interface holds all the queries needed to login with Anabeesh's API.
 */

public interface UserLogInQueries {

    @POST("api/login")
    Call<LogInUserResponse> getUserLogInResponse (@Body LogInUserRequest logInUserRequest);
}
