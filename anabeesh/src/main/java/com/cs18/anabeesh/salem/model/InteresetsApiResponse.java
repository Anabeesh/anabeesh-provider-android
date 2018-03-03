package com.cs18.anabeesh.salem.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class InteresetsApiResponse {

    @SerializedName("MainCategories")
    private final List<MainInterests> mainInterests;
    @SerializedName("SubCategories")
    private final List<SubInterests> subInterests;

    public InteresetsApiResponse(ArrayList<MainInterests> mainInterests, ArrayList<SubInterests> subInterests) {
        this.mainInterests = mainInterests;
        this.subInterests = subInterests;
    }

    public static InteresetsApiResponse createDefault() {
        return new InteresetsApiResponse(new ArrayList<>(), new ArrayList<>());
    }

    public List<MainInterests> getMainInterests() {
        return mainInterests;
    }

    public List<SubInterests> getSubInterests() {
        return subInterests;
    }
}
