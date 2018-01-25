package com.cs18.anabeesh.muhammad.ui.home;

import com.cs18.anabeesh.muhammad.di.activity.ActivityScope;

/**
 this class represents how the home page view layer should behave
 */

@ActivityScope
public interface HomeScreen {

    void setupToolbar();

    void setupRefreshListener();

    void setupRecyclerView();

    void showRefreshingAnimation();

    void showLoadingMoreQuestionsAnimation();

    void hideLoadingAnimation();

    void updateUi();
}
