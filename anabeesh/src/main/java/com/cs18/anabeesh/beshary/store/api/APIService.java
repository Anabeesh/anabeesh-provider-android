package com.cs18.anabeesh.beshary.store.api;

import com.cs18.anabeesh.beshary.store.model.user.User;
import com.cs18.anabeesh.beshary.store.model.user.UserCategories;
import com.cs18.anabeesh.salem.model.AllAnswers;
import com.cs18.anabeesh.salem.model.Articles;
import com.cs18.anabeesh.salem.model.PostAnswers;
import com.cs18.anabeesh.salem.model.PostArticles;
import com.cs18.anabeesh.salem.model.Posts;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {

    @POST("api/login")
    @FormUrlEncoded
    Call<User> login(
            @Field("Email") String email,
            @Field("Password") String password);

    @GET("Api/Categories/{userId}")
    Call<ArrayList<UserCategories>> getCategories (@Path("userId") String userId);

    @GET("api/Follow/FollowCategory/{userId}/{categoryId}")
    Call<ResponseBody> followCategory(@Path("userId")String userId, @Path("categoryId") String categoryId);

    @GET("api/Follow//UnfollowCategory/{userId}/{categoryId}")
    Call<ResponseBody> unFollowCategory(@Path("userId")String userId, @Path("categoryId") String categoryId);

    @POST("Api/profile")
    @FormUrlEncoded
    Call<ResponseBody> updateUserProfile(@Field("Id")String userId,@Field("Email")String userEmail,@Field("FirstName")String FirstName,@Field("LastName") String LastName);

    @POST("api/articles")
    Call<ResponseBody> PostArticle(@Body PostArticles postArticles);

    @POST("api/answers")
    Call<ResponseBody> PostUserAnswer(@Body PostAnswers postAnswers);

    @GET("api/articles/{userId}/{page}/{pageSize}")
    Call<List<Articles>> getArticles(
            @Path("userId") String UserId,
            @Path("page") String Page,
            @Path("pageSize") String PageSize
    );

    @GET("api/homepage/newest/{userId}")
    Call<List<Posts>> getPosts(
            @Path("userId") String UserId
    );

    @GET("api/answers/GetByQuestionId/{questionId}")
    Call<List<AllAnswers>> getAllAnswers(@Path("questionId") String id);
}