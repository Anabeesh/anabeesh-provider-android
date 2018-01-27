package com.cs18.anabeesh.ui.landingpage;

import com.cs18.anabeesh.di.activity.ActivityScope;
import com.cs18.anabeesh.schedulers.ComputationalThread;
import com.cs18.anabeesh.schedulers.ThreadSchedulers;
import com.cs18.anabeesh.store.LandingPageRepo;

import javax.inject.Inject;

/**
 TODO: Add class header
 */

@ActivityScope
class LandingPagePresenter {

    private final ThreadSchedulers threadSchedulers;
    private final LandingPageScreen landingPageScreen;
    private final LandingPageRepo repo;

    @Inject
    LandingPagePresenter(@ComputationalThread ThreadSchedulers threadSchedulers,
                         LandingPageScreen landingPageScreen,
                         LandingPageRepo repo) {
        this.threadSchedulers = threadSchedulers;
        this.landingPageScreen = landingPageScreen;
        this.repo = repo;
    }

    void continueWithFacebook() {
        repo.loginByFacebook()
                .subscribeOn(threadSchedulers.subscribeOn())
                .observeOn(threadSchedulers.observeOn())
                .subscribe(user -> {
                    //TODO: Handle user data
                }, throwable -> {
                    String message = throwable.getMessage();
                    landingPageScreen.showErrorMessage(message);
                    //TODO: show error message
                });
    }
}
