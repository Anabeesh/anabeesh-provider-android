package com.cs18.anabeesh.beshary.store.api;

public class ApiError extends Throwable {

    public ApiError(String message) {
        super(message);
    }

    public ApiError(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiError(Throwable cause) {
        super(cause);
    }

    public ApiError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
