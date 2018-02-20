package com.rxmuhammadyoussef.core.socialloginhelper.facebook;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.rxmuhammadyoussef.core.socialloginhelper.SocialLoginListener;
import com.rxmuhammadyoussef.core.util.Preconditions;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashSet;

public class FacebookLoginUtil {

    private final CallbackManager callbackManager = CallbackManager.Factory.create();
    private final SocialLoginListener socialLoginListener;
    private final ArrayList<String> readPermissions;

    FacebookLoginUtil(SocialLoginListener socialLoginListener, ArrayList<String> readPermissions) {
        this.socialLoginListener = socialLoginListener;
        this.readPermissions = readPermissions;
        registerCallBack(callbackManager, socialLoginListener);
    }

    private void registerCallBack(CallbackManager callbackManager, SocialLoginListener socialLoginListener) {
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), (jsonObject, response) -> {
                    try {
                        Handler handler = new Handler(Looper.getMainLooper());
                        new Thread() {
                            @Override
                            public void run() {
                                try {
                                    String id = jsonObject.getString("id");
                                    String firstName = jsonObject.getString("first_name");
                                    String lastName = jsonObject.getString("last_name");
                                    String email = null;
                                    if (loginResult.getRecentlyGrantedPermissions().contains("email")) {
                                        email = jsonObject.getString("email");
                                    }
                                    String finalEmail = email;
                                    handler.post(() -> socialLoginListener.onLoggedIn(id, firstName, lastName, finalEmail));
                                } catch (JSONException e) {
                                    socialLoginListener.onError(e);
                                }
                            }
                        }.start();
                    } catch (Exception e) {
                        socialLoginListener.onError(e);
                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,first_name,last_name,email");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                // This method is intentionally empty. Nothing special is needed here.
            }

            @Override
            public void onError(FacebookException error) {
                if (error instanceof FacebookAuthorizationException) {
                    if (AccessToken.getCurrentAccessToken() != null) {
                        LoginManager.getInstance().logOut();
                    }
                }
                socialLoginListener.onError(error);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void login(Activity activity) {
        LoginManager.getInstance().logInWithReadPermissions(Preconditions.requireNonNull(activity), readPermissions);
    }

    public void login(Fragment fragment) {
        LoginManager.getInstance().logInWithReadPermissions(Preconditions.requireNonNull(fragment), readPermissions);
    }

    public boolean isSessionActive() {
        return AccessToken.getCurrentAccessToken() != null;
    }

    public void logout() {
        LoginManager.getInstance().logOut();
        socialLoginListener.onLoggedOut();
    }

    public static class Builder {

        private final HashSet<String> readPermissions;
        private SocialLoginListener socialLoginListener;

        public Builder(Context context) {
            FacebookSdk.sdkInitialize(Preconditions.requireNonNull(context));
            readPermissions = new HashSet<>();
        }

        public Builder requestPublicProfile() {
            readPermissions.add("public_profile");
            return this;
        }

        public Builder requestEmail() {
            readPermissions.add("email");
            return this;
        }

        public Builder registerCallback(SocialLoginListener socialLoginListener) {
            this.socialLoginListener = socialLoginListener;
            return this;
        }

        public FacebookLoginUtil build() {
            return new FacebookLoginUtil(socialLoginListener, new ArrayList<>(readPermissions));
        }
    }
}
