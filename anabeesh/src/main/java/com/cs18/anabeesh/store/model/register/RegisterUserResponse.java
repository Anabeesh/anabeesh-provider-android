package com.cs18.anabeesh.store.model.register;

import com.google.gson.annotations.SerializedName;

/**
 This class hold  user registration response information
 */

public class RegisterUserResponse {

    @SerializedName("Email")
    public String userEmail;
    @SerializedName("UserId")
    public String userId;
    @SerializedName("FirstName")
    public String userFirstName;
    @SerializedName("LastName")
    public String userLastName;

    String getUserEmail() {
        return userEmail;
    }

    String getUserId() {
        return userId;
    }

    String getUserFirstName() {
        return userFirstName;
    }

    String getUserLastName() {
        return userLastName;
    }
}