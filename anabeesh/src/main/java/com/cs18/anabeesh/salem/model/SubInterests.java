package com.cs18.anabeesh.salem.model;

import com.google.gson.annotations.SerializedName;

/**
 TODO: Add class header
 */

public class SubInterests {
    private final boolean isSelected = false;
    @SerializedName("Id")
    public String id;
    @SerializedName("Name")
    public String name;
    @SerializedName("MainCategoryId")
    public String mainCateforyId;
    public String SubImageUrl;

    public SubInterests() {

    }

    String getSubIntrastingId() {
        return id;
    }

    public String getSubIntrastingName() {
        return name;
    }

    public String getSubImageUrl() {
        return SubImageUrl;
    }

    String getMainCateforyId() {
        return mainCateforyId;
    }
}
