package com.mahmoud.mohammed.mvpstarter.common.injection.component

import dagger.Component
import com.mahmoud.mohammed.mvpstarter.common.injection.module.ApplicationTestModule
import com.mahmoud.mohammed.mvpstarter.injection.component.AppComponent
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationTestModule::class))
interface TestComponent : AppComponent