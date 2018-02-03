package com.cs18.anabeesh.store;

import com.cs18.anabeesh.model.User;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 TODO: Add class header
 */

public class LandingPageRepo {

    private final FacebookStore facebookStore;

    @Inject
    LandingPageRepo(FacebookStore facebookStore) {
        this.facebookStore = facebookStore;
    }

    public Single<User> loginByFacebook() {
        return facebookStore.getUserInfo();
    }
}
