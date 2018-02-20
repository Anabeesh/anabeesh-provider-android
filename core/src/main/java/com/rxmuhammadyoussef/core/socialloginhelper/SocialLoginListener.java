package com.rxmuhammadyoussef.core.socialloginhelper;

import android.support.annotation.Nullable;

public interface SocialLoginListener {

    void onLoggedIn(String id, String firstName, String lastName, @Nullable String email);

    void onLoggedOut();

    void onError(Throwable t);
}
