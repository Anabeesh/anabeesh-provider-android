package com.cs18.anabeesh.ui.landingpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.cs18.anabeesh.AnabeeshApplication;
import com.cs18.anabeesh.R;
import com.cs18.anabeesh.di.activity.ActivityModule;
import com.cs18.anabeesh.di.activity.ActivityScope;
import com.cs18.anabeesh.ui.login.LoginActivity;
import com.cs18.anabeesh.ui.register.RegisterActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Collections;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 This class represents the View layer of the landing page which handles all the UI interaction
 */

@ActivityScope
public class LandingPageActivity extends Activity implements LandingPageScreen {

    @Inject
    LandingPagePresenter presenter;
    @BindView(R.id.btn_facebook)
    LoginButton loginButton;
    CallbackManager callbackManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Facebook
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        //
        setContentView(R.layout.activity_landing_page);
        AnabeeshApplication.getComponent(this)
                .plus(new ActivityModule(this))
                .inject(this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_facebook)
    void continueWithFacebook() {
         presenter.continueWithFacebook();

    }

    @OnClick(R.id.btn_google_plus)
    void continueWithGooglePlus() {
    }

    @OnClick(R.id.btn_sign_up)
    void signUpByEmail() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @OnClick(R.id.btn_sign_in)
    void loginByEmail() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
