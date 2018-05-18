package com.cs18.anabeesh.beshary.ui.login;

public interface LoginScreen {

    void setupToolbar();

    void initializeComponents();

    void setupEmailEditText();
    void setupPasswordEditText();

    void showLoadingAnimation();
    void hideLoadingAnimation();

    void showSuccessMessage(String message);

    void showErrorMessage(String message);

    void showWarningMessage(String message);

    void onUserReadyToLogin();
}
