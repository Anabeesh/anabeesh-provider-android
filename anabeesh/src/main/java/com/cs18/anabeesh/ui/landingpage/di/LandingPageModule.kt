package com.cs18.anabeesh.ui.landingpage.di

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * This class is responsible for providing the requested objects for [LandingPageScope] objects
 */

@Module
class LandingPageModule(private val activity: Activity) {

    @LandingPageScope
    @Provides
    fun providesActivity(): Activity = activity

    @LandingPageScope
    @Provides
    @ForLandingPage
    fun providesActivityContext(): Context = activity
}