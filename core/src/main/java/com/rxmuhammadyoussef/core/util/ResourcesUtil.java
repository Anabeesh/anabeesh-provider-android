package com.rxmuhammadyoussef.core.util;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

public class ResourcesUtil {

    private final Context context;

    public ResourcesUtil(Context context) {this.context = context;}

    public String getString(@StringRes int resourceId) {
        return context.getString(resourceId);
    }

    public int getColor(@ColorRes int colorRes) {
        return ContextCompat.getColor(context, colorRes);
    }

    public Drawable getDrawable(@DrawableRes int resourceId) {
        return ContextCompat.getDrawable(context, resourceId);
    }

    public boolean isOrientationPortrait() {
        return Configuration.ORIENTATION_PORTRAIT == context.getResources().getConfiguration().orientation;
    }
}
