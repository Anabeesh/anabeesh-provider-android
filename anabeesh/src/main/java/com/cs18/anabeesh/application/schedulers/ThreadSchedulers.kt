package com.cs18.anabeesh.application.schedulers

import io.reactivex.Scheduler

/**
 * This interface is implemented by different classes (i.e. [IOThreadSchedulers]) to define which ThreadSchedulers
 * should be used for RxJava's [io.reactivex.Observable.observeOn] and [io.reactivex.Observable.subscribeOn]
 */

interface ThreadSchedulers {

    fun observeOn(): Scheduler

    fun subscribeOn(): Scheduler
}