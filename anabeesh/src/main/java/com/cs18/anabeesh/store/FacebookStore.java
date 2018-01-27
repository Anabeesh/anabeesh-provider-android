package com.cs18.anabeesh.store;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.cs18.anabeesh.di.activity.ForActivity;
import com.cs18.anabeesh.model.User;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Collections;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;

/**
 TODO: Add class header
 */

class FacebookStore {

    private final Context context;

    private LoginButton loginButton;//TODO reference  for  this 
    private CallbackManager callbackManager;

    @Inject
    FacebookStore(@ForActivity Context context) {
        this.context = context;
    }

    Single<User> getUserInfo() {
        return Single.create((SingleEmitter<User> emitter) -> {
            //TODO get user data from b /api
            loginButton.setReadPermissions(Collections.singletonList("public_profile, email, user_birthday"));
            callbackManager = CallbackManager.Factory.create();
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    GraphRequest request = GraphRequest.newMeRequest(
                            loginResult.getAccessToken(),
                            (object, response) -> {
                                Log.v("Main", response.toString());
                                //setProfileToView(object);
                                emitter.onSuccess(new User(object));
                            });
                    Bundle parameters = new Bundle();
                    parameters.putString("fields", "id,name,email,gender, birthday");
                    request.setParameters(parameters);
                    request.executeAsync();
                }

                @Override
                public void onCancel() {

                }

                @Override
                public void onError(FacebookException error) {
                    emitter.onError(new Exception("Omar hacker man!"));
                }
            });
            //emitter.onSuccess(new User(object));
            //emitter.onError(new Exception("Omar hacker man!"));
        });
    }
}
