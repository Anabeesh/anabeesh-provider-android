package com.cs18.anabeesh.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.cs18.anabeesh.AnabeeshApplication;
import com.cs18.anabeesh.R;
import com.cs18.anabeesh.di.activity.ActivityModule;
import com.cs18.anabeesh.di.activity.ActivityScope;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 This class represents the View layer of the login process which handles all the UI interaction
 */

@ActivityScope
public class LoginActivity extends Activity implements LoginScreen{

    @BindView(R.id.pbLoading)
    ProgressBar progressBar;
    @BindView(R.id.et_email)
    EditText emailEditText;
    @BindView(R.id.et_password)
    EditText passwordEditText;
    @BindView(R.id.btn_login)
    Button loginButton;

    private LoginPresenter loginPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnabeeshApplication.getComponent(this)
                .plus(new ActivityModule(this))
                .inject(this);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
        loginPresenter.onCreate();
    }

    @Override
    public void setupToolbar() {
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void showLoadingAnimation() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideLoadingAnimation() {
        progressBar.setVisibility(ProgressBar.GONE);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int messageRes) {

    }

    @Override
    public void onUserReadyToLogin() {
        navigateToHomePage();
    }

    @OnClick(R.id.btn_login)
    void login() {

    }

    @OnClick(R.id.tv_forgot_password)
    void forgotPassword() {
    }

    private void navigateToHomePage() {
        // TODO : This method should  move user to Anabeesh home page .
    }
}
