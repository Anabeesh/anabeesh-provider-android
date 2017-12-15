package com.cs18.anabeesh.ui.login.di

import android.app.Activity
import android.content.Context
import com.cs18.anabeesh.ui.login.core.LoginScreen
import dagger.Module
import dagger.Provides

/**
 * This class is responsible for providing the requested objects for [LoginScope] objects
 */

@Module
class LoginModule(private val activity: Activity) {

    @Provides
    @LoginScope
    fun providesActivity(): Activity = activity

    @LoginScope
    @Provides
    @ForLogin
    fun providesActivityContext(): Context = activity

    @LoginScope
    @Provides
    fun providesLoginScreen(): LoginScreen = activity as LoginScreen
}