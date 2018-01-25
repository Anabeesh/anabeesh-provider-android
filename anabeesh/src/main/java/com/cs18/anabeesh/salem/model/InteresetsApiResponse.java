package com.cs18.anabeesh.salem.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class InteresetsApiResponse {

    @SerializedName("MainCategories")
    private ArrayList<MainInteresting> mainInterestings;

    @SerializedName("SubCategories")
    private ArrayList<SubIntrasting> subIntrastings;

    public ArrayList<MainInteresting> getMainInterestings() {
        return mainInterestings;
    }

    public ArrayList<SubIntrasting> getSubIntrastings() {
        return subIntrastings;
    }
}
