package com.cs18.quora

import android.app.Application
import android.content.Context
import android.os.StrictMode
import com.cs18.quora.di.application.AppComponent
import com.cs18.quora.di.application.DaggerAppComponent

/**
 * This class represents Quora Application.
 */

class QuoraApplication : Application() {

    private val appComponent: AppComponent = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
        setStrictModeEnabledDebug(true)
        appComponent.inject(this)
    }

    /*
     * When enabled it detects things you might be doing by accident and brings them to your attention so you can fix them.
     * Thread policy is used to catch accidental disk or network operations on the application's MAIN thread.
     * VmPolicy is used to detect when a closeable or other object with an explicit termination method is finalized without having been closed.
     */
    private fun setStrictModeEnabledDebug(enabled: Boolean) {
        if (enabled && BuildConfig.DEBUG) {
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

    companion object {
        fun getComponent(context: Context): AppComponent {
            return getApp(context).appComponent
        }

        //This is a hack to get a non-static field from a static method (i.e. appComponent)
        private fun getApp(context: Context): QuoraApplication {
            return context.applicationContext as QuoraApplication
        }
    }
}
