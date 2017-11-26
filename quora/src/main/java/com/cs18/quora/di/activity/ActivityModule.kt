package com.cs18.quora.di.activity

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * This class is responsible for providing the requested objects for [ActivityScope] objects
 */

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityScope
    fun providesActivity(): Activity = activity

    @ActivityScope
    @Provides
    @ForActivity
    fun providesActivityContext(): Context = activity
}