package com.cs18.anabeesh.util

import android.text.TextUtils
import java.util.regex.Pattern
import javax.inject.Inject

class TextUtil @Inject constructor() {

    /**
     * this method is used to check if the passed text is empty or null.
     *
     * @param text
     * @return true if text is null or zero length
     */
    fun isEmpty(text: String): Boolean = TextUtils.isEmpty(text)

    /**
     * this method is used to check if the passed text is a valid email id format
     *
     * @param text
     * @return true if valid format
     */
    fun isValidEmail(text: String): Boolean {
        val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(text)
        return matcher.matches()
    }

    /**
     * this method is used to check if the passed text is a valid password format
     *
     * @param text
     * @return true if valid format
     */
    fun isValidPassword(text: String): Boolean {
        val expression = ".{8,}"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(text)
        return matcher.matches()
    }
}