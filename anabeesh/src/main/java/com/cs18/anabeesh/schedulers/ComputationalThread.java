package com.cs18.anabeesh.schedulers;

import javax.inject.Qualifier;

/**
 This qualifier is used for distinguishing between different {@link ThreadSchedulers} for dependency injection.
 */

@Qualifier
public @interface ComputationalThread {
}
