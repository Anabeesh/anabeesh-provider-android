package com.cs18.anabeesh.store.model.login;

import com.google.gson.annotations.SerializedName;

/**
 This class hold's user logging response.
 */

public class LogInUserResponse {
    @SerializedName("UserId")
    public String userId;

    public String getUserId() {
        return userId;
    }
}
