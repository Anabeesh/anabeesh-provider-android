package com.rxmuhammadyoussef.core.util;

import android.content.Context;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {

    private static final String HOUR_FORMAT_24 = "H:mm";
    private static final String HOUR_FORMAT_12 = "h:mm a";

    private final DateFormat hourFormatter;

    public TimeUtil(Context context) {
        boolean is24HourFormat = android.text.format.DateFormat.is24HourFormat(context);
        String format = is24HourFormat ? HOUR_FORMAT_24 : HOUR_FORMAT_12;
        hourFormatter = new SimpleDateFormat(format, Locale.getDefault());
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public String formatHour(long timeStamp) {
        return hourFormatter.format(new Date(timeStamp));
    }
}
