package com.cs18.anabeesh.ui.login.di

import com.cs18.anabeesh.ui.login.core.LoginActivity
import dagger.Subcomponent

/**
 * This interface is used by dagger to generate the code that defines the connection between the provider of objects (i.e. [LoginModule]),
 * and the object which expresses a dependency.
 */

@LoginScope
@Subcomponent(modules = arrayOf(LoginModule::class))
interface LoginComponent {

    fun inject(loginActivity: LoginActivity)
}