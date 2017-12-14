package com.cs18.anabeesh.di.application

import com.cs18.anabeesh.schedulers.*
import com.cs18.anabeesh.schedulers.qualifier.ComputationalThread
import com.cs18.anabeesh.schedulers.qualifier.IOThread
import com.cs18.anabeesh.schedulers.qualifier.MainThread
import com.cs18.anabeesh.schedulers.qualifier.NetworkThread
import dagger.Module
import dagger.Provides

/**
 * This class is responsible for providing the requested objects for [ThreadSchedulers] objects
 */

@Module
class SchedulersModule {

    @ApplicationScope
    @Provides
    @MainThread
    fun providesMainThreadSchedulers(): ThreadSchedulers = MainThreadSchedulers()

    @ApplicationScope
    @Provides
    @IOThread
    fun providesIOThreadSchedulers(): ThreadSchedulers = IOThreadSchedulers()

    @ApplicationScope
    @Provides
    @ComputationalThread
    fun providesComputationalThreadSchedulers(): ThreadSchedulers = ComputationalThreadSchedulers()

    @ApplicationScope
    @Provides
    @NetworkThread
    fun providesNetworkThreadSchedulers(): ThreadSchedulers = NetworkThreadSchedulers()
}