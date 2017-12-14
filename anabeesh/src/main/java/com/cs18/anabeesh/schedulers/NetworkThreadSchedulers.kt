package com.cs18.anabeesh.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Network operations-specific schedulers
 */

class NetworkThreadSchedulers : ThreadSchedulers {

    override fun observeOn(): Scheduler = AndroidSchedulers.mainThread()

    override fun subscribeOn(): Scheduler = Schedulers.newThread()

}