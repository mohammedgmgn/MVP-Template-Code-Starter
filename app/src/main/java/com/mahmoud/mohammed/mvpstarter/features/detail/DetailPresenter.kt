package com.mahmoud.mohammed.mvpstarter.features.detail

import com.mahmoud.mohammed.mvpstarter.data.DataManager
import com.mahmoud.mohammed.mvpstarter.data.model.Pokemon
import com.mahmoud.mohammed.mvpstarter.features.base.BasePresenter
import com.mahmoud.mohammed.mvpstarter.injection.ConfigPersistent
import com.mahmoud.mohammed.mvpstarter.util.rx.scheduler.SchedulerUtils
import javax.inject.Inject

@ConfigPersistent
class DetailPresenter @Inject
constructor(private val dataManager: DataManager) : BasePresenter<DetailMvpView>() {

    fun getPokemon(name: String) {
        checkViewAttached()
        mvpView?.showProgress(true)
        dataManager.getPokemon(name)
                .compose<Pokemon>(SchedulerUtils.ioToMain<Pokemon>())
                .subscribe({ pokemon ->
                    // It should be always checked if MvpView (Fragment or Activity) is attached.
                    // Calling showProgress() on a not-attached fragment will throw a NPE
                    // It is possible to ask isAdded() in the fragment, but it's better to ask in the presenter
                    mvpView?.apply {
                        showProgress(false)
                        showPokemon(pokemon)
                        for (statistic in pokemon.stats) {
                            showStat(statistic)
                        }
                    }
                }) { throwable ->
                    mvpView?.apply {
                        showProgress(false)
                        showError(throwable)
                    }
                }
    }
}