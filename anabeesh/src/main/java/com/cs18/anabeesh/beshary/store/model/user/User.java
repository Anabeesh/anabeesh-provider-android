package com.cs18.anabeesh.beshary.store.model.user;

import com.google.gson.annotations.SerializedName;

/**
 This class hold's user logging response.
 */

public class User {
    @SerializedName("UserId")
    public String userId;
    @SerializedName("FirstName")
    public String userFirstName;
    @SerializedName("LastName")
    public String userLastName;
    @SerializedName("Email")
    public String userEmail;

    public String getUserId() {
        return userId;
    }

    String getUserFirstName() {
        return userFirstName;
    }

    String getUserLastName() {
        return userLastName;
    }

    String getUserEmail() {
        return userEmail;
    }
}
