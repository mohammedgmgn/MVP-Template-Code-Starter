package com.mahmoud.mohammed.mvpstarter.injection.component

import com.mahmoud.mohammed.mvpstarter.injection.PerFragment
import com.mahmoud.mohammed.mvpstarter.injection.module.FragmentModule
import dagger.Subcomponent

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent