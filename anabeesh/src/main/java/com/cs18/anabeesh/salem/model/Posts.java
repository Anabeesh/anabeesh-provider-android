package com.cs18.anabeesh.salem.model;
import com.google.gson.annotations.SerializedName;

public class Posts {
    @SerializedName("id")
    public String id;
    @SerializedName("Headline")
    public String Headline;
    @SerializedName("Description")
    public String Description;
    @SerializedName("UserId")
    public String UserId;
    @SerializedName("MainCategoryId")
    public String MainCategoryId;
    @SerializedName("SubCategoryId")
    public String SubCategoryId;

    public Posts(String headline, String description) {
        Headline = headline;
        Description = description;
    }

    public String getHeadline() {
        return Headline;
    }

    public String getDescription() {
        return Description;
    }

    public String getUserId() {
        return UserId;
    }

    public String getMainCategoryId() {
        return MainCategoryId;
    }

    public String getSubCategoryId() {
        return SubCategoryId;
    }

    public String getpostId() {
        return id;
    }
}