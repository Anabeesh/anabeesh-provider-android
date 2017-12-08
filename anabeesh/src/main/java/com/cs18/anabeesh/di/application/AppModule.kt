package com.cs18.anabeesh.di.application

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * This class is responsible for providing the requested objects for [ApplicationScope] objects
 */

@Module
class AppModule(private val application: Application) {

    @ApplicationScope
    @Provides
    fun provideApplication(): Application = application

    @ApplicationScope
    @Provides
    @ForApplication
    fun provideAppContext(): Context = application
}