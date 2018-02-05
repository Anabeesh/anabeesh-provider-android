package com.cs18.anabeesh.ui.login;

import android.support.annotation.StringRes;

/**
 TODO: Add class header
 */

public interface LoginScreen {

    void setupToolbar();

    void showLoadingAnimation();

    void hideLoadingAnimation();

    void showMessage(String message);

    void showMessage(@StringRes int messageRes);

    void onUserReadyToLogin();
}
