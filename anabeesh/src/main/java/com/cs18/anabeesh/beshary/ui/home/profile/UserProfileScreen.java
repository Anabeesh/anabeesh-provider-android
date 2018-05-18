package com.cs18.anabeesh.beshary.ui.home.profile;

public interface UserProfileScreen {
    void setUpEmailEditText();
    void setUpFirstNameEditText();
    void setUpLastNameEditText();
    void showLoadingAnimation();
    void hideLoadingAnimation();
    void showSuccessMessage(String message);
    void showErrorMessage(String message);
    void showCurrentUserInfo();
}
