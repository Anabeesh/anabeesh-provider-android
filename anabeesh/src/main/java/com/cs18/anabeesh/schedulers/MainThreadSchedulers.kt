package com.cs18.anabeesh.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * MainThread-specific schedulers
 */

class MainThreadSchedulers : ThreadSchedulers {

    override fun observeOn(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun subscribeOn(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}