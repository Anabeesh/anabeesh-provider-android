package com.rxmuhammadyoussef.core.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesUtil {

    private final static String PREFERENCES = "myPreferences";
    private final Context context;

    public PreferencesUtil(Context context) {
        Preconditions.checkNonNull(context, "should not pass null context reference");
        this.context = context;
    }

    public SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
    }

    /**
     this method used to save new boolean or update an existing one

     @param key   that will identifies the passed element
     @param value that needs to be persisted
     */
    public void saveOrUpdateBoolean(String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(Preconditions.requireStringNotEmpty(key), value);
        editor.apply();
    }

    /**
     this method used to retrieve a boolean value

     @param key that identifies the element

     @return the value or false if not found
     */
    public boolean getBoolean(String key) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
        return sp.getBoolean(Preconditions.requireStringNotEmpty(key), true);
    }

    /**
     this method used to save new long or update an existing one

     @param key   that will identifies the passed element
     @param value that needs to be persisted
     */
    public void saveOrUpdateLong(String key, long value) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(Preconditions.requireStringNotEmpty(key), value);
        editor.apply();
    }

    /**
     this method used to retrieve a long value

     @param key that identifies the element

     @return the value or -1 if not found
     */
    public long getLong(String key) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
        return sp.getLong(Preconditions.requireStringNotEmpty(key), -1);
    }

    /**
     this method used to save new int or update an existing one

     @param key   that will identifies the passed element
     @param value that needs to be persisted
     */
    public void saveOrUpdateInt(String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(Preconditions.requireStringNotEmpty(key), value);
        editor.apply();
    }

    /**
     this method used to retrieve aa int value

     @param key that identifies the element

     @return the value or -1 if not found
     */
    public int getInt(String key) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
        return sp.getInt(Preconditions.requireStringNotEmpty(key), 0);
    }

    /**
     this method used to save new string or update an existing one

     @param key   that will identifies the passed element
     @param value that needs to be persisted
     */
    public void saveOrUpdateString(String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Preconditions.requireStringNotEmpty(key), value);
        editor.apply();
    }

    /**
     this method used to retrieve a string value

     @param key that identifies the element

     @return the value or null if not found
     */
    public String getString(String key) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
        return sp.getString(Preconditions.requireStringNotEmpty(key), null);
    }

    /**
     this method used to delete specific element from the sharedPreferences

     @param key that identifies the element
     */
    public void delete(String key) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(Preconditions.requireStringNotEmpty(key));
        editor.apply();
    }

    /**
     this method used to delete all the elements from the sharedPreferences
     */
    public void deleteAll() {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }
}
