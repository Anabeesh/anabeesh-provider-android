package com.rxmuhammadyoussef.core.socialloginhelper.google;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.rxmuhammadyoussef.core.socialloginhelper.SocialLoginListener;

public class GoogleLoginUtil {
    private static final int REQUEST_CODE = 1001;
    private final SocialLoginListener socialMediaListener;
    private final GoogleSignInOptions googleSignInOptions;
    private final boolean shouldGetEmail;
    private GoogleSignInClient mGoogleSignInClient;

    GoogleLoginUtil(SocialLoginListener socialMediaListener, GoogleSignInOptions googleSignInOptions, boolean shouldGetEmail) {
        this.shouldGetEmail = shouldGetEmail;
        this.socialMediaListener = socialMediaListener;
        this.googleSignInOptions = googleSignInOptions;
    }

    public void login(Activity activity) {
        mGoogleSignInClient = GoogleSignIn.getClient(activity, googleSignInOptions);
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        activity.startActivityForResult(signInIntent, REQUEST_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount acct = task.getResult(ApiException.class);
                if (shouldGetEmail) {
                    socialMediaListener.onLoggedIn(acct.getId(), acct.getGivenName(), acct.getFamilyName(), acct.getEmail());
                } else {
                    socialMediaListener.onLoggedIn(acct.getId(), acct.getGivenName(), acct.getFamilyName(), null);
                }
            } catch (ApiException e) {
                socialMediaListener.onError(e);
            }
        }
    }

    public boolean isSessionActive(Context context) {
        return GoogleSignIn.getLastSignedInAccount(context) != null;
    }

    public void logout() {
        mGoogleSignInClient.signOut();
        socialMediaListener.onLoggedOut();
    }

    public static class Builder {

        private final GoogleSignInOptions.Builder googleSignInOptionsBuilder;
        private SocialLoginListener socialLoginListener;
        private boolean shouldGetEmail;

        public Builder() {
            googleSignInOptionsBuilder = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN);
        }

        public Builder registerCallback(SocialLoginListener socialLoginListener) {
            this.socialLoginListener = socialLoginListener;
            return this;
        }

        public Builder requestPublicProfile() {
            googleSignInOptionsBuilder.requestProfile();
            return this;
        }

        public Builder requestEmail() {
            shouldGetEmail = true;
            googleSignInOptionsBuilder.requestEmail();
            return this;
        }

        public GoogleLoginUtil build() {
            return new GoogleLoginUtil(socialLoginListener,
                    googleSignInOptionsBuilder.build(),
                    shouldGetEmail);
        }
    }
}
