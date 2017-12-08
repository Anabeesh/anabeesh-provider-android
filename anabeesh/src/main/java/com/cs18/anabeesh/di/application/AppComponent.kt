package com.cs18.anabeesh.di.application

import com.cs18.anabeesh.AnabeeshApplication
import com.cs18.anabeesh.di.activity.ActivityComponent
import com.cs18.anabeesh.di.activity.ActivityModule
import dagger.Component

/**
 * This interface is used by dagger to generate the code that defines the connection between the provider of objects (i.e. [AppModule]),
 * and the object which expresses a dependency.
 */

@ApplicationScope
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(anabeeshApplication: AnabeeshApplication)

    fun plus(activityModule: ActivityModule): ActivityComponent
}