package com.cs18.anabeesh.beshary.store;

import com.cs18.anabeesh.beshary.store.model.user.User;
import com.google.gson.Gson;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;

/**
 TODO: Add class header
 */

class LocalStore {

    private static final String KEY_USER = "userKey";
    private final PreferencesUtil preferencesUtil;

    LocalStore(PreferencesUtil preferencesUtil) {this.preferencesUtil = preferencesUtil;}

    void saveUser(User user) {
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        preferencesUtil.saveOrUpdateString(KEY_USER, userJson);
    }

    User getCurrentUser() {
        Gson gson = new Gson();
        String userJson = preferencesUtil.getString(KEY_USER);
        return gson.fromJson(userJson, User.class);
    }
}
