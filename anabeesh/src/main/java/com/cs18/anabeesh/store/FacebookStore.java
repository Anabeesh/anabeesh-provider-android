package com.cs18.anabeesh.store;

import android.content.Context;

import com.cs18.anabeesh.di.activity.ForActivity;
import com.cs18.anabeesh.model.User;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 TODO: Add class header
 */

class FacebookStore {

    private final Context context;

    @Inject
    FacebookStore(@ForActivity Context context) {
        this.context = context;
    }

    Single<User> getUserInfo() {
        return Single.create(emitter -> {
            //TODO get user data from b /api
            //emitter.onSuccess(new User());
            emitter.onError(new Exception("Omar hacker man!"));
        });
    }
}
