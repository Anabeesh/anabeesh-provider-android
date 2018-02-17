package com.cs18.anabeesh.muhammad.di.activity;

import android.app.Activity;
import android.content.Context;

import com.cs18.anabeesh.muhammad.ui.home.HomeScreen;

import dagger.Module;
import dagger.Provides;

/**
 This class is responsible for providing the requested objects to {@link ActivityScope} annotated classes
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {this.activity = activity;}

    @ActivityScope
    @Provides
    Activity provideActivity() {
        return activity;
    }

    @ActivityScope
    @Provides
    @ForActivity
    Context provideActivityContext() {
        return activity;
    }

    @ActivityScope
    @Provides
    HomeScreen providesHomeScreen() {
        return (HomeScreen) activity;
    }
}
