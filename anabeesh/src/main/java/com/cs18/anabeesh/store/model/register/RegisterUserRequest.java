package com.cs18.anabeesh.store.model.register;

/**
 This class holds user registration request information
 */

public class RegisterUserRequest {

    public String userEmail;
    public String userPassword;
    public String userFirstName;
    public String userLastName;

    void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    String getUserEmail() {
        return userEmail;
    }

    String getUserPassword() {
        return userPassword;
    }

    String getUserFirstName() {
        return userFirstName;
    }

    String getUserLastName() {
        return userLastName;
    }
}
