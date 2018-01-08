package com.cs18.anabeesh.di.application;

import com.cs18.anabeesh.schedulers.ComputationalThread;
import com.cs18.anabeesh.schedulers.ComputationalThreadSchedulers;
import com.cs18.anabeesh.schedulers.IOThread;
import com.cs18.anabeesh.schedulers.IOThreadSchedulers;
import com.cs18.anabeesh.schedulers.MainThread;
import com.cs18.anabeesh.schedulers.MainThreadSchedulers;
import com.cs18.anabeesh.schedulers.ThreadSchedulers;

import dagger.Module;
import dagger.Provides;

/**
 This class is responsible for providing the requested objects for {@link ThreadSchedulers} objects
 */

@Module
public class SchedulersModule {

    @ApplicationScope
    @Provides
    @MainThread
    ThreadSchedulers providesMainThreadSchedulers() {
        return new MainThreadSchedulers();
    }

    @ApplicationScope
    @Provides
    @IOThread
    ThreadSchedulers providesIOThreadSchedulers() {
        return new IOThreadSchedulers();
    }

    @ApplicationScope
    @Provides
    @ComputationalThread
    ThreadSchedulers providesComputationalThreadSchedulers() {
        return new ComputationalThreadSchedulers();
    }
}
