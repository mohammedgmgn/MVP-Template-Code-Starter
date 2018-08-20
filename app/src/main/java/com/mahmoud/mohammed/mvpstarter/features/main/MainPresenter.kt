package com.mahmoud.mohammed.mvpstarter.features.main

import com.mahmoud.mohammed.mvpstarter.data.DataManager
import com.mahmoud.mohammed.mvpstarter.features.base.BasePresenter
import com.mahmoud.mohammed.mvpstarter.injection.ConfigPersistent
import com.mahmoud.mohammed.mvpstarter.util.rx.scheduler.SchedulerUtils
import javax.inject.Inject

@ConfigPersistent
class MainPresenter @Inject
constructor(private val dataManager: DataManager) : BasePresenter<MainMvpView>() {

    fun getPokemon(limit: Int) {
        checkViewAttached()
        mvpView?.showProgress(true)
        dataManager.getPokemonList(limit)
                .compose(SchedulerUtils.ioToMain<List<String>>())
                .subscribe({ pokemons ->
                    mvpView?.apply {
                        showProgress(false)
                        showPokemon(pokemons)
                    }
                }) { throwable ->
                    mvpView?.apply {
                        showProgress(false)
                        showError(throwable)
                    }
                }
    }
}