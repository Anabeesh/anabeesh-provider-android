package com.cs18.anabeesh.application.schedulers.qualifier

import javax.inject.Qualifier

/**
 * This qualifier is used for distinguishing between different [com.cs18.anabeesh.schedulers.ThreadSchedulers] for dependency injection.
 */

@Qualifier
annotation class IOThread