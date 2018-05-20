package com.cs18.anabeesh.salem.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Articles implements Serializable {

    @SerializedName("Body")
    public String body;
    @SerializedName("CategoryId")
    public int categoryId;
    @SerializedName("Heading")
    public String heading;
    @SerializedName("Id")
    public int id;
    @SerializedName("UserId")
    public String userId;
    @SerializedName("UserName")
    public String UserName;
    @SerializedName("ImageUrl")
    public String ImageUrl;

    public Articles(String body, String heading, String userName, String imageUrl) {
        this.body = body;
        this.heading = heading;
        UserName = userName;
        ImageUrl = imageUrl;
    }

    public String getBody() {
        return body;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getHeading() {
        return heading;
    }

    public Integer getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return UserName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }
}
