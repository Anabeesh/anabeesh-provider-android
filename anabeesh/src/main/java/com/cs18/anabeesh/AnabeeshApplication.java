package com.cs18.anabeesh;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.cs18.anabeesh.muhammad.di.application.AppComponent;
import com.cs18.anabeesh.muhammad.di.application.DaggerAppComponent;
import com.cs18.anabeesh.muhammad.util.FontUtil;

import timber.log.Timber;

/**
 This class represents Anabeesh Application.
 */

public class AnabeeshApplication extends Application {

    private final AppComponent appComponent = DaggerAppComponent.create();

    public static AppComponent getComponent(Context context) {
        return getApp(context).appComponent;
    }

    //This is a hack to get a non-static field from a static method (i.e. appComponent)
    private static AnabeeshApplication getApp(Context context) {
        return (AnabeeshApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent.inject(this);
        setStrictModeForDebugEnabled(true);
        setTimberDebugTreeEnabled(true);
        FontUtil.overRideDefaultMonoSpaceFont(this);
    }

    /*
    * When enabled we should start logging using Timber class.
    * learn more at https://medium.com/@caueferreira/timber-enhancing-your-logging-experience-330e8af97341
    */
    private void setTimberDebugTreeEnabled(boolean enabled) {
        if (enabled && BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
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
