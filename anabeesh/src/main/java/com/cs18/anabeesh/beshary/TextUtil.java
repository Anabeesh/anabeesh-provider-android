package com.cs18.anabeesh.beshary;

import android.text.TextUtils;
import java.util.regex.Pattern;

/**
 This class holds all text manipulation needed .
 */

public class TextUtil {

    public static final int PASS_LENGTH = 6;
    public static final String USER_MAIL = "key_user_mail";
    public static final String USER_PASS = "key_user_pass";
    public static final String USER_ID = "key_user_id";
    public static final int SUCCESS = 200;
    public static final int FAILURE = 400;
    public static final String PAGE_SIZE = "10";
    public static final String PAGE = "0";


    public static boolean isValidEmail(String str) {
        String expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        str = str.trim();
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(str).matches();
    }

    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    public static boolean isValidName(String str) {
        String expression = "^[a-zA-Z\\u0621-\\u064A]{3,15}$";
        str = str.trim();
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        return  pattern.matcher(str).matches();
    }
}