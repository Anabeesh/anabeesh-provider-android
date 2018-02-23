package com.cs18.anabeesh.beshary;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 This class holds all text manipulation needed .
 */

public class TextUtil {

    public static final int PASS_LENGTH = 6;
    public static final String USER_MAIL = "key_user_mail";
    public static final String USER_PASS = "key_user_pass";

    public static boolean isValidEmail(String email) {
        String EXPRESSION = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(EXPRESSION, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }
}