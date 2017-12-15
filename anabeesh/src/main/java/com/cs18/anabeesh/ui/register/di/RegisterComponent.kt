package com.cs18.anabeesh.ui.register.di

import com.cs18.anabeesh.ui.register.core.RegisterActivity
import dagger.Subcomponent

/**
 * This interface is used by dagger to generate the code that defines the connection between the provider of objects (i.e. [RegisterModule]),
 * and the object which expresses a dependency.
 */

@RegisterScope
@Subcomponent(modules = arrayOf(RegisterModule::class))
interface RegisterComponent {

    fun inject(registerActivity: RegisterActivity)
}