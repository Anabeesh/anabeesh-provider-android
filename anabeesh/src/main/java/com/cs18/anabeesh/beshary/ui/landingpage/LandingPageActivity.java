package com.cs18.anabeesh.beshary.ui.landingpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.beshary.ui.home.HomeActivity;
import com.cs18.anabeesh.beshary.ui.login.LoginActivity;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 This class represents the View layer of the landing page which handles all the UI interaction
 */

public class LandingPageActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (new AuthRepo(new PreferencesUtil(this)).getCurrentUser() != null) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
        setContentView(R.layout.activity_landing_page);
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
        
    }

    @OnClick(R.id.btn_sign_in)
    void loginByEmail() {
        startActivity(new Intent(this, LoginActivity.class));
    }

}
