package com.cs18.anabeesh.salem.Retrofit;

import com.cs18.anabeesh.salem.model.AllAnswers;
import com.cs18.anabeesh.salem.model.GetArticales;
import com.cs18.anabeesh.salem.model.GetPosts;
import com.cs18.anabeesh.salem.model.PostAnswers;
import com.cs18.anabeesh.salem.model.PostArticles;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 TODO: Add class header
 */

public interface UserService {

    @POST("api/articles")
    Call<ResponseBody> PostArticle(@Body PostArticles postArticles);

    @POST("api/answers")
    Call<ResponseBody> PostUserAnswer(@Body PostAnswers postAnswers);

    @GET("api/articles/{userId}/{page}/{pageSize}")
    Call<List<GetArticales>> getArticles(
            @Path("userId") String UserId,
            @Path("page") String Page,
            @Path("pageSize") String PageSize
    );

    @GET("api/homepage/newest/{userId}")
    Call<List<GetPosts>> getPosts(
            @Path("userId") String UserId
    );

    @GET("api/answers/GetByQuestionId/{questionId}")
    Call<List<AllAnswers>> getAllAnswers(@Path("questionId") String id);
}
