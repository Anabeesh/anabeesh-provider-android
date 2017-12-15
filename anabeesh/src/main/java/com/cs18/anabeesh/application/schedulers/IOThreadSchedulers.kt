package com.cs18.anabeesh.application.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Input/Output-specific Schedulers
 */

class IOThreadSchedulers : ThreadSchedulers {

    override fun observeOn(): Scheduler = AndroidSchedulers.mainThread()

    override fun subscribeOn(): Scheduler = Schedulers.io()

}