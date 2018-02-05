package com.cs18.anabeesh.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.cs18.anabeesh.AnabeeshApplication;
import com.cs18.anabeesh.R;
import com.cs18.anabeesh.api.RetrofitApiClient;
import com.cs18.anabeesh.api.UserLogInQueries;
import com.cs18.anabeesh.di.activity.ActivityModule;
import com.cs18.anabeesh.di.activity.ActivityScope;
import com.cs18.anabeesh.store.model.login.LogInUserRequest;
import com.cs18.anabeesh.store.model.login.LogInUserResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 This class represents the View layer of the login process which handles all the UI interaction
 */

@ActivityScope
public class LoginActivity extends Activity {

    private LogInUserRequest logInUserRequest;
    private String userEmail;
    private String userPassword;

    @BindView(R.id.et_email)
    EditText emailEditText;

    @BindView(R.id.et_password)
    EditText passwordEditText;

    @BindView(R.id.btn_login)
    Button loginButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnabeeshApplication.getComponent(this)
                .plus(new ActivityModule(this))
                .inject(this);
        ButterKnife.bind(this);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btn_login)
    void login() {

        userEmail = emailEditText.getText().toString();
        userPassword = passwordEditText.getText().toString();

        if (userEmail.matches("")) {
            // TODO : Handling empty e-mail field .
        }
        else if (userPassword.matches("")) {
            // TODO : Handling empty password field .
        }
        else if (userPassword.matches("") && userEmail.matches("")) {
            // TODO : Handling empty e-mail and password field .
        }
        else {
            logInUserRequest = new LogInUserRequest();
            logInUserRequest.setUserEmail(userEmail);
            logInUserRequest.setUserPassword(userPassword);

            UserLogInQueries userLogInQueries =
                    RetrofitApiClient.getClient().create(UserLogInQueries.class);
            Call<LogInUserResponse> loggedInUserResponseCall =
                    userLogInQueries.getUserLogInResponse(logInUserRequest);

            loggedInUserResponseCall.enqueue(new Callback<LogInUserResponse>() {
                @Override
                public void onResponse(Call<LogInUserResponse> call, Response<LogInUserResponse> response) {
                    // valid user name and password
                    if (response.code() == 200) {
                        LogInUserResponse userResponseObject = response.body();
                        String userId = userResponseObject.getUserId();
                        // move user to home page :
                        navigateToHomePage();
                    }
                    else
                        // invalid user name or password
                        if (response.code() == 400) {
                        String errorMessage = response.message();
                        if (errorMessage.equals("Email Is not found")) {
                            //TODO : Handling invalid e-mail.
                        }  else {
                            //TODO : Handling invalid password
                        }
                    }
                }
                @Override
                public void onFailure(Call<LogInUserResponse> call, Throwable t) {
                    //TODO : Handling network failure
                }
            });
        }
    }

    @OnClick(R.id.tv_forgot_password)
    void forgotPassword() {
    }

    private void navigateToHomePage() {
     // TODO : This method should  move user to Anabeesh home page .
    }
}
