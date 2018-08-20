package com.mahmoud.mohammed.mvpstarter.injection.component

import com.mahmoud.mohammed.mvpstarter.injection.PerActivity
import com.mahmoud.mohammed.mvpstarter.injection.module.ActivityModule
import com.mahmoud.mohammed.mvpstarter.features.base.BaseActivity
import com.mahmoud.mohammed.mvpstarter.features.detail.DetailActivity
import com.mahmoud.mohammed.mvpstarter.features.main.MainActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(detailActivity: DetailActivity)
}
