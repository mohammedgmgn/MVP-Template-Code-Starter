package com.mahmoud.mohammed.mvpstarter.injection.component

import dagger.Component
import com.mahmoud.mohammed.mvpstarter.features.base.BaseActivity
import com.mahmoud.mohammed.mvpstarter.features.base.BaseFragment
import com.mahmoud.mohammed.mvpstarter.injection.ConfigPersistent
import com.mahmoud.mohammed.mvpstarter.injection.module.ActivityModule
import com.mahmoud.mohammed.mvpstarter.injection.module.FragmentModule

/**
 * A dagger component that will live during the lifecycle of an Activity or Fragment but it won't
 * be destroy during configuration changes. Check [BaseActivity] and [BaseFragment] to
 * see how this components survives configuration changes.
 * Use the [ConfigPersistent] scope to annotate dependencies that need to survive
 * configuration changes (for example Presenters).
 */
@ConfigPersistent
@Component(dependencies = [AppComponent::class])
interface ConfigPersistentComponent {

    fun activityComponent(activityModule: ActivityModule): ActivityComponent

    fun fragmentComponent(fragmentModule: FragmentModule): FragmentComponent

}
