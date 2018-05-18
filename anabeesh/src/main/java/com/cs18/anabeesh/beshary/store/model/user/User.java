package com.cs18.anabeesh.beshary.store.model.user;

import com.google.gson.annotations.SerializedName;

/**
 This class hold's user logging response.
 */

public class User {
    @SerializedName("UserId")
    public String userId;

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @SerializedName("FirstName")
    public String userFirstName;
    @SerializedName("LastName")
    public String userLastName;
    @SerializedName("Email")
    public String userEmail;

    public String getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
