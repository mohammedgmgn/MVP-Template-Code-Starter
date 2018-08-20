package com.mahmoud.mohammed.mvpstarter.util.rx.scheduler

/**
 * Created by Siko on 2/6/17.
 */

object SchedulerUtils {

    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }
}
