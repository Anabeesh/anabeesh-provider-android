package com.cs18.anabeesh.ui.register.di

import javax.inject.Qualifier

/**
 * This qualifier is used for distinguishing between similar objects for dependency injection.
 * (i.e. Activity context and App context), acts like [javax.inject.Named]
 */

@Qualifier
annotation class ForRegister