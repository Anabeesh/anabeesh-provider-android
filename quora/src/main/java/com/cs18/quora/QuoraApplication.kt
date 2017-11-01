package com.cs18.quora

import android.app.Application
import android.os.StrictMode


class QuoraApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setStrictModeEnabledDebug(true)
    }

    private fun setStrictModeEnabledDebug(isEnabled: Boolean) {
        if (isEnabled) {
            if (BuildConfig.DEBUG) {
                StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                        .detectAll()
                        .penaltyLog()
                        .build())
                StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                        .detectAll()
                        .penaltyLog()
                        .build())
            }
        }
    }
}