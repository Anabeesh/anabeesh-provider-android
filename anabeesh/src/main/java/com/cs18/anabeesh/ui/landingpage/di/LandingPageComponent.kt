package com.cs18.anabeesh.ui.landingpage.di

import com.cs18.anabeesh.ui.landingpage.core.LandingPageActivity
import dagger.Subcomponent

/**
 * This interface is used by dagger to generate the code that defines the connection between the provider of objects (i.e. [LandingPageModule]),
 * and the object which expresses a dependency.
 */

@LandingPageScope
@Subcomponent(modules = arrayOf(LandingPageModule::class))
interface LandingPageComponent {

    fun inject(landingPageActivity: LandingPageActivity)
}