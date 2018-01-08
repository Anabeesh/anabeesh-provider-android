package com.cs18.anabeesh.ui.landingpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cs18.anabeesh.AnabeeshApplication;
import com.cs18.anabeesh.R;
import com.cs18.anabeesh.di.activity.ActivityModule;
import com.cs18.anabeesh.di.activity.ActivityScope;
import com.cs18.anabeesh.ui.login.LoginActivity;
import com.cs18.anabeesh.ui.register.RegisterActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 This class represents the View layer of the landing page which handles all the UI interaction
 */

@ActivityScope
public class LandingPageActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        AnabeeshApplication.getComponent(this)
                .plus(new ActivityModule(this))
                .inject(this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_facebook)
    void continueWithFacebook() {
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
}
