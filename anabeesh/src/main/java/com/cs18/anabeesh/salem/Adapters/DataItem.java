package com.cs18.anabeesh.salem.Adapters;

import android.support.annotation.DrawableRes;

/**
 TODO: Add class header
 */

public class DataItem {

    @DrawableRes
    private final int img;
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
