package com.cs18.anabeesh.beshary.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import com.cs18.anabeesh.AnabeeshApplication;
import com.cs18.anabeesh.R;
import com.cs18.anabeesh.muhammad.di.activity.ActivityModule;
import com.cs18.anabeesh.muhammad.ui.home.HomeActivity;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;
import com.rxmuhammadyoussef.core.util.ResourcesUtil;
import com.rxmuhammadyoussef.core.util.UiUtil;
import com.rxmuhammadyoussef.core.widget.rxedittext.email.EmailEditText;
import com.rxmuhammadyoussef.core.widget.rxedittext.password.PasswordEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 This class represents the View layer of the login process which handles all the UI interaction
 */

public class LoginActivity extends Activity implements LoginScreen {

    @BindView(R.id.et_email)
    EmailEditText emailEditText;
    @BindView(R.id.et_password)
    PasswordEditText passwordEditText;
    @BindView(R.id.tv_email_description)
    TextView emailDescriptionTextView;
    @BindView(R.id.tv_password_description)
    TextView passwordDescriptionTextView;
    @BindView(R.id.btn_login)
    Button loginButton;

    private UiUtil uiUtil;
    private LoginPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnabeeshApplication.getComponent(this)
                .plus(new ActivityModule(this))
                .inject(this);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this, new PreferencesUtil(this), new ResourcesUtil(this));
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setupToolbar() {
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initializeComponents() {
        uiUtil = new UiUtil(this);
    }

    @Override
    public void setupEmailEditText() {
        emailEditText.setValidityListener(result -> {
            if (result.isValid()) {
                emailDescriptionTextView.setText("");
            } else {
                emailDescriptionTextView.setTextColor(getResources().getColor(R.color.colorError));
                emailDescriptionTextView.setText(R.string.incorrect_email);
            }
        });
    }

    @Override
    public void setupPasswordEditText() {
        passwordEditText.setValidityListener(result -> {
            if (!TextUtils.isEmpty(passwordEditText.getText().toString())) {
                passwordDescriptionTextView.setText("");
            } else {
                passwordDescriptionTextView.setTextColor(getResources().getColor(R.color.colorError));
                passwordDescriptionTextView.setText(R.string.incorrect_password);
            }
        });
    }

    @Override
    public void showLoadingAnimation() {
        uiUtil.getProgressDialog(getString(R.string.loading))
                .show();
    }

    @Override
    public void hideLoadingAnimation() {
        uiUtil.getProgressDialog()
                .dismiss();
    }

    @Override
    public void showSuccessMessage(String message) {
        uiUtil.getSuccessToast(message)
                .show();
    }

    @Override
    public void showErrorMessage(String message) {
        uiUtil.getErrorToast(message)
                .show();
    }

    @Override
    public void showWarningMessage(String message) {
        uiUtil.getWarningToast(message)
                .show();
    }

    @Override
    public void onUserReadyToLogin() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.btn_login)
    void login() {
        //TODO enable and disable button
        presenter.login(emailEditText.getText().toString(), passwordEditText.getText().toString());
    }

    @OnClick(R.id.tv_forgot_password)
    void forgotPassword() {
    }
}
