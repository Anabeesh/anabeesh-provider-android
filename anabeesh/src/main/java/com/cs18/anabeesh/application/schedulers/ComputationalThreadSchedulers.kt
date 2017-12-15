package com.cs18.anabeesh.application.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Heavy computation-specific Schedulers
 */

class ComputationalThreadSchedulers : ThreadSchedulers {

    override fun observeOn(): Scheduler = AndroidSchedulers.mainThread()

    override fun subscribeOn(): Scheduler = Schedulers.computation()
}
