package com.cs18.anabeesh.muhammad.di.application;

import com.cs18.anabeesh.AnabeeshApplication;
import com.cs18.anabeesh.muhammad.di.activity.ActivityComponent;
import com.cs18.anabeesh.muhammad.di.activity.ActivityModule;

import dagger.Component;

/**
 This interface is used by dagger to generate the code that defines the connection between the provider of objects
 (i.e. {@link AppModule}), and the object which expresses a dependency.
 */

@ApplicationScope
@Component(
        modules = {AppModule.class, SchedulersModule.class}
)
public interface AppComponent {

    void inject(AnabeeshApplication anabeeshApplication);

    ActivityComponent plus(ActivityModule activityModule);
}
