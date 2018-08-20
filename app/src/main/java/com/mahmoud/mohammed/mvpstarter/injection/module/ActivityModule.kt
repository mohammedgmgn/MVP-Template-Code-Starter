package com.mahmoud.mohammed.mvpstarter.injection.module

import android.app.Activity
import android.content.Context

import dagger.Module
import dagger.Provides
import com.mahmoud.mohammed.mvpstarter.injection.ActivityContext

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    internal fun provideActivity(): Activity {
        return activity
    }

    @Provides
    @ActivityContext
    internal fun providesContext(): Context {
        return activity
    }
}
