package com.cs18.anabeesh.salem.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 TODO: Add class header
 */

public class GetArticales implements Serializable {
    @SerializedName("Body")
    public String body;
    @SerializedName("CategoryId")
    public Integer categoryId;
    @SerializedName("Heading")
    public String heading;
    @SerializedName("Id")
    public Integer id;
    @SerializedName("UserId")
    public String userId;
    @SerializedName("UserName")
    public String UserName;
    @SerializedName("ImageUrl")
    public int ImageUrl;

    public GetArticales(String body, String heading, String userName, int imageUrl) {
        this.body = body;
        this.heading = heading;
        UserName = userName;
        ImageUrl = imageUrl;
    }

    GetArticales() {

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

    public int getImageUrl() {
        return ImageUrl;
    }
}
