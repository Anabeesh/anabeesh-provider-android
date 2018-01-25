package com.cs18.anabeesh.ui.register;

import com.cs18.anabeesh.di.activity.ActivityScope;

import javax.inject.Inject;

/**
 TODO: Add class header
 */

@ActivityScope
class RegisterPresenter {

    private final RegisterScreen registerScreen;

    @Inject
    RegisterPresenter(RegisterScreen registerScreen) {
        this.registerScreen = registerScreen;
    }

    void onCreate() {
        registerScreen.setupToolbar();
        registerScreen.setFragment(new EmailPasswordFragment());
    }
}
