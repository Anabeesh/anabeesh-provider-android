package com.cs18.anabeesh.Adapters;

/**
 TODO: Add class header
 */

public class DataItem {

    private final Integer img;
    private boolean isSelected = false;

    public DataItem(Integer img) {
        this.img = img;
    }

    Integer getImg() {
        return img;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
