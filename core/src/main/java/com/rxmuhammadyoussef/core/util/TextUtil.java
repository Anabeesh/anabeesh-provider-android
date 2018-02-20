package com.rxmuhammadyoussef.core.util;

import android.content.Context;
import android.text.TextUtils;

import com.rxmuhammadyoussef.core.R;

import java.util.regex.Pattern;

public class TextUtil {

    private final Context context;

    public TextUtil(Context context) {
        Preconditions.checkNonNull(context, "should not pass null context reference");
        this.context = context;
    }

    /**
     Returns true if the string is null or 0-length.

     @param text the string to be examined

     @return true if str is null or zero length
     */
    public boolean isEmpty(String text) {
        return TextUtils.isEmpty(text);
    }

    /**
     Returns true if the string matches a human name format

     @param name the string to be examined

     @return true if name consists of at least three alphabetic characters with no white space
     see https://stackoverflow.com/a/3802238/7330512
     */
    public boolean isValidName(String name) {
        Preconditions.checkNonNull(name);

        String expression = "^[a-z0-9_-]{3,15}$";
        //        String expression = "^[\\u0600-\\u065F\\u066A-\\u06EF\\u06FA-\\u06FFa-zA-Z]+[\\u0600-\\u065F\\u066A-\\u06EF\\u06FA-\\u06FFa-zA-Z-_]*$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(name).matches();
    }

    /**
     @param email the string to be examined

     @return true if email is valid
     see https://stackoverflow.com/a/3802238/7330512
     */
    public boolean isValidEmail(String email) {
        Preconditions.checkNonNull(email);

        String expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).matches();
    }

    /**
     @param password the string to be examined

     @return true if password consists of at at least 6 chars the contains at least 1 number, 1 small letter and 1 capital letter
     see https://stackoverflow.com/a/3802238/7330512
     */
    public boolean isValidPassword(String password) {
        Preconditions.checkNonNull(password);

        String expression = "^(?=.*[0-9])(?=.*[A-Z]).{6,}$";
        Pattern pattern = Pattern.compile(expression);
        return pattern.matcher(password).matches();
    }

    /**
     @param number the string to be examined

     @return true if valid phone number
     see https://howtodoinjava.com/regex/java-regex-validate-international-phone-numbers/
     */
    public boolean isValidPhoneNumber(String number) {
        Preconditions.checkNonNull(number);

        String expression = "^\\+(?:[0-9]?){6,14}[0-9]$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(number).matches();
    }

    /**
     @param text the string to be examined

     Returns Result object containing boolean variable isValid, message and localized message
     */
    public Result checkIfEmpty(String text) {
        Result result = new Result();
        if (TextUtils.isEmpty(text)) {
            result.valid = false;
            //TODO add message
            result.message = "";
            result.localizedMessage = context.getString(R.string.empty);
        } else {
            result.valid = true;
            result.message = "";
            result.localizedMessage = "";
        }
        return result;
    }

    /**
     @param name the string to be examined

     Returns Result object containing boolean variable isValid, message and localized message
     */
    public Result checkIfValidName(String name) {
        Preconditions.checkNonNull(name);

        Result result = new Result();
        String expression = "^([\\p{L}\\s'.-]).{3,}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        if (!pattern.matcher(name).matches()) {
            result.valid = false;
            //TODO add message
            result.message = "";
            result.localizedMessage = context.getString(R.string.not_valid_name);
        } else {
            result.valid = true;
            result.message = "";
            result.localizedMessage = "";
        }
        return result;
    }

    /**
     @param email the string to be examined

     Returns Result object containing boolean variable isValid, message and localized message
     */
    public Result checkIfValidEmail(String email) {
        Preconditions.checkNonNull(email);
        Result result = new Result();
        String expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        if (!pattern.matcher(email).matches()) {
            result.valid = false;
            //TODO add message
            result.message = "";
            result.localizedMessage = context.getString(R.string.not_valid_email);
        } else {
            result.valid = true;
            result.message = "";
            result.localizedMessage = "";
        }
        return result;
    }

    /**
     @param password the string to be examined

     Returns Result object containing boolean variable isValid, message and localized message
     */
    public Result checkIfValidPassword(String password) {
        Preconditions.checkNonNull(password);

        Result result = new Result();
        String expression = "^(?=.*[0-9])(?=.*[A-Z]).{6,}$";
        Pattern pattern = Pattern.compile(expression);
        if (!pattern.matcher(password).matches()) {
            result.valid = false;
            //TODO add message
            result.message = "";
            result.localizedMessage = context.getString(R.string.not_valid_password);
        } else {
            result.valid = true;
            result.message = "";
            result.localizedMessage = "";
        }
        return result;
    }

    /**
     @param number the string to be examined

     Returns Result object containing boolean variable isValid, message and localized message
     */
    public Result checkIfValidPhoneNumber(String number) {
        Preconditions.checkNonNull(number);

        Result result = new Result();
        String expression = "^\\+(?:[0-9]?){6,14}[0-9]$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        if (!pattern.matcher(number).matches()) {
            result.valid = false;
            //TODO add message
            result.message = "";
            result.localizedMessage = context.getString(R.string.not_valid_phone_number);
        } else {
            result.valid = true;
            result.message = "";
            result.localizedMessage = "";
        }
        return result;
    }

    public final class Result {
        boolean valid;
        String message;
        String localizedMessage;

        Result() {
            // This constructor is intentionally empty. Nothing special is needed here.
        }

        public boolean isValid() {
            return valid;
        }

        public String getMessage() {
            return message;
        }

        public String getLocalizedMessage() {
            return localizedMessage;
        }
    }
}
