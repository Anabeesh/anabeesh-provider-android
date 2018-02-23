package com.cs18.anabeesh.beshary.store;

import com.cs18.anabeesh.beshary.store.model.user.User;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;

public class AuthRepo {

    private final CloudStore cloudStore;
    private final LocalStore localStore;

    public AuthRepo(PreferencesUtil preferencesUtil) {
        cloudStore = new CloudStore();
        localStore = new LocalStore(preferencesUtil);
    }

    public void login(String email, String password, AuthListener authListener) {
        cloudStore.login(email, password, new AuthApiCallback() {
            @Override
            public void onSuccess(User user) {
                localStore.saveUser(user);
                authListener.onSuccess();
            }

            @Override
            public void onFail(Throwable t) {
                authListener.onFail(t);
            }
        });
    }

    public User getCurrentUser() {
        return localStore.getCurrentUser();
    }
}
