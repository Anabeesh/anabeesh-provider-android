package com.cs18.anabeesh.model;

import android.graphics.Bitmap;

/**
 TODO: Add class header
 */

public class User {
    private final String firstname;
    private final String lastname;
    private final String UserEmail;
    private final Bitmap UserImage;

    User(String firstname, String lastname, String userEmail, Bitmap userImage) {
        this.firstname = firstname;
        this.lastname = lastname;
        UserEmail = userEmail;
        UserImage = userImage;
    }
}
