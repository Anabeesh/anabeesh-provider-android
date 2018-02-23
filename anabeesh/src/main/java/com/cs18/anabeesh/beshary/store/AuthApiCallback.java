package com.cs18.anabeesh.beshary.store;

import com.cs18.anabeesh.beshary.store.model.user.User;

public interface AuthApiCallback {

    void onSuccess(User body);

    void onFail(Throwable t);
}
