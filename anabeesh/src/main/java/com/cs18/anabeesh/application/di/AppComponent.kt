package com.cs18.anabeesh.application.di

import com.cs18.anabeesh.application.AnabeeshApplication
import com.cs18.anabeesh.ui.login.di.LoginComponent
import com.cs18.anabeesh.ui.login.di.LoginModule
import dagger.Component

/**
 * This interface is used by dagger to generate the code that defines the connection between the provider of objects (i.e. [AppModule]),
 * and the object which expresses a dependency.
 */

@ApplicationScope
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(anabeeshApplication: AnabeeshApplication)

    fun plus(loginModule: LoginModule): LoginComponent
}