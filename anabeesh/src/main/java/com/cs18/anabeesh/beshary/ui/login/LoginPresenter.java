package com.cs18.anabeesh.beshary.ui.login;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.beshary.store.AuthListener;
import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.beshary.store.api.ApiError;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;
import com.rxmuhammadyoussef.core.util.ResourcesUtil;

class LoginPresenter {

    private final AuthRepo authRepo;
    private final LoginScreen loginScreen;
    private final ResourcesUtil resourcesUtil;

    LoginPresenter(LoginScreen loginScreen, PreferencesUtil preferencesUtil, ResourcesUtil resourcesUtil) {
        this.loginScreen = loginScreen;
        authRepo = new AuthRepo(preferencesUtil);
        this.resourcesUtil = resourcesUtil;
    }

    void onCreate() {
        loginScreen.setupToolbar();
        loginScreen.initializeComponents();
        loginScreen.setupEmailEditText();
        loginScreen.setupPasswordEditText();
    }

    void login(String userEmail, String userPassword) {
        loginScreen.showLoadingAnimation();
        authRepo.login(userEmail, userPassword, new AuthListener() {
            @Override
            public void onSuccess() {
                loginScreen.hideLoadingAnimation();
                loginScreen.showSuccessMessage(resourcesUtil.getString(R.string.done));
                loginScreen.onUserReadyToLogin();
            }

            @Override
            public void onFail(Throwable throwable) {
                loginScreen.hideLoadingAnimation();
                if (throwable instanceof ApiError) {
                    loginScreen.showErrorMessage(throwable.getMessage());
                } else {
                    loginScreen.showErrorMessage(resourcesUtil.getString(R.string.network_error));
                }
            }
        });
    }

    void onDestroy() {
    }
}
