package com.cs18.anabeesh.salem.ui.interestes;

import com.cs18.anabeesh.salem.model.MainInteresting;

import java.util.List;

/**
 TODO: Add class header
 */

public interface InterestsScreen {

    void setupToolbar();

    void setupRecyclerView();

    void ShowError(String error);

    void ShowError(Throwable throwable);

    void updateUi(List<MainInteresting> mainInterestings);
}
