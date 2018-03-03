package com.cs18.anabeesh.salem.ui.interestes;

import com.cs18.anabeesh.salem.model.InteresetsApiResponse;

/**
 TODO: Add class header
 */

public interface InterestsScreen {

    void setupToolbar();

    void setupRecyclerView();

    void ShowError(Throwable throwable);

    void updateUi(InteresetsApiResponse interesetsApiResponse);

    void setupSwipLayout();
}
