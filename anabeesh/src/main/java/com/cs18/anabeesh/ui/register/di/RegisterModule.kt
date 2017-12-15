package com.cs18.anabeesh.ui.register.di

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * This class is responsible for providing the requested objects for [RegisterScope] objects
 */

@Module
class RegisterModule(private val activity: Activity) {

    @RegisterScope
    @Provides
    fun providesActivity(): Activity = activity

    @RegisterScope
    @Provides
    @ForRegister
    fun providesActivityContext(): Context = activity
}