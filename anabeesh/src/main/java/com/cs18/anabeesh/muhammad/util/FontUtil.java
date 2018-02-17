package com.cs18.anabeesh.muhammad.util;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

import timber.log.Timber;

public class FontUtil {

    public static void overRideDefaultMonoSpaceFont(Context context) {
        Typeface regular = Typeface.createFromAsset(context.getAssets(), "NeoSansArabic.ttf");
        replaceFont(regular);
    }

    private static void replaceFont(Typeface newTypeface) {
        try {
            Field staticField = Typeface.class
                    .getDeclaredField("MONOSPACE");
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Timber.e(e);
        }
    }
}