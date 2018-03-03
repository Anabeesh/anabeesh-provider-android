package com.cs18.anabeesh.salem.Retrofit;

import com.cs18.anabeesh.salem.model.InteresetsApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 TODO: Add class header
 */

public interface UserServic {

    @GET("/api/Categories")
    Call<InteresetsApiResponse> getUserInterests();
}
