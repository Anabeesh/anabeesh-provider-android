package com.cs18.anabeesh.salem.model;

import com.google.gson.annotations.SerializedName;

/**
 TODO: Add class header
 */

public class SubIntrasting {
    @SerializedName("Id")
    public String id;
    @SerializedName("Name")
    public String name;
    @SerializedName("MainCategoryId")
    public String mainCateforyId;
    private boolean isSelected = false;

    public SubIntrasting() {

    }

    String getSubIntrastingId() {
        return id;
    }

    String getSubIntrastingName() {
        return name;
    }

    String getMainCateforyId() {
        return mainCateforyId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
