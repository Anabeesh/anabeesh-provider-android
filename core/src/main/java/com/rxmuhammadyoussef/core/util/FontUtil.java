package com.rxmuhammadyoussef.core.util;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;

import java.lang.reflect.Field;

/**
 This utility class is  used to override default fonts provided by Android (i.e. MONOSPACE)
 */

public final class FontUtil {

    private FontUtil() {
    }

    /**
     This method overrides the default MONO_SPACE font, typically known as "monospace" in resources files
     Using reflection to override default typeface
     NOTICE: DO NOT FORGET TO SET TYPEFACE FOR APP THEME AS DEFAULT TYPEFACE WHICH WILL BE OVERRIDDEN

     @param assets {@link AssetManager} to work with assets
     @param path   for file name of the font from assets
     */
    public static void overrideDefaultMonoSpaceFont(AssetManager assets, String path) {
        Typeface typeface = Typeface.createFromAsset(
                Preconditions.requireNonNull(assets),
                Preconditions.requireNonNull(path));
        try {
            Field staticField = Typeface.class.getDeclaredField("MONOSPACE");
            staticField.setAccessible(true);
            staticField.set(null, typeface);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Log.getStackTraceString(e);
        }
    }

    /**
     This method overrides the default SANS_SERIF font, typically known as "sans-serif" in resources files
     Using reflection to override default typeface
     NOTICE: DO NOT FORGET TO SET TYPEFACE FOR APP THEME AS DEFAULT TYPEFACE WHICH WILL BE OVERRIDDEN

     @param assets {@link AssetManager} to work with assets
     @param path   for file name of the font from assets
     */
    public static void overrideDefaultSansSerifFont(AssetManager assets, String path) {
        Typeface typeface = Typeface.createFromAsset(
                Preconditions.requireNonNull(assets),
                Preconditions.requireNonNull(path));
        try {
            Field staticField = Typeface.class.getDeclaredField("SANS_SERIF");
            staticField.setAccessible(true);
            staticField.set(null, typeface);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Log.getStackTraceString(e);
        }
    }

    /**
     This method overrides the default SERIF font, typically known as "serif" in resources files
     Using reflection to override default typeface
     NOTICE: DO NOT FORGET TO SET TYPEFACE FOR APP THEME AS DEFAULT TYPEFACE WHICH WILL BE OVERRIDDEN

     @param assets {@link AssetManager} to work with assets
     @param path   for file name of the font from assets
     */
    public static void overrideDefaultSerfFont(AssetManager assets, String path) {
        Typeface typeface = Typeface.createFromAsset(
                Preconditions.requireNonNull(assets),
                Preconditions.requireNonNull(path));
        try {
            Field staticField = Typeface.class.getDeclaredField("SERIF");
            staticField.setAccessible(true);
            staticField.set(null, typeface);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Log.getStackTraceString(e);
        }
    }
}
