package com.cs18.quora.di.application

import com.cs18.quora.QuoraApplication
import com.cs18.quora.di.activity.ActivityComponent
import com.cs18.quora.di.activity.ActivityModule
import dagger.Component

/**
 * This interface is used by dagger to generate the code that defines the connection between the provider of objects (i.e. [AppModule]),
 * and the object which expresses a dependency.
 */

@ApplicationScope
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(quoraApplication: QuoraApplication)

    fun plus(activityModule: ActivityModule): ActivityComponent
}