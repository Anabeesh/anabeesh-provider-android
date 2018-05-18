package com.cs18.anabeesh.beshary.store.model.user;

import com.google.gson.annotations.SerializedName;

/**
 This class hold's the user Categories  following response.
 */


public class UserCategories {

    @SerializedName("Id")
    public String categoryId;
    @SerializedName("Name")
    public String categoryName;
    @SerializedName("IsFollowing")
    public String isFollowing;

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getState() {
        return isFollowing;
    }
}
