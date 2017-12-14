package com.cs18.anabeesh

import android.app.Application
import android.content.Context
import android.os.StrictMode
import com.cs18.anabeesh.di.application.AppComponent
import com.cs18.anabeesh.di.application.DaggerAppComponent
import timber.log.Timber

/**
 * This class represents Anabeesh Application.
 */

class AnabeeshApplication : Application() {

    private val appComponent: AppComponent = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        setStrictModeForDebugEnabled(true)
        setTimberDebugTreeEnabled(true)
    }

    /*
    * When enabled we should start logging using Timber class.
    * @see https://medium.com/@caueferreira/timber-enhancing-your-logging-experience-330e8af97341
    */
    private fun setTimberDebugTreeEnabled(enabled: Boolean) {
        if (enabled && BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    /*
     * When enabled it detects things you might be doing by accident and brings them to your attention so you can fix them.
     * Thread policy is used to catch accidental disk or network operations on the application's MAIN thread.
     * VmPolicy is used to detect when a closeable or other object with an explicit termination method is finalized without having been closed.
     */
    private fun setStrictModeForDebugEnabled(enabled: Boolean) {
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
        private fun getApp(context: Context): AnabeeshApplication {
            return context.applicationContext as AnabeeshApplication
        }
    }
}
