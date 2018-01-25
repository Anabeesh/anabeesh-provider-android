package com.cs18.anabeesh.muhammad.ui.home;

import com.cs18.anabeesh.muhammad.di.activity.ActivityScope;

import javax.inject.Inject;

/**
 This class represents the presenter layer of the home page which handles all the logic
 */

@ActivityScope
class HomePresenter {

    private final HomeScreen homeScreen;

    @Inject
    HomePresenter(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }

    void onCreate() {
        homeScreen.setupToolbar();
        homeScreen.setupRefreshListener();
        homeScreen.setupRecyclerView();
    }

    void refreshHome() {
        homeScreen.showRefreshingAnimation();
    }

    void loadMoreQuestions() {
        homeScreen.showLoadingMoreQuestionsAnimation();
    }
}
