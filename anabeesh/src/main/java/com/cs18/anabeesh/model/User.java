package com.cs18.anabeesh.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 TODO: Add class header
 */

public class User {
    private final JSONObject object;
    private String Firstname;
    private String Lastname;
    private String useremail;
    private String Birthday;
    private String UserImage;
    private String gender;

    public User(JSONObject object) {

        this.object = object;
    }

    public void SendtoIntrastingScreen(JSONObject object) {
        try {
            useremail = object.getString("email");
            gender = object.getString("gender");
            Firstname = object.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

