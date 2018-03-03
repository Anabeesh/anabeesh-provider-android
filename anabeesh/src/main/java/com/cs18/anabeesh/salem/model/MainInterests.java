package com.cs18.anabeesh.salem.model;

import com.google.gson.annotations.SerializedName;

/**
 TODO: Add class header
 */

public class MainInterests {

    @SerializedName("Id")
    private String id;
    @SerializedName("Name")
    private String name;
    private String imageUrl;
    private boolean isSelected = false;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
