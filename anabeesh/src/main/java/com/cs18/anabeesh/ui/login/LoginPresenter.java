package com.cs18.anabeesh.ui.login;

import com.cs18.anabeesh.TextUtil;
import com.cs18.anabeesh.store.UserStore;
import com.cs18.anabeesh.store.model.LogInUserResponse;

/**
 TODO: Add class header
 */

class LoginPresenter {

    private final LoginScreen loginScreen;
    private final UserStore userStore;

    LoginPresenter(LoginScreen loginScreen){
        this.loginScreen = loginScreen;
        this.userStore = new UserStore();
    }

    void onCreate() {
        loginScreen.setupToolbar();
    }

    void login( String userEmail,String userPassword ){

        if (TextUtil.isEmpty(userEmail)) {
           loginScreen.showMessage("Empty Email");
        } else if (TextUtil.isEmpty(userPassword)) {
            loginScreen.showMessage("Empty password");
        }else if (!TextUtil.isValidEmail(userEmail)) {
          loginScreen.showMessage("Invalid email");
        } else {
            loginScreen.showLoadingAnimation();
            userStore.login(userEmail, userPassword, new UserStore.AuthListener() {
                @Override
                public void onSuccess(LogInUserResponse body) {

                }

                @Override
                public void onFail(Throwable throwable) {
                }
            });
        }
    }

    void forgotPassword(){

    }
}
