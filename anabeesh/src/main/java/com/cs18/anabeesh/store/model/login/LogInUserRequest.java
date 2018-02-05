package com.cs18.anabeesh.store.model.login;

/**
 This class holds log in user request information
 */

public class LogInUserRequest {

    public String userEmail;
    public String userPassword;

    String getUserEmail() {
        return userEmail;
    }

    String getUserPassword() {
        return userPassword;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
