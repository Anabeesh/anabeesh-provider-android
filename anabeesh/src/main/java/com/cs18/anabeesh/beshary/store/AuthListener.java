package com.cs18.anabeesh.beshary.store;

public interface AuthListener {
    void onSuccess();

    void onFail(Throwable throwable);
}
