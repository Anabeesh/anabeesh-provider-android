package com.cs18.anabeesh.di.activity

import dagger.Subcomponent

/**
 * This interface is used by dagger to generate the code that defines the connection between the provider of objects (i.e. [ActivityModule]),
 * and the object which expresses a dependency.
 */

@ActivityScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent