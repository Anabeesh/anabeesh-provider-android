package com.cs18.anabeesh.salem.model;

import com.google.gson.annotations.SerializedName;

public class PostArticles {

    public Article article;

    @SerializedName("Body")
    public String body;
    @SerializedName("CategoryId")
    public Integer categoryId;
    @SerializedName("Headline")
    public String headline;
    @SerializedName("Id")
    public Integer id;
    @SerializedName("UserId")
    public String userId;

    public PostArticles(Article article, Integer categoryId, String userId) {
        this.categoryId = categoryId;
        this.userId = userId;
        this.article = article;

        headline = article.headline;
        body = article.body;
    }
}
