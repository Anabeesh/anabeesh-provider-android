package com.cs18.quora.di.application

import javax.inject.Qualifier

/**
 * This qualifier is used for distinguishing between similar objects for dependency injection.
 * (i.e. Activity context and App context), acts like [javax.inject.Named]
 */

@Qualifier
annotation class ForApplication
