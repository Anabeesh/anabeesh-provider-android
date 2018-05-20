package com.cs18.anabeesh.salem.Others;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.cs18.anabeesh.BuildConfig;
import com.rxmuhammadyoussef.core.util.FontUtil;

import timber.log.Timber;

/**
 This class represents Anabeesh Application.
 */

public class AnabeeshApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FontUtil.overrideDefaultMonoSpaceFont(getAssets(), "NeoSansArabic.ttf");
        setStrictModeForDebugEnabled(true);
        setTimberDebugTreeEnabled();
    }

    /*
    * When enabled we should start logging using Timber class.
    * learn more at https://medium.com/@caueferreira/timber-enhancing-your-logging-experience-330e8af97341
    */
    private void setTimberDebugTreeEnabled() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        //TODO plant different tree for release (if needed)
    }

    /*
     * When enabled it detects things you might be doing by accident and brings them to your attention so you can fix them.
     * Thread policy is used to catch accidental disk or network operations on the application's MAIN thread.
     * VmPolicy is used to detect when a closeable or other object with an explicit termination method is finalized without having been closed.
     */
    private void setStrictModeForDebugEnabled(boolean enabled) {
        if (enabled && BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }
    }
}
